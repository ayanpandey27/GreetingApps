package com.example.GreetingApp.controller;
import com.example.GreetingApp.model.Greeting;
import com.example.GreetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Fetch Greeting by ID
    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
    @PostMapping("/save")
    public Greeting createGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting);
    }
}