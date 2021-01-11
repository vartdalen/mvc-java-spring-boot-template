package com.vartdalen.mvcjavaspringboottemplate.service;
import com.vartdalen.mvcjavaspringboottemplate.model.ModelTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelTemplateService {

    @Value("http://${server.datasource.address}:${server.datasource.port}/modelTemplates/") String BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();

    public String helloWorld() {
        return "Hello, World";
    }

    public ModelTemplate[] get() {
        return restTemplate.getForObject(BASE_URL, ModelTemplate[].class);
    }

    public ModelTemplate get(long id) {
        return restTemplate.getForObject(BASE_URL+id, ModelTemplate.class);
    }

    public ModelTemplate post(ModelTemplate modelTemplate) {
        ResponseEntity<ModelTemplate> response;
        response = restTemplate.postForEntity(BASE_URL, modelTemplate, ModelTemplate.class);
        return response.getBody();
    }

    public void put(long id, ModelTemplate modelTemplate) { restTemplate.put(BASE_URL+id, modelTemplate); }

    public void delete(long id) {
        restTemplate.delete(BASE_URL+id);
    }
}
