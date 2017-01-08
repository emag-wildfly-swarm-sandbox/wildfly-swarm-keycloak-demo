package wildflyswarm;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.keycloak.Secured;

public class Bootstrap {

  public static void main(String[] args) throws Exception {
    Swarm swarm = new Swarm();

    JAXRSArchive archive = ShrinkWrap.create(JAXRSArchive.class);
    archive.addPackage("wildflyswarm.keycloak");

    archive.as(Secured.class)
      .protect("/secret-a")
      .withRole("role-a");
    archive.as(Secured.class)
      .protect("/secret-b")
      .withRole("role-b");

    swarm.start(archive);
  }

}
