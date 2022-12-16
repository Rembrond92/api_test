import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteProductFromCart {

    @Test
    public void testDeleteProductFromCart() {
        int cart_id = GetCart.response.path("groups[0].products[0].offers[0].cart_id");
        given()
                .spec(Specification.requestSpec)
                .auth().oauth2(Authorization.token)
                .when().delete("cart/" + cart_id)
                .then()
                .spec(Specification.responseSpec);
    }
}
