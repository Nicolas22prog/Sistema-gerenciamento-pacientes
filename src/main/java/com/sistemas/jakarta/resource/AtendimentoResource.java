package com.sistemas.jakarta.resource;

import com.sistemas.jakarta.dtos.CreateAtendimentoDTO;
import com.sistemas.jakarta.dtos.UpdateAtendimentoDTO;
import com.sistemas.jakarta.entity.Atendimentos;
import com.sistemas.jakarta.service.AtendimentoService;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/atendimentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AtendimentoResource {

    @Inject
    private AtendimentoService atendimentoService;

    @POST
    public Response criarAtendimento(CreateAtendimentoDTO dto) throws Exception {
        Long id = atendimentoService.criarAtendimento(dto);
        JsonObject payload = Json.createObjectBuilder()
                .add("id", id)
                .build();
        return Response.status(Response.Status.CREATED).entity(payload).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarAtendimento(@PathParam("id") Long id, UpdateAtendimentoDTO dto) throws Exception {
        Atendimentos atualizado = atendimentoService.atualizarAtendimento(id, dto);
        return Response.ok(atualizado).build();
    }

    @GET
    public List<Atendimentos> listarTodos() {
        return atendimentoService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) throws Exception {
        Atendimentos atendimento = atendimentoService.buscarPorId(id)
                .orElseThrow(() -> new WebApplicationException("Atendimento não encontrado", Response.Status.NOT_FOUND));
        return Response.ok(atendimento).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removerAtendimento(@PathParam("id") Long id) throws Exception {
        atendimentoService.removerAtendimento(id);
        return Response.noContent().build();
    }
}
