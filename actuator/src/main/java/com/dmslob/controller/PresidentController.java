package com.dmslob.controller;

import com.dmslob.domain.President;
import com.dmslob.repository.PresidentRepository;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class PresidentController {
    private final PresidentRepository presidentRepository;
    private final Counter greetingCounter;

    public PresidentController(PresidentRepository presidentRepository, MeterRegistry registry) {
        this.presidentRepository = presidentRepository;
        this.greetingCounter = Counter.builder("api.greeting").register(registry);
    }

    @GetMapping("greeting")
    public String getGreeting() {
        greetingCounter.increment();
        return "Hello People";
    }

    @GetMapping("presidents")
    @Timed(value = "api.getAllPresidents")
    public List<President> getAllUSPresidents() {
        List<President> allPresidents = new ArrayList<>();
        this.presidentRepository.findAll().forEach(allPresidents::add);

        return allPresidents;
    }
}
