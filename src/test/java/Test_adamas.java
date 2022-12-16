import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test_adamas {

    String token;

    @Test
    public void testAuthorization() {
        token =
                given()
                .baseUri("https://rest.adamas.ru/v1")
                .basePath("/users/start")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200).and()
                        //проверка токена авторизации на длину в 32 символа
                        //и содержание из букв\цифр\тире\ниж.подчеркивания
                .body("token", Matchers.matchesRegex("([\\w-]){32}"))
                        .extract().path("token");
    }

}
