package com.egon.guide.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <a href="https://spring.io/guides/gs/spring-boot/">Guide</a><br />
 * <p></p><b>MockMvc</b> comes from Spring Test and lets you, through a set of convenient builder classes, send HTTP
 * requests into the DispatcherServlet and make assertions about the result.</p>
 * <p>Use <b>@AutoConfigureMockMvc</b> and <b>@SpringBootTest</b> to inject a MockMvc instance.
 * Having used @SpringBootTest, we are asking for the whole application context to be created.</p>
 */
@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldTestGreetingResponseAsJson() throws Exception {
        var expected = new Greeting(1, "Hello, World!");
        var request = MockMvcRequestBuilders.get("/greeting")
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expected)));
    }

    @Test
    void shouldTestGreetingResponseAsObject() throws Exception {
        var request = MockMvcRequestBuilders.get("/greeting?name=everyone")
                .accept(MediaType.APPLICATION_JSON);

        var result = mvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        var greetingResponse =
                objectMapper.readValue(result.getResponse().getContentAsString(), Greeting.class);
        assertThat(greetingResponse.content()).isEqualTo("Hello, everyone!");

    }
}