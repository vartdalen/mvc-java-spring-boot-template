package com.vartdalen.mvcjavaspringboottemplate.controller;
import com.vartdalen.mvcjavaspringboottemplate.model.ModelTemplate;
import com.vartdalen.mvcjavaspringboottemplate.service.ModelTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/modelTemplates")
public class ModelTemplateController {

    private final ModelTemplateService modelTemplateService;

    @Autowired
    public ModelTemplateController(ModelTemplateService modelTemplateService) {
        this.modelTemplateService = modelTemplateService;
    }

    @RequestMapping("/helloWorld")
    @ResponseBody
    public String helloWorld() {
        return modelTemplateService.helloWorld();
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<ModelTemplate[]> get() {
        return modelTemplateService.get();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ModelTemplate> get(@PathVariable long id) {
        return modelTemplateService.get(id);
    }

    @PostMapping("")
    public ResponseEntity<ModelTemplate> post(@RequestBody ModelTemplate modelTemplate) {
        return modelTemplateService.post(modelTemplate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable long id, @RequestBody ModelTemplate modelTemplate) {
        if (modelTemplate.getId() > -1) { throw new RuntimeException("Value of field 'id' is invalid. Expected: null"); }
        modelTemplateService.put(id, modelTemplate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        modelTemplateService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
