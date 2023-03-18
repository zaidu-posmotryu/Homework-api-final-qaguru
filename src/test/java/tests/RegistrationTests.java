package tests;

import config.CredentialsConfig;
import io.qameta.allure.Story;
import models.RegisterBodyModel;
import models.RegisterResponseModel;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specs.*;

public class RegistrationTests {
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    String email = config.email();
    String password = config.password();

    @Test
    @Story("Работа функционала регистрации")
    @DisplayName("Проверить регистрацию, если поле email не заполнено")
    void registerWithoutEmailTest() {
        RegisterBodyModel body = new RegisterBodyModel();
        body.setPassword(password);
        RegisterResponseModel response = given(requestSpec)
                .body(body)
                .when()
                .post("/register")
                .then()
                .spec(responseSpec400)
                .extract().as(RegisterResponseModel.class);
        assertThat(response.getError()).isEqualTo("Missing email or username");
    }

    @Test
    @Story("Работа функционала регистрации")
    @DisplayName("Проверить регистрацию, если поле пароля не заполнено")
    void registerWithoutPassTest() {
        RegisterBodyModel body = new RegisterBodyModel();
        body.setEmail(email);
        RegisterResponseModel response = given(requestSpec)
                .body(body)
                .when()
                .post("/register")
                .then()
                .spec(responseSpec400)
                .extract().as(RegisterResponseModel.class);
        assertThat(response.getError()).isEqualTo("Missing password");
    }

    @Test
    @Story("Работа функционала регистрации")
    @DisplayName("Проверить регистрацию с корректными параметрами")
    void registerWithSpecsTest() {
        RegisterBodyModel body = new RegisterBodyModel();
        body.setEmail(email);
        body.setPassword(password);
        RegisterResponseModel response = given(requestSpec)
                .body(body)
                .when()
                .post("/register")
                .then()
                .spec(responseSpec200)
                .extract().as(RegisterResponseModel.class);
        assertThat(response.getToken()).isNotNull();
        assertThat(response.getId()).isNotNull();
    }
}
