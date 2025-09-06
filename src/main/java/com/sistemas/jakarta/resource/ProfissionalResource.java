package com.sistemas.jakarta.resource;

import com.sistemas.jakarta.dtos.CreateProfissionalDTO;
import com.sistemas.jakarta.service.ProfissionalService;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.io.Serializable;

/**
 * @author Nicolas
 */
@Path("/profissional")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfissionalResource implements Serializable {

    @Inject
    private ProfissionalService profissionalService;

    @POST
    @Path("/create")
    public Response createProfissional(@Valid CreateProfissionalDTO request) throws Exception{
        Long newProfissional = profissionalService.cadastrarProfissional(request);
        JsonObject payload = Json.createObjectBuilder()
                .add("IDUser", newProfissional)
                .build();
        return Response.ok(payload).build();
    }

}
