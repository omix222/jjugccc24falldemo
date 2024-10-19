package com.jjugdemo.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationPath("/api")
@ApplicationScoped
public class RestApplication extends Application {

}