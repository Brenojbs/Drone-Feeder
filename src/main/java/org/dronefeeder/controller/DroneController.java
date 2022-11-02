package org.dronefeeder.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.dronefeeder.dto.DroneDto;
import org.dronefeeder.service.DroneService;

@Path("/drone")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DroneController {

  @Inject
  DroneService service;

  @GET
  public Response listar() {
    return Response.ok(service.listar()).build();
  }

  @GET
  @Path("/{id}")
  public Response buscarId(@PathParam("id") Long id) {
    return Response.ok(service.buscarId(id)).build();
  }

  @POST
  public Response salvar(DroneDto dto) {
    service.salvar(dto);
    return Response.status(Status.CREATED).build();
  }

  @PATCH
  @Path("/{id}")
  public Response editar(@PathParam("id") Long id, DroneDto dto) {
    service.editar(id, dto);
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  public Response deletar(@PathParam("id") Long id) {
    service.deletar(id);
    return Response.ok().build();
  }
}
