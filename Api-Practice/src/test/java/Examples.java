import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class Examples {

    //json-server
    //npm install -g json-server
    //json-server --watch db.json
    //http://localhost:3000/
    //C:\Users\autum = db.json


    //@Test
    public void test_get(){
        baseURI = "http://localhost:3000/";

        given()
                .param("name","Automation")
                .get("/subjects")
                .then()
                .statusCode(200)
                .log().all();
    }

    //@Test
    public void test_post(){
        JSONObject request = new JSONObject();

        request.put("firstName","Mira");
        request.put("lastName","Kucukarslan");
        request.put("subjectId",1);

        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }


    //@Test
    public void test_patch(){
        JSONObject request = new JSONObject();

        request.put("firstName","Buglem");

        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .put("/users/4")
                .then()
                .statusCode(200)
                .log().all();
    }

    //@Test
    public void test_put(){
        JSONObject request = new JSONObject();

        request.put("firstName","Ecrin");
        request.put("lastName","Comoglu");
        request.put("subjectId",1);

        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .put("/users/4")
                .then()
                .statusCode(200)
                .log().all();
    }

    //@Test
    public void test_delete(){
        baseURI = "http://localhost:3000/";

        when()
                .delete("/users/4")
                .then()
                .statusCode(204);
    }
}
