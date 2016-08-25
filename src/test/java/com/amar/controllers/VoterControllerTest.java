package com.amar.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Sql(value = {"/prepare-db.sql"})
public class VoterControllerTest {
    @Before
    public void setUp() throws Exception {
        RestAssured.port = 8001;
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldGetAllVotersOnPage0() throws Exception {
        given().log().all().and().given().get("/api/voters")
                .then().log().all().statusCode(200)
                .body(
                        "numberOfElements", is(3),
                        "totalPages", is(2),
                        "content[0].name", equalTo("Andrew Mitzman"),
                        "content[0].age", equalTo(12),
                        "content[2].gender", equalTo("M")
                );
    }

    @Test
    public void shouldGetAllVoterById() throws Exception {
        given().log().all().and().given().get("/api/voters/3")
                .then().log().all().statusCode(200)
                .body(
                        "name", equalTo("Joey Sampson"),
                        "age", equalTo(30),
                        "gender", equalTo("M")
                );
    }

    @Test
    public void shouldCreateVoter() throws Exception {
        Map<String, Object> json = new HashMap<>();
        json.put("name", "Brett Hart");
        json.put("age", 40);
        json.put("gender", "M");
        json.put("race", "W");

        given().log().all().and().given().contentType(ContentType.JSON)
                .body(json).post("/api/voters/").then().log().all().statusCode(200)
                .body(
                        "name", equalTo("Brett Hart"),
                        "age", equalTo(40),
                        "gender", equalTo("M")
                );
    }
}