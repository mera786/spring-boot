package com.app.custom;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id = "myapp")
public class CustomActuator {

    @ReadOperation
    public Map<String, String> info() {
        return Map.of(
                "status", "running",
                "developer", "Meraz Alam"
        );
    }
}

