package org.dronefeeder.commons;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GeneralException implements ExceptionMapper<Exception> {

  @Override
  @Produces(MediaType.APPLICATION_JSON)
  public Response toResponse(Exception e) {
    DataError dataError = new DataError();

    if (e instanceof DroneNaoEncontradoException) {
      dataError.setError(e.getMessage());
      return Response.status(Status.NOT_FOUND).entity(dataError).build();
    }

    if (e instanceof EntidadeNaoEncontradaException) {
      dataError.setError(e.getMessage());
      return Response.status(Status.NOT_FOUND).entity(dataError).build();
    }

    if (e instanceof EntidadeExistenteException) {
      dataError.setError(e.getMessage());
      return Response.status(Status.CONFLICT).entity(dataError).build();
    }

    if (e instanceof DroneVideoNaoEncontradoException) {
      dataError.setError(e.getMessage());
      return Response.status(Status.NOT_FOUND).entity(dataError).build();
    }
    dataError.setError(e.getMessage());
    return Response.status(Status.INTERNAL_SERVER_ERROR).entity(dataError).build();
  }
}
