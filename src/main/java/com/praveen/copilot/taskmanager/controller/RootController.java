package com.praveen.copilot.taskmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RootController {

    @GetMapping("/")
    public Map<String, Object> root() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to Copilot Task Manager API");
        response.put("version", "1.0.0");
        response.put("endpoints", new HashMap<String, String>() {{
            put("GET /api/tasks", "Get all tasks");
            put("PUT /api/tasks/{id}", "Update a task");
            put("GET /h2-console", "H2 Database Console");
        }});
        return response;
    }
}
