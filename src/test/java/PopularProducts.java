import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PopularProducts {
    public static int offer_id;

    @Test(dependsOnMethods = "MainPage.testMainPage")
    public void testPopularProducts() {
        offer_id =
                given()
                        .spec(Specification.requestSpec)
                        .auth().oauth2(Authorization.token)
                        .when().get("products/" + MainPage.id)
                        .then()
                        .spec(Specification.responseSpec)
                        .body("meta.description", Matchers.containsString("Заказать с быстрой доставкой по России!"))
                        .extract().path("offers[0].offer_id");
    }
}