package test.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1/user/create";
        RestAssured.basePath = "";
        RestAssured.requestSpecification = given()
                .header("app-id", "662701ba776fafe3d71e1751")
                .contentType(ContentType.JSON);
    }

    @Test
    public void testTC9_FieldLainTerisiKecualiGenderDiisiKosong() {
        given()
            .body("{\n" +
                    "  \"title\": \"mrs\",\n" +
                    "  \"firstName\": \"Gian\",\n" +
                    "  \"lastName\": \"Latimojong\",\n" +
                    "  \"email\": \"Gianlatimojong@gmail.com\",\n" +
                    "  \"gender\": \"\",\n" +
                    "  \"status\": \"inactive\"\n" +
                    "}")
        .when()
            .post()
        .then()
            .statusCode(400); // Expecting bad request due to empty gender
    }

    @Test
    public void testTC3_DataInputValidBelumAdaDiSistem_LakiLakiStatusInactive() {
        given()
            .body("{\n" +
                    "  \"title\": \"mr\",\n" +
                    "  \"firstName\": \"Husna\",\n" +
                    "  \"lastName\": \"Maulana\",\n" +
                    "  \"email\": \"husnaMaulana@gmail.com\",\n" +
                    "  \"gender\": \"male\",\n" +
                    "  \"status\": \"inactive\"\n" +
                    "}")
        .when()
            .post()
        .then()
            .statusCode(200) // Expecting the resource to be created
            .body("title", equalTo("mr"))
            .body("firstName", equalTo("Husna"))
            .body("lastName", equalTo("Maulana"))
            .body("email", equalTo("husnaMaulana@gmail.com"))
            .body("gender", equalTo("male"))
            .body("status", equalTo("inactive"));
    }

    @Test
    public void testTC10_FieldLainTerisiKecualiStatusDiisiKosong() {
        given()
            .body("{\n" +
                    "  \"title\": \"mrs\",\n" +
                    "  \"firstName\": \"Gian\",\n" +
                    "  \"lastName\": \"Latimojong\",\n" +
                    "  \"email\": \"Gianlatimojong@gmail.com\",\n" +
                    "  \"gender\": \"female\",\n" +
                    "  \"status\": \"\"\n" +
                    "}")
        .when()
            .post()
        .then()
            .statusCode(400); // Expecting bad request due to empty status
    }

    @Test
    public void testTC11_SemuaFieldDiisiKosong() {
        given()
            .body("{\n" +
                    "  \"title\": \"\",\n" +
                    "  \"firstName\": \"\",\n" +
                    "  \"lastName\": \"\",\n" +
                    "  \"email\": \"\",\n" +
                    "  \"gender\": \"\",\n" +
                    "  \"status\": \"\"\n" +
                    "}")
        .when()
            .post()
        .then()
            .statusCode(400); // Expecting bad request due to all fields empty
    }

    @Test
    public void testTC17_FieldLainBenarDenganGenderFemale_StatusInvalid() {
        given()
            .body("{\n" +
                    "  \"title\": \"mrs\",\n" +
                    "  \"firstName\": \"Gian\",\n" +
                    "  \"lastName\": \"Latimojong\",\n" +
                    "  \"email\": \"Gianlatimojong@gmail.com\",\n" +
                    "  \"gender\": \"female\",\n" +
                    "  \"status\": \"blocked\"\n" +
                    "}")
        .when()
            .post()
        .then()
            .statusCode(400); // Expecting bad request due to invalid status
    }
}
