package specs;

import io.restassured.specification.RequestSpecification;
import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class UserNotFoundRequestSpec {

    public static RequestSpecification userNotFoundRequestSpec = with()
            .filter(withCustomTemplates())
            .basePath("api/users/23")
            .log().uri();
}
