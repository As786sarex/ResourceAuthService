package com.levelfancy.endpoints;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.annotation.security.PermitAll;
import java.util.Map;

@Controller("/auth")
@PermitAll
public class AuthEndpoint {

    @Get("/map")
    public Map<Object,Object> getMap() {
        return Map.of("res","res","5r57",7);
    }
}
