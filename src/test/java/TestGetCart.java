package test.java;

import io.restassured.response.ExtractableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestGetCart {
    @SuppressWarnings("rawtypes")
    public static ExtractableResponse response;

    @Test
    @Parameters("count")
    public void testCartWithProduct(int count) {
        response =
                given()
                        .spec(Specification.requestSpec)
                        .auth().oauth2(TestAuthorization.token)
                        .when().get("cart")
                        .then()
                        .spec(Specification.responseSpec)
                        .body("quantity", Matchers.equalTo(count))
                        .extract();
    }
}
