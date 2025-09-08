package com.sistemas.jakarta.resource;

import com.sistemas.jakarta.dtos.CreateProfissionalDTO;
import com.sistemas.jakarta.dtos.UpdateProfissionalDTO;
import com.sistemas.jakarta.entity.Profissional;
import com.sistemas.jakarta.service.ProfissionalService;
import jakarta.inject.Inject;
import jakarta.json.Json;
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
@Path("/profissional")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfissionalResource implements Serializable {

    @Inject
    private ProfissionalService profissionalService;

    @POST
    @Path("/create")
    public Response createProfissional(@Valid CreateProfissionalDTO request) throws Exception {
        Long newProfissional = profissionalService.cadastrarProfissional(request);
        JsonObject payload = Json.createObjectBuilder()
                .add("IDUser", newProfissional)
                .build();
        return Response.ok(payload).build();
    }

    @GET
    @Path("/{id}")
    public Response getProfissionalById(@PathParam("id") Long id) {
        Optional<Profissional> profissional = profissionalService.buscarPorId(id);
        if (profissional.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(profissional.get()).build();
    }

    @GET
    @Path("/registro/{registro}")
    public Response getProfissionalByRegistro(@PathParam("registro") String registro) {
        Optional<Profissional> profissional = profissionalService.buscarPorRegistro(registro);
        if (profissional.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(profissional.get()).build();
    }

    @GET
    public Response getAllProfissionais() {
        List<Profissional> profissionais = profissionalService.listarTodos();
        return Response.ok(profissionais).build();
    }

    @PUT
    @Path("/update/{id}")
    public Response updateProfissional(
            @PathParam("id") Long id,
            @Valid UpdateProfissionalDTO request) {

        try {
            Profissional updated = profissionalService.atualizarProfissional(id, request);

            JsonObject payload = Json.createObjectBuilder()
                    .add("id", updated.getId())
                    .add("nome", updated.getNome() != null ? updated.getNome() : "")
                    .add("tipoRegistro", updated.getTipoRegistro() != null ? updated.getTipoRegistro() : "")
                    .add("registro", updated.getRegistro() != null ? updated.getRegistro() : "")
                    .add("especialidade", updated.getEspecialidade() != null ? updated.getEspecialidade() : "")
                    .add("dataCriacao", updated.getDataCriacao() != null ? updated.getDataCriacao().toString() : "")
                    .build();

            return Response.ok(payload).build();
        } catch (Exception e) {
            JsonObject error = Json.createObjectBuilder()
                    .add("error", e.getMessage())
                    .build();
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProfissional(@PathParam("id") Long id) throws Exception {
        profissionalService.removerProfissional(id);
        return Response.noContent().build();
    }
}
