package tests;

import io.qameta.allure.Story;
import models.UserOnPageResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specs.*;

public class UsersSearchTests {

    @Test
    @Story("Работа с пользователями")
    @DisplayName("Проверить, что определенный пользователь есть в списке")
    void findUserOnPage() {
        UserOnPageResponseModel responseModel = given(requestSpec)
                .when()
                .get("/users?page=2")
                .then()
                .spec(responseSpec200)
                .extract().as(UserOnPageResponseModel.class);
        assertThat(responseModel.getData().get(1).getFirstName()).isEqualTo("Lindsay");
        assertThat(responseModel.getData().get(1).getLastName()).isEqualTo("Ferguson");
    }

    @Test
    @Story("Работа с пользователями")
    @DisplayName("Проверить, что пользователь не найден")
    void userNotFound() {
        given(requestSpec)
                .when()
                .get("users/23")
                .then()
                .spec(responseSpec404);
    }
}