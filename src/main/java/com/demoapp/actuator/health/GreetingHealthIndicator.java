package com.demoapp.actuator.health;

import java.util.Collection;

import com.demoapp.model.Greeting;
import com.demoapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class GreetingHealthIndicator implements HealthIndicator {

  
    @Autowired
    private GreetingService greetingService;

    @Override
    public Health health() {

        // Assess the application's Greeting health. If the application's
        // Greeting components have data to service user requests, the Greeting
        // component is considered 'healthy', otherwise it is not.

        Collection<Greeting> greetings = greetingService.findAll();

        if (greetings == null || greetings.isEmpty()) {
            return Health.down().withDetail("count", 0).build();
        }

        return Health.up().withDetail("count", greetings.size()).build();
    }

}
