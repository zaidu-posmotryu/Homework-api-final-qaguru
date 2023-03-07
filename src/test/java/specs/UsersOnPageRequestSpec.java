package specs;

import io.restassured.specification.RequestSpecification;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class UsersOnPageRequestSpec {

    public static RequestSpecification usersOnPageRequestSpec = with()
            .filter(withCustomTemplates())
            .basePath("/api/users?page=1")
            .log().uri();
}
