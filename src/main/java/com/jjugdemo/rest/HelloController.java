package com.jjugdemo.rest;

import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
/**
 * 単純な文字列を返すエンドポイント.
 */
@Path("/hello")
@Singleton
public class HelloController {

    @GET
    public String sayHello() {
        return "Hello JJUG CCC 2024 Fall!";
    }
}