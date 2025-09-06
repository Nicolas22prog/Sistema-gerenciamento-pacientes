package com.sistemas.jakarta.resource;

import com.sistemas.jakarta.dtos.CreatePacienteDTO;
import com.sistemas.jakarta.entity.Paciente;
import com.sistemas.jakarta.repository.CadastroPacienteRepository;
import com.sistemas.jakarta.service.CadastroPacienteService;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.io.Serializable;
import java.util.Optional;

/**
 * @author Nicolas
 */
@Path("/paciente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PacienteResource implements Serializable {

    @Inject
    private CadastroPacienteService pacienteService;

    @Inject
    private CadastroPacienteRepository pacienteRepository;

    @POST
    @Path("/create")
    public Response create(@Valid CreatePacienteDTO request) throws Exception {
        Long newPaciente = pacienteService.cadastrarPaciente(request);

        JsonObject payload = Json.createObjectBuilder()
                .add("IDUser", newPaciente)
                .build();
        return Response.ok(payload).build();
    }

    @GET
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPaciente(@QueryParam("cpf") long cpf) {
        return pacienteRepository.findByCpf(cpf)
                .map(p -> Response.ok(p).build()) // se encontrar, retorna 200 + JSON do Paciente
                .orElse(Response.status(Response.Status.NOT_FOUND).build()); // se não, 404
    }
}