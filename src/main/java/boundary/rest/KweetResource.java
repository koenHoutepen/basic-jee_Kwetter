package boundary.rest;

import Services.KweetService;
import Services.ProfileService;
import controller.domain.Kweet;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/kweets")
public class KweetResource {
    @Inject
    KweetService service;
    @Inject
    ProfileService profileService;

    @GET
    public Map<Long, Kweet> getCompleteMap() {
        return this.service.getKweetMap();
    }

    @GET
    @Path("/list")
    public List<Kweet> getCompleteList() {
        return this.service.getKweetList();
    }

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    public Kweet getKweet(@PathParam("id") Long id) throws Exception {
        return this.service.getKweet(id);
    }

    @POST
    @Path("/kweetPost")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addKweet(Kweet kweet) {

        try {
            profileService.addKweet(kweet, profileService.getMappedProfile(kweet.getOwner().getUsername()));
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User doesn't exists")
                    .type(MediaType.TEXT_HTML)
                    .build();
        }

        return Response.ok(kweet)
                .build();
    }

//    @DELETE
//    @Path("/kweetDelete")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response deleteKweet(Kweet kweet)
//    {
////        try {
////            service.deleteKweet(kweet.getKweetId());
////        } catch (Exception e) {
////            return Response.status(Response.Status.NOT_FOUND)
////                    .entity("User doesn't exists")
////                    .type(MediaType.TEXT_HTML)
////                    .build();
////        }
//
//        return Response.ok("kweet verwijdert kom ik in " + kweet.getKweetId())
//                .build();
//    }

    @DELETE
    @Path("/kweetDelete/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    public Response deleteKweetById(@PathParam("id") Long id) {
        try {
            service.deleteKweet(id);
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User doesn't exists")
                    .type(MediaType.TEXT_HTML)
                    .build();
        }

        return Response.ok("kweet verwijdert: " + id)
                .build();
    }

}
