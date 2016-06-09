package com.github.eciuca.dropwizard.helloworld.rest;

import com.codahale.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    private final String name;

    @Inject
    public HelloWorldResource(@Named("name") String name) {
        this.name = name;
    }

    @GET
    @Timed
    public String helloWorld() {
        return "Hello, " + name + "!";
    }
}
