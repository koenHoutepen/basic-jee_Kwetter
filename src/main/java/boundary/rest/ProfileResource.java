package boundary.rest;

import Services.ProfileService;
import controller.domain.Profile;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("profiles")
public class ProfileResource {
    @Inject
    ProfileService service;

    @GET
    @Path("/list")
    public List<Profile> getAll() {
        return this.service.getProfiles();
    }

    @GET
    @Path("/map")
    public Map<String , Profile> getCompleteMap()
    {
       return this.service.getProfileMap();
    }

    @GET
    @Path("/{name}")
    @Produces({"application/json"})
    public Profile getProfile(@PathParam("name") String name) throws Exception {
        return this.service.getMappedProfile(name);
    }

    @POST
    @Path("/profilePost")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProfile(Profile profile)
    {
        Profile newProfile;
        try
        {
            service.addProfile(profile);
        }
        catch (Exception e)
        {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User doesn't exists")
                    .type(MediaType.TEXT_HTML)
                    .build();
        }

        return Response.ok(profile)
                .build();
    }

//    @DELETE
//    @Path("/profileDelete")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response deleteProfile(Profile profile)
//    {
////        try
////        {
////            service.deleteProfile(profile);
////        }
////        catch (Exception e)
////        {
////            return Response.status(Response.Status.NOT_FOUND)
////                    .entity("User doesn't exists")
////                    .type(MediaType.TEXT_HTML)
////                    .build();
////        }
//
//        return Response.ok("Ik kom in delete")
//                .build();
//    }

    @DELETE
    @Path("/profileDelete/{username}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    public Response deleteProfileByUsername(@PathParam("username") String username) {
        try
        {
            Profile deleteProfile = service.getMappedProfile(username);
            service.deleteProfile(deleteProfile);
        }
        catch (Exception e)
        {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User doesn't exists or " + e.getMessage())
                    .type(MediaType.TEXT_HTML)
                    .build();
        }

        return Response.ok("profiel: " + username + " verwijdert")
                .build();
    }

}
