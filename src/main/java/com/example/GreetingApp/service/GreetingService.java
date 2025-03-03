package com.example.GreetingApp.service;
import com.example.GreetingApp.model.Greeting;
import com.example.GreetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Fetch Greeting by ID
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }
    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

}