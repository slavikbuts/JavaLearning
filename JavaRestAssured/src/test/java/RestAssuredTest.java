import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {
    final String url = "https://reqres.in/api/users/2";

    public void getRespondAll(){
        given().when().get(url).then().log().all();
    }

    public void getRespondBody(){
        given().when().get(url).then().log().body();
    }

    public int getRespondStatus(){
        return given().when().get(url).statusCode();
    }

    @Test
    public void parsingTheResponse(){
        Response response = given().when().get(url).then().extract().response();
        JsonPath jsp = new JsonPath(response.asString());

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(getRespondStatus(), 200);
        Assert.assertTrue(jsp.getString("data.id").equals("2"));
        System.out.println(jsp.getString("data"));
    }
}
