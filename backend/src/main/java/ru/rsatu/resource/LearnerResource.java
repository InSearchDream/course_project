package ru.rsatu.resource;

import ru.rsatu.pojo.Learner;
import ru.rsatu.service.LearnerService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/learners")
public class LearnerResource {

    @Inject
    LearnerService ls;

    @RolesAllowed({"watchSSL"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getLearners")
    public Response getLearners(){
        return Response.ok(ls.getLearners()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_learner}")
    public Response getLearnerById(@PathParam("id_learner") Long id_learner){
        return Response.ok(ls.getLearnerById(id_learner)).build();
    }

    @RolesAllowed({"editLearner", "addLearner"})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertLearner")
    public Response insertLearner(Learner tr){
        return Response.ok(ls.insertLearner(tr)).build();
    }

    @RolesAllowed({"editLearner"})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateLearner")
    public Response updateLearner(Learner tr){
        return Response.ok(ls.updateLearner(tr)).build();
    }

    @RolesAllowed({"editLearner"})
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_learner}")
    public Response deleteLearner(@PathParam("id_learner") Long id_learner){
        ls.deleteLearner(id_learner);
        return Response.ok().build();
    }

}
