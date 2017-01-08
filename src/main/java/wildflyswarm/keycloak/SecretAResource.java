package wildflyswarm.keycloak;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/secret-a")
public class SecretAResource {

  @GET
  public String get() {
    return "Secret A";
  }

}
