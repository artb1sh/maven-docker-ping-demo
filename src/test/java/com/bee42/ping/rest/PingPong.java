package com.bee42.ping.rest;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.path.json.JsonPath;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.path.json.JsonPath.with;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

/**
 * @author peter rossbach
 * @since 12.08.14
 */
public class PingPong {

    @Test
    public void testPong() {
        String messageExpected = System.getProperty("ping.message");
        String pingUrl = System.getProperty("ping.url");

        RestAssured.baseURI = pingUrl;
        RestAssured.defaultParser = Parser.JSON;
        System.out.println("Checking URL: " + pingUrl);

        // Need to do it that way since ping doesnt return application/json as mimetype by default
        JsonPath json = with(get("/ping").asString());
        json.prettyPrint();
        assertEquals(messageExpected, json.get("message"));

        // Alternatively, set the mime type before, then Rest-assured's fluent API can be used
        given()
                .param("mimeType", "application/json")
                .get("/ping")
        .then().assertThat()
                .header("content-type", containsString("application/json"))
                .body("message", equalTo(messageExpected));
    }

}
