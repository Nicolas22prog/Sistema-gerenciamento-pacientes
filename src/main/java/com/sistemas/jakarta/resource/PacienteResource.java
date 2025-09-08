package com.sistemas.jakarta.resource;

import com.sistemas.jakarta.dtos.CreatePacienteDTO;
import com.sistemas.jakarta.dtos.UpdatePacienteDTO;
import com.sistemas.jakarta.entity.Paciente;
import com.sistemas.jakarta.repository.CadastroPacienteRepository;
import com.sistemas.jakarta.service.CadastroPacienteService;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.io.Serializable;
import java.util.List;
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

    // Criar paciente
    @POST
    @Path("/create")
    public Response createPaciente(@Valid CreatePacienteDTO request) throws Exception {
        Long id = pacienteService.cadastrarPaciente(request);
        JsonObject payload = Json.createObjectBuilder()
                .add("id", id)
                .build();
        return Response.ok(payload).build();
    }

    // Atualizar paciente
    @PUT
    @Path("/update/{cpf}")
    public Response atualizarPaciente(
            @PathParam("cpf") Long cpf,
            @Valid UpdatePacienteDTO request) {

        try {
            Paciente pacienteAtualizado = pacienteService.atualizarPaciente(cpf, request);

            JsonObject payload = Json.createObjectBuilder()
                    .add("id", pacienteAtualizado.getId())
                    .add("nome", pacienteAtualizado.getNome())
                    .add("cpf", pacienteAtualizado.getCpf())
                    .add("endereco", pacienteAtualizado.getEndereco() != null ? pacienteAtualizado.getEndereco() : "")
                    .add("email", pacienteAtualizado.getEmail() != null ? pacienteAtualizado.getEmail() : "")
                    .add("dataNasc", pacienteAtualizado.getDataNasc() != null ? pacienteAtualizado.getDataNasc().toString() : "")
                    .add("dataInicio", pacienteAtualizado.getDataInicio() != null ? pacienteAtualizado.getDataInicio().toString() : "")
                    .build();

            return Response.ok(payload).build();

        } catch (Exception e) {
            JsonObject error = Json.createObjectBuilder()
                    .add("error", e.getMessage())
                    .build();
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }

    // Deletar paciente
    @DELETE
    @Path("/delete/{cpf}")
    public Response deletePaciente(@PathParam("cpf") Long cpf) throws Exception {
        pacienteService.deletarPaciente(cpf);
        JsonObject payload = Json.createObjectBuilder()
                .add("mensagem", "Paciente removido com sucesso")
                .build();
        return Response.ok(payload).build();
    }

    // Buscar paciente por CPF
    @GET
    @Path("/{cpf}")
    public Response getPaciente(@PathParam("cpf") Long cpf) throws Exception {
        Optional<Paciente> pacienteOpt = pacienteService.buscarPacientePorCpf(cpf);
        if (pacienteOpt.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(Json.createObjectBuilder()
                            .add("erro", "Paciente não encontrado")
                            .build())
                    .build();
        }

        Paciente paciente = pacienteOpt.get();
        JsonObject payload = Json.createObjectBuilder()
                .add("id", paciente.getId())
                .add("nome", paciente.getNome())
                .add("cpf", paciente.getCpf())
                .add("endereco", paciente.getEndereco() != null ? paciente.getEndereco() : "")
                .add("email", paciente.getEmail() != null ? paciente.getEmail() : "")
                .add("dataNasc", paciente.getDataNasc() != null ? paciente.getDataNasc().toString() : "")
                .add("dataInicio", paciente.getDataInicio() != null ? paciente.getDataInicio().toString() : "")
                .build();
        return Response.ok(payload).build();
    }

    // Listar todos os pacientes
    @GET
    @Path("/all")
    public Response getTodosPacientes() {
        List<Paciente> pacientes = pacienteService.listarTodosPacientes();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Paciente paciente : pacientes) {
            arrayBuilder.add(Json.createObjectBuilder()
                    .add("id", paciente.getId())
                    .add("nome", paciente.getNome())
                    .add("cpf", paciente.getCpf())
                    .add("endereco", paciente.getEndereco() != null ? paciente.getEndereco() : "")
                    .add("email", paciente.getEmail() != null ? paciente.getEmail() : "")
                    .add("dataNasc", paciente.getDataNasc() != null ? paciente.getDataNasc().toString() : "")
                    .add("dataInicio", paciente.getDataInicio() != null ? paciente.getDataInicio().toString() : "")
            );
        }
        return Response.ok(arrayBuilder.build()).build();
    }
}
