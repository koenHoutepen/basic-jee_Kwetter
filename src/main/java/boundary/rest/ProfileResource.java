package boundary.rest;

import Services.ProfileService;
import controller.domain.Profile;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("profiles")
public class ProfileResource {
    @Inject
    ProfileService service;

    public ProfileResource()
    {

    }

    @GET
    @Path("list")
    public List<Profile> getAll() {
        return this.service.getProfiles();
    }

    @GET
    @Path("{name}")
    @Produces({"application/json"})
    public Profile getProfile(@PathParam("name") String name) throws Exception {
        Profile profile = this.service.getProfile(name);
        return profile;
    }
}
