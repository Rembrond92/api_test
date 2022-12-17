package test.java;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MainPage {
    public static int id;

    @Test
    public void testMainPage() {
        id =
                given()
                        .spec(Specification.requestSpec)
                        .auth().oauth2(Authorization.token)
                        .when().get("main")
                        .then()
                        .spec(Specification.responseSpec)
                        .body("popular.title", Matchers.equalTo("Хиты продаж"))
                        .extract().path("popular.products[0].id");
    }
}