package com.sistemas.jakarta.resource;

import com.sistemas.jakarta.dtos.CreatePacienteDTO;
import com.sistemas.jakarta.service.CadastroPacienteService;
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
@Path("/paciente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CadastroPacienteResource implements Serializable {

    @Inject
    private CadastroPacienteService pacienteService;

    @POST
    @Path("/create")
    public Response create(@Valid CreatePacienteDTO request) throws Exception{
        Long newPaciente = pacienteService.cadastrarPaciente(request);
        
        JsonObject payload = Json.createObjectBuilder()
                .add("IDUser", newPaciente)
                .build();
        return Response.ok(payload).build();
    }
    
}
