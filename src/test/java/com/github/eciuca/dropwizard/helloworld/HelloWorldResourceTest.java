package com.github.eciuca.dropwizard.helloworld;

import com.github.eciuca.dropwizard.helloworld.app.HelloWorldService;
import be.fluid_it.µs.bundle.dropwizard.µServiceRule;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

public class HelloWorldResourceTest {

    private static final String URL = "http://localhost:8888";

    @ClassRule
    public static µServiceRule µServiceRule = new µServiceRule(HelloWorldService.class);

    @Test
    public void helloWorld() {
        final Response response = RestAssured.given().contentType(ContentType.TEXT)
                .when()
                .get(URL + "/hello-world");

        response.then().statusCode(200);
        final String responseText = response.getBody().asString();
        Assert.assertEquals("Hello, user!!!", responseText);
    }
}
