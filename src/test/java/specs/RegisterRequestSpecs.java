package specs;

import io.restassured.specification.RequestSpecification;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class   RegisterRequestSpecs {

    public static RequestSpecification registerRequestSpec = with()
            .filter(withCustomTemplates())
            .basePath("/api/register")
            .log().all()
            .contentType(JSON);
}
