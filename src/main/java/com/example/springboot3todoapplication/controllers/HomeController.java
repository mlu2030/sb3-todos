package com.example.springboot3todoapplication.controllers;

import com.example.springboot3todoapplication.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;
    }

    @GetMapping("/404")
    public ModelAndView notFound() {
        // Generating status code for testing
        if (20 > 11){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;
    }

    @GetMapping("/501")
    public ModelAndView serverError() {
        // Generating status code for testing
        if (20 > 11){
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Not Implemented");
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;
    }

}
