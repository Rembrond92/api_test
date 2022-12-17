package test.java;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPopularProducts {
    public static int offer_id;

    @Test(dependsOnMethods = "test.java.MainPage.testMainPage")
    public void testPopularProducts() {
        offer_id =
                given()
                        .spec(Specification.requestSpec)
                        .auth().oauth2(TestAuthorization.token)
                        .when().get("products/" + TestMainPage.id)
                        .then()
                        .spec(Specification.responseSpec)
                        .body("meta.description", Matchers.containsString("Заказать с быстрой доставкой по России!"))
                        .extract().path("offers[0].offer_id");
    }
}