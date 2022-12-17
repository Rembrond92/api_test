package test.java;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestToCart {

    @Test(dependsOnMethods = "test.java.PopularProducts.testPopularProducts")
    public void testToCart() {
        given()
                .spec(Specification.requestSpec)
                .auth().oauth2(TestAuthorization.token)
                .body("{\"offers\":[" + TestPopularProducts.offer_id + "]}")
                .when().post("cart")
                .then()
                .spec(Specification.responseSpec);
    }
}
