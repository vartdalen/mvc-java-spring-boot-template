package com.vartdalen.mvcjavaspringboottemplate.service;
import com.vartdalen.mvcjavaspringboottemplate.model.ModelTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ModelTemplateService {

    @Value("http://${server.datasource.address}:${server.datasource.port}/modelTemplates/") String BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();

    public String helloWorld() {
        return "Hello, World";
    }

    public ResponseEntity<ModelTemplate[]> get() {
        return restTemplate.getForEntity(BASE_URL, ModelTemplate[].class);
    }

    public ResponseEntity<ModelTemplate> get(long id) {
        return restTemplate.getForEntity(BASE_URL+id, ModelTemplate.class);
    }

    public ResponseEntity<ModelTemplate> post(ModelTemplate modelTemplate) {
        return restTemplate.postForEntity(BASE_URL, modelTemplate, ModelTemplate.class);
    }

    public void put(long id, ModelTemplate modelTemplate) { restTemplate.put(BASE_URL+id, modelTemplate); }

    public void delete(long id) {
        restTemplate.delete(BASE_URL+id);
    }
}
