package org.dronefeeder;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.dronefeeder.dto.DroneVideoDto;
import org.dronefeeder.entity.DroneVideoEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class DroneVideoTest {

  @Test
  @Order(16)
  @DisplayName("16 - Endpoint salva um DroneVideo.")
  public void testSalvarDroneVideo() {
    DroneVideoDto droneVideo = new DroneVideoDto();
    droneVideo.setUrl("https://www.youtube.com/watch?v=A9Y8mqrIKCQ");

    given().contentType("application/json").body(droneVideo).when().post("/drone/video").then()
        .statusCode(201);
  }

  @Test
  @Order(17)
  @DisplayName("17 - Endpoint '/get' trás lista de DroneVideo.")
  public void testListarDroneVideo() {
    DroneVideoDto droneVideo = new DroneVideoDto();
    droneVideo.setUrl("https://www.youtube.com/watch?v=A9Y8mqrIKCQ");

    given().contentType("application/json").body(droneVideo).when().post("/drone/video").then()
        .statusCode(201);

    List<DroneVideoEntity> droneVideoCadastrado =
        Arrays.asList(given().when().get("/drone/video/").as(DroneVideoEntity[].class));

    assertEquals(1, droneVideoCadastrado.size());
  }

  @Test
  @Order(18)
  @DisplayName("18 - Endpoint '/get/id' trás um DroneVideo.")
  public void testBuscarDroneVideo() {
    DroneVideoDto droneVideo = new DroneVideoDto();
    droneVideo.setUrl("https://www.youtube.com/watch?v=A9Y8mqrIKCQ");

    given().contentType("application/json").body(droneVideo).when().post("/drone/video").then()
        .statusCode(201);

    List<DroneVideoEntity> droneVideoCadastrado =
        Arrays.asList(given().when().get("/drone/video/").as(DroneVideoEntity[].class));

    given().when().get("/drone/video/" + droneVideoCadastrado.get(1).getId()).then()
        .statusCode(200);
  }

  @Test
  @Order(19)
  @DisplayName("19 - Deleta um DroneVideo com sucesso.")
  public void testDeletarDroneVideo() {
    this.testSalvarDroneVideo();
    given().when().delete("/drone/video/1").then().statusCode(200);
  }
}
