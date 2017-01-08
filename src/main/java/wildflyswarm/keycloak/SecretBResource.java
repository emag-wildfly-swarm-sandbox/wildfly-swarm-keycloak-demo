package wildflyswarm.keycloak;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/secret-b")
public class SecretBResource {

  @GET
  public String get() {
    return "Secret B";
  }

}
