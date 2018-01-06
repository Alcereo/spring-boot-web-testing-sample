package ru.alcereo.integr;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * Created by alcereo on 06.01.18.
 */
public class InterfaceClass {

    private final RestTemplate restTemplate;
    private final String address;

    public InterfaceClass(RestTemplate restTemplate, String address) {
        this.restTemplate = restTemplate;
        this.address = address;
    }

    public String getTestString(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity(address + "/test", String.class, new HashMap<>());

        if (forEntity.getStatusCode().is2xxSuccessful())
            return forEntity.getBody();

        throw new RuntimeException("Request error");
    }
}
