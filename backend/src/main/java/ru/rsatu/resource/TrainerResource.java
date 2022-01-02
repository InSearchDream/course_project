package ru.rsatu.resource;

import ru.rsatu.pojo.Trainer;
import ru.rsatu.service.TrainerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/trainer")
public class TrainerResource {

    @Inject
    TrainerService ts;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTrainers")
    public Response getTrainers(){
        return Response.ok(ts.getTrainers()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTrainerById")
    public Response getTrainerById(@QueryParam("id_trainer") Long id_trainer){
        return Response.ok(ts.getTrainerById(id_trainer)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertTrainer")
    public Response insertTrainer(Trainer tr){
        return Response.ok(ts.insertTrainer(tr)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateTrainer")
    public Response updateTrainer(Trainer tr){
       // System.out.println("trainer " + tr.getLast_name()+ ' ' + tr.getFirst_name());
        return Response.ok(ts.updateTrainer(tr)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteTrainer")
    public Response deleteTrainer(@QueryParam("id_trainer") Long id_trainer){
        ts.deleteTrainer(id_trainer);
        return Response.ok().build();
    }

}
