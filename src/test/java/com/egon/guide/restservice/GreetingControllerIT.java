package com.egon.guide.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * You can also use Spring Boot to write a simple full-stack integration test.
 * The embedded server starts on a random port and the actual port is configured
 * automatically in the base URL for the TestRestTemplate.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerIT {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void greeting() {
        var response = template.getForEntity("/greeting", Greeting.class);

        assertThat(response.getBody()).isNotNull()
                .extracting(Greeting::content).isEqualTo("Hello, World!");
    }
}
