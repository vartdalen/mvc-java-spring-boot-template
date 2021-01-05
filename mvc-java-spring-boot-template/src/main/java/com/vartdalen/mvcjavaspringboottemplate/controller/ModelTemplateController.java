package com.vartdalen.mvcjavaspringboottemplate.controller;
import com.vartdalen.mvcjavaspringboottemplate.model.ModelTemplate;
import com.vartdalen.mvcjavaspringboottemplate.service.ModelTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelTemplates")
public class ModelTemplateController {

    private final ModelTemplateService modelTemplateService;

    @Autowired
    public ModelTemplateController(ModelTemplateService modelTemplateService) {
        this.modelTemplateService = modelTemplateService;
    }

    @RequestMapping("/helloWorld")
    public @ResponseBody String helloWorld() {
        return modelTemplateService.helloWorld();
    }

    @GetMapping("/get")
    public @ResponseBody ModelTemplate[] get() {
        return modelTemplateService.get();
    }

    @PostMapping("/post")
    public String post(@ModelAttribute("modelTemplate") ModelTemplate modelTemplate) {
        modelTemplateService.post(modelTemplate);
        return "redirect:/";
    }

    @PutMapping("/put")
    public String put(@ModelAttribute("modelTemplate") ModelTemplate modelTemplate) {
        modelTemplateService.put(modelTemplate.getId(), modelTemplate);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{idModelTemplate}")
    public String delete(@PathVariable("idModelTemplate") String idModelTemplate) {
            modelTemplateService.delete(Long.parseLong(idModelTemplate));
        return "redirect:/";
    }
}
