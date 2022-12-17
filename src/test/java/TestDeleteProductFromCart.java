package test.java;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestDeleteProductFromCart {

    @Test
    public void testDeleteProductFromCart() {
        int cart_id = TestGetCart.response.path("groups[0].products[0].offers[0].cart_id");
        given()
                .spec(Specification.requestSpec)
                .auth().oauth2(TestAuthorization.token)
                .when().delete("cart/" + cart_id)
                .then()
                .spec(Specification.responseSpec);
    }
}
