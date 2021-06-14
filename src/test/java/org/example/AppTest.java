package org.example;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    Response response = null;

    JsonPath jsonPath = null;

    int expectedStatusCode = 200;
    String expectedServer  = "cloudflare";


    @Before
    public void shouldAnswerWithTrue()
    {
      response =
              given()
              .header(":authority", "www.kurtosys.com")
              .body("")
              .when()
              .get("https://www.kurtosys.com");



    }


    @Test
    public void checkStatusCode(){
        assertEquals(expectedStatusCode, response.getStatusCode());
    }
    @Test
    public void checkResponseTime(){

        assertTrue(response.getTimeIn(TimeUnit.MILLISECONDS) < 2000);
    }
    @Test
    public void checkServer(){
        assertEquals(expectedServer, response.getHeader("server"));

    }
}
