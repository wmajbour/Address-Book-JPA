package com.example.accessingdatajpa;

import org.apache.commons.collections4.functors.ExceptionPredicate;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class WebAppTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Autowired
    private MainController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getAddressBook() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost: " + port + "/",
                String.class)).contains("[]");
    }

    @Test
    public String createAddressBook() throws Exception{
        String requestBody = "{}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        String response = restTemplate.postForObject("http://localhost: " + port + "/createBook", request, String.class);
        assertThat(response).contains("List of Buddies");
        return response;

    }

    @Test
    public void addBuddy() throws Exception{
        String requestBody = "{\"name\": \"HR\", \"address\": \"942 Rotary Way\", \"phoneNumber\": \"613 513 5160\"}";
        createAddressBook();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        String response = restTemplate.postForObject("http://localhost: " + port + "/addBuddy?id=1", request, String.class);
        assertThat(this.restTemplate.getForObject("http://localhost: " + port + "/book?id=1", String.class)).contains("HR");
    }

    @Test
    public void deleteBuddy() throws Exception{
        createAddressBook();
        addBuddy();

        this.restTemplate.delete("http://localhost: " + port + "removeBuddy?idbuddy=1&idbook=1", String.class);

        assertThat(this.restTemplate.getForObject("http://localhost: " + port + "/books", String.class)).doesNotContain("HR");
    }

}
