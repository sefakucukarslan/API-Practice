import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class Tests_POST {
    //@Test
    public void test_1_post(){
        //Map<String,Object> map = new HashMap<String,Object>();
        //map.put("name","Sefa");
        //map.put("job","Tester");
        //System.out.println(map);

        JSONObject request = new JSONObject();//Çıktıları Json formatında daha düzenli hale getiriyor.

        request.put("name","Sefa");
        request.put("job","Tester");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)//Sunucuya size gönderdiğim içerisin json türünde olduğunu söylüyoruz
                .accept(ContentType.JSON)// ve kabul edeceğim response'un json türünde olmalı
                .body(request.toJSONString())//Çıktıları Json formatında daha düzenli hale getiriyor.
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }

    //@Test
    public void test_2_put(){

        JSONObject request = new JSONObject();

        request.put("name","Sefa");
        request.put("job","Tester");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    //@Test
    public void test_3_patch(){

        JSONObject request = new JSONObject();

        request.put("name","Sefa");
        request.put("job","Tester");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }


    @Test
    public void test_4_delete(){
                when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log()
                .all();
    }
}
