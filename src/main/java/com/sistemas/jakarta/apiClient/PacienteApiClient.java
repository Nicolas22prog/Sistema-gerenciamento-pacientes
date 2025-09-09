package com.sistemas.jakarta.apiClient;

import com.sistemas.jakarta.dtos.CreatePacienteDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/paciente")
@RegisterRestClient(configKey = "api-client")
public interface PacienteApiClient {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Long createPaciente(CreatePacienteDTO paciente);
}
