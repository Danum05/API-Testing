package test.api;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiTestPut {

    private static final String BASE_URL = "https://dummyapi.io/data/v1/";
    
    private static final String VALID_APP_ID = "662701ba776fafe3d71e1751";
    
    private static final String VALID_USER_ID_1 = "6637437e906c3a14e4c6d66e";

    /**
     * 
     */
    @Test(description = "Ubah firstName pengguna dengan app-id dan user id valid")
    public void UpdateFirstName() {
        String requestBody = "{\"firstName\": \"Rofaul\"}";

        given()
            .baseUri(BASE_URL)
            .header("app-id", VALID_APP_ID)
            .contentType(ContentType.JSON) 
            .body(requestBody)
            .when()
            .put("/user/" + VALID_USER_ID_1)
            .then()
            .statusCode(200)
            .body("firstName", equalTo("Rofaul"));
    }

    @Test(description = "Tambah lastName pengguna dengan app-id dan user id valid")
    public void AddLastName() {
        String requestBody = "{\"lastName\": \"Akrom\"}";

        given()
            .baseUri(BASE_URL)
            .header("app-id", VALID_APP_ID)
            .contentType(ContentType.JSON) 
            .body(requestBody)
            .when()
            .put("/user/" + VALID_USER_ID_1)
            .then()
            .statusCode(200)
            .body("lastName", equalTo("Akrom"));
    }

    @Test(description = "Ubah title pengguna menjadi 'mr' dengan app-id dan user id valid")
    public void ChangeTitleToMr() {
        String requestBody = "{\"title\": \"mr\"}";

        given()
            .baseUri(BASE_URL)
            .header("app-id", VALID_APP_ID)
            .contentType(ContentType.JSON) 
            .body(requestBody)
            .when()
            .put("/user/" + VALID_USER_ID_1)
            .then()
            .statusCode(200)
            .body("title", equalTo("mr"));
    }

    @Test(description = "Ubah title pengguna menjadi 'ms' dengan app-id dan user id valid")
    public void ChangeTitleToMs() {
        String requestBody = "{\"title\": \"ms\"}";

        given()
            .baseUri(BASE_URL)
            .header("app-id", VALID_APP_ID)
            .contentType(ContentType.JSON) 
            .body(requestBody)
            .when()
            .put("/user/" + VALID_USER_ID_1)
            .then()
            .statusCode(200)
            .body("title", equalTo("ms"));
    }

    @Test(description = "Ubah title pengguna menjadi 'mrs' dengan app-id dan user id valid")
    public void ChangeTitleToMrs() {
        String requestBody = "{\"title\": \"mrs\"}";

        given()
            .baseUri(BASE_URL)
            .header("app-id", VALID_APP_ID)
            .contentType(ContentType.JSON) 
            .body(requestBody)
            .when()
            .put("/user/" + VALID_USER_ID_1)
            .then()
            .statusCode(200)
            .body("title", equalTo("mrs"));
    }
}
