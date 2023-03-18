package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import models.UsersOnPageResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.UsersOnPageRequestSpec.usersOnPageRequestSpec;
import static specs.UsersOnPageResponseSpec.usersOnPageResponseSpec;
import static specs.UserNotFoundRequestSpec.userNotFoundRequestSpec;
import static specs.UserNotFoundResponseSpec.userNotFoundResponseSpec;

public class UsersSearchTests {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    @Story("Работа с пользователями")
    @DisplayName("Проверить количество пользователей, отображаемых на странице")
    void checkUsersPerPage() {
        UsersOnPageResponseModel response = given()
                .spec(usersOnPageRequestSpec)
                .when()
                .get()
                .then()
                .spec(usersOnPageResponseSpec)
                .extract().as(UsersOnPageResponseModel.class);
        assertThat(response.getPer_page()).isEqualTo(6);
    }

    @Test
    @Story("Работа с пользователями")
    @DisplayName("Проверить, что пользователь не найден")
    void userNotFound() {
        given()
                .spec(userNotFoundRequestSpec)
                .when()
                .get()
                .then()
                .spec(userNotFoundResponseSpec);
    }
}