package boundary.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("sounds")
public class PingResource {

    @GET
    @Path("ping")
    public String ping() {
        return "dit was eerst ping!";
    }


    @GET
    @Path("bleep")
    public String bleep(){return "zelfgemaakt link!";}
}
