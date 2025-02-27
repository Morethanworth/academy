package com.ctw.workstation.team.boundary;


import com.ctw.workstation.team.entity.TeamRepository;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestHTTPEndpoint(TeamResource.class)
class TeamResourceTest {
    @Inject
    TeamRepository teamRepository;

    @Order(2)
    @Test
    @DisplayName("Fetching all teams")
    void fetching_all_teams() {
        given()
                .header("Content-Type", "application/json")
                .when()
                .get("/teams")
                .then()
                .body("size()",Matchers.equalTo(1))
                .body("[0].name",Matchers.equalTo("WIND"));

    }

    @Order(1)
    @Test
    @DisplayName("Create a team")
    void create_a_team() {
        TeamRequestDTO teamRequestDTO = new TeamRequestDTO("WIND","R&D","Lisbon");
        given()
            .header("Content-Type", "application/json")
                .body(teamRequestDTO)
        .when()
                .post("/teams")
        .then()
                .statusCode(201)
                .contentType("application/json")
                .body("name", Matchers.is("WIND"),
                        "product", Matchers.equalTo("R&D"),
                        "default_location", Matchers.is("Lisbon"),
                        "id", Matchers.notNullValue(Long.class));
        Assertions.assertEquals("WIND", teamRepository.findById(1L).getName());
    }
    @Order(3)
    @Test
    @DisplayName("Get a team")
    void get_a_team() {
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/teams/1")
        .then()
            .statusCode(200)
            .contentType("application/json")
            .body("name", Matchers.is("WIND"));
    }
    @Order(6)
    @Test
    @DisplayName("Get a team that doesnt exist")
    void get_a_team_that_doesnt_exist() {
        given()
                .header("Content-Type", "application/json")
        .when()
                .get("/teams/1")
        .then()
                .statusCode(404)
                .body(Matchers.equalTo("Team not found"));
    }

    @Order(4)
    @Test
    @DisplayName("Edit a team")
    void edit_a_team() {
        given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"WINDS\",\"product\":\"R&D\", \"default_location\":\"Lisbon\"}")
        .when()
                .put("/teams/1")
        .then()
                .statusCode(200)
                .contentType("application/json")
                .body("name", Matchers.equalTo("WINDS"));
    }

    @Order(5)
    @Test
    @DisplayName("Delete a team")
    void delete_a_team() {
        given()
        .when()
                .delete("/teams/1")
        .then()
                .statusCode(200);

    }


}