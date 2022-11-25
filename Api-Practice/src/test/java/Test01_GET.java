import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_GET {
    @Test
    void test_01(){
        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.getBody());//io.restassured.internal.RestAssuredResponseImpl@7894f09b
        System.out.println(response.getStatusCode());//200
        System.out.println(response.getStatusLine());//HTTP/1.1 200 OK
        System.out.println(response.getHeader("content-type"));//application/json; charset=utf-8
        System.out.println(response.getTime());//1845


        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test
    void test_02(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]",equalTo(7));
    }
}
