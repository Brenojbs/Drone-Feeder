package org.dronefeeder;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.dronefeeder.dto.DroneDto;
import org.dronefeeder.dto.EntregaDto;
import org.dronefeeder.entity.EntregaEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;


@QuarkusTest
public class EntregaTest {

  @Test
  @Order(9)
  @DisplayName("9 - Cria a Entrega com sucesso.")
  public void testCriaEntrega() {

    EntregaDto entrega = new EntregaDto();

    DroneDto drone = new DroneDto();
    drone.setCoordenadas("0, 0");
    drone.setOcupado(false);

    given().contentType("application/json").body(drone).when().post("/drone").then()
        .statusCode(201);

    entrega.setDestinatario("Rua Estrada Travessa");
    entrega.setEndereço("Estrada Santa Catapimba");

    // "Separação", "Em transito" e "Entregue"
    entrega.setStatusEntrega("Separação");

    given().contentType("application/json").body(entrega).when().post("/entrega").then()
        .statusCode(201);
  }

   @Test
   @Order(10)
   @DisplayName("10 - Endpoint '/get' trás a lista de todos as Entregas.")
   public void testListarEntregas() {

   this.testCriaEntrega(); // Cadastra 1 Entrega.

   List<EntregaEntity> entregaList =
   Arrays.asList(given().when().get("/entrega").as(EntregaEntity[].class));
   assertEquals(1, entregaList.size());
   }

  @Test
  @Order(11)
  @DisplayName("11 - Endpoint '/get/id' trás uma Entrega.")
  public void testBuscarEntrega() {
    given().when().get("/entrega/1").then().statusCode(200);
  }

  @Test
  @Order(12)
  @DisplayName("12 - Deleta uma Entrega com sucesso.")
  public void testDeletarEntrega() {
    this.testCriaEntrega();
    given().when().delete("/entrega/1").then().statusCode(200);
  }

  @Test
  @Order(13)
  @DisplayName("13 - Exception ao deletar Entrega inexistente.")
  public void testDeletarEntregaInvalido() {

    given().when().delete("/entrega/99").then().statusCode(404);
  }

  @Test()
  @Order(14)
  @DisplayName("14 - Exception ao buscar Entrega inexistente.")
  public void testBuscarEntregaInvalido() {
    given().when().get("/entrega/aaaa").then().statusCode(500);
  }

  @Test()
  @Order(15)
  @DisplayName("15 - Exception ao editar Entrega inexistente.")
  public void testEditarEntregaInvalido() {
    EntregaDto entrega = new EntregaDto();
    entrega.setDestinatario("Rua veia!"); // Altera a Entrega

    given().contentType("application/json").body(entrega).when().patch("/entrega/1").then()
        .statusCode(404);
  }
}
