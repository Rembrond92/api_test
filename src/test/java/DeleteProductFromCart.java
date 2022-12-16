import groovy.json.JsonParser;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import netscape.javascript.JSObject;
import org.apache.groovy.json.internal.JsonParserCharArray;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.testng.annotations.Test;

import java.io.StringReader;

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
