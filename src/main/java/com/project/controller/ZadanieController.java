package com.project.controller;

import com.project.model.Zadanie;
import com.project.service.ZadanieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;

@Controller
public class ZadanieController {
    private final ZadanieService zadanieService;

    @Autowired
    public ZadanieController(ZadanieService zadanieService) {
        this.zadanieService = zadanieService;
    }

    @GetMapping("/taskList")
    public String taskList(Model model, Pageable pageable) {
        model.addAttribute("zadania", zadanieService.getZadania(pageable).getContent());
        return "taskList";
    }

    @GetMapping("/taskEdit")
    public String taskEdit(@RequestParam(required = false) Integer zadanieId, Model model) {
        if (zadanieId != null) {
            model.addAttribute("zadanie", zadanieService.getZadanie(zadanieId).get());
        } else {
            Zadanie zadanie = new Zadanie();
            model.addAttribute("zadanie", zadanie);
        }
        return "taskEdit";
    }

    @PostMapping(path = "/taskEdit")
    public String taskEditSave(@ModelAttribute @Validated Zadanie zadanie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "taskEdit";
        }
        try {
            zadanie = zadanieService.setZadanie(zadanie);
        } catch (HttpStatusCodeException e) {
            bindingResult.rejectValue(null, String.valueOf(e.getStatusCode().value()), e.getStatusCode().getReasonPhrase());
            return "taskEdit";
        }
        return "redirect:/taskList";
    }

    @PostMapping(params = "cancel", path = "/taskEdit")
    public String taskEditCancel() {
        return "redirect:/taskList";
    }

    @PostMapping(params = "delete", path = "/taskEdit")
    public String taskEditDelete(@ModelAttribute Zadanie zadanie) {
        zadanieService.deleteZadanie(zadanie.getZadanieId());
        return "redirect:/taskList";
    }
}
