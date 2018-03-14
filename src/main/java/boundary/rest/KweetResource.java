package boundary.rest;

import Services.KweetService;
import controller.domain.Kweet;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.Map;

@Path("kweets")
public class KweetResource {
    @Inject
    KweetService service;

    public KweetResource()
    {

    }

    @GET
    @Path("map")
    public Map<Long , Kweet> getCompleteMap()
    {
        return this.service.getKweetMap();
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Kweet getKweet(@PathParam("id") Long id) throws Exception {
        return this.service.getKweet(id);
    }
}
