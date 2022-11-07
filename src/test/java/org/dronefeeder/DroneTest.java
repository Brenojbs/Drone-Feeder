package org.dronefeeder;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.quarkus.test.junit.QuarkusTest;
import java.util.Arrays;
import java.util.List;
import org.dronefeeder.dto.DroneDto;
import org.dronefeeder.entity.DroneEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class DroneTest {

  @Test
  @Order(1)
  @DisplayName("1 - Cria o drone com sucesso.")
  public void testCriaDrone() {
    DroneDto drone = new DroneDto();
    drone.setCoordenadas("0, 0");
    drone.setOcupado(false);

    given()
        .contentType("application/json")
        .body(drone)
        .when()
        .post("/drone")
        .then()
        .statusCode(201);
  }

  @Test
  @Order(2)
  @DisplayName("2 - Edita um drone com sucesso.")
  public void testEditarDrone() {
    testCriaDrone(); // Cria um drone para o teste

    DroneDto drone = new DroneDto();
    drone.setOcupado(true); // Altera o drone

    given()
        .contentType("application/json")
        .body(drone)
        .when()
        .patch("/drone/1")
        .then()
        .statusCode(200);
  }

  @Test
  @Order(3)
  @DisplayName("3 - Deleta um drone com sucesso.")
  public void testDeletarDrone() {
    given()
        .when()
        .delete("/drone/1")
        .then()
        .statusCode(200);
  }

  @Test
  @Order(4)
  @DisplayName("4 - Endpoint '/get' trás a lista de todos os drones.")
  public void testListarDrones() {
    testCriaDrone(); // Cria um drone para o teste

    List<DroneEntity> droneList = Arrays.asList(
        given()
            .when()
            .get("/drone")
            .as(DroneEntity[].class));

    assertEquals(2, droneList.size());
  }

  @Test
  @Order(5)
  @DisplayName("5 - Endpoint '/get/id' seleciona um drone.")
  public void testBuscarDrone() {
    given()
        .when()
        .get("/drone/1")
        .then()
        .statusCode(200);
  }

  @Test
  @Order(6)
  @DisplayName("6 - Chama a Exception ao deletar drone inexistente.")
  public void testDeletarDroneInvalido() {
    given()
        .when()
        .delete("/drone/99")
        .then()
        .statusCode(404);
  }

  @Test()
  @Order(7)
  @DisplayName("7 - Chama a Exception ao buscar drone inexistente.")
  public void testBuscarDroneInvalido() {
    given()
        .when()
        .get("/drone/99")
        .then()
        .statusCode(404);
  }

  @Test()
  @Order(8)
  @DisplayName("8 - Chama a Exception ao editar drone inexistente.")
  public void testEditarDroneInvalido() {
    DroneDto drone = new DroneDto();
    drone.setOcupado(true); // Altera o drone

    given()
        .contentType("application/json")
        .body(drone)
        .when()
        .patch("/drone/99")
        .then()
        .statusCode(404);
  }
}
