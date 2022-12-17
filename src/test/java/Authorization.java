package test.java;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Authorization {
    public static String token;

    @Test
    public void testAuthorization() {
        token =
                given()
                        .spec(Specification.requestSpec)
                        .when().get("users/start")
                        .then()
                        .spec(Specification.responseSpec)
                        //проверка токена авторизации на длину в 32 символа
                        //и содержание из букв\цифр\тире\ниж.подчеркивания
                        .body("token", Matchers.matchesRegex("([\\w-]){32}"))
                        .extract().path("token");
    }
}