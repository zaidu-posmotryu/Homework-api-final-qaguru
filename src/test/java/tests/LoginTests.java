package tests;

import io.qameta.allure.Story;
import io.restassured.RestAssured;
import models.RegisterBodyModel;
import models.RegisterResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.RegisterRequestSpecs.registerRequestSpec;
import static specs.RegisterResponseSpecs.*;

public class LoginTests {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    @Story("Работа функционала регистрации")
    @DisplayName("Проверить регистрацию, если поле email не заполнено")
    void registerWithoutEmailTest() {
        RegisterBodyModel body = new RegisterBodyModel();
        body.setPassword("pistol");
        RegisterResponseModel response = given()
                .spec(registerRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(registerWithoutEmailResponseSpec)
                .extract().as(RegisterResponseModel.class);
        assertThat(response.getError()).isEqualTo("Missing email or username");
    }

    @Test
    @Story("Работа функционала регистрации")
    @DisplayName("Проверить регистрацию, если поле пароля не заполнено")
    void registerWithoutPassTest() {
        RegisterBodyModel body = new RegisterBodyModel();
        body.setEmail("eve.holt@reqres.in");
        RegisterResponseModel response = given()
                .spec(registerRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(registerWithoutPassResponseSpec)
                .extract().as(RegisterResponseModel.class);
        assertThat(response.getError()).isEqualTo("Missing password");
    }

    @Test
    @Story("Работа функционала регистрации")
    @DisplayName("Проверить регистрацию с корректными параметрами")
    void registerWithSpecsTest() {
        RegisterBodyModel body = new RegisterBodyModel();
        body.setEmail("eve.holt@reqres.in");
        body.setPassword("pistol");
        RegisterResponseModel response = given()
                .spec(registerRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(registerResponseSpec)
                .extract().as(RegisterResponseModel.class);
        assertThat(response.getToken()).isNotNull();
        assertThat(response.getId()).isNotNull();
    }
}
