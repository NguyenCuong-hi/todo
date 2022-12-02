package com.example.schedualcalender.controller;

import com.example.schedualcalender.domain.Todo;
import com.example.schedualcalender.dto.TodoDto;
import com.example.schedualcalender.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class TodoController {
    @Autowired
   private TodoService todoService;
    @GetMapping("/listTodo")
    public String listTodo(@RequestParam(value = "limit",required = false) Integer limit, Model model){
       model.addAttribute("listTodo",todoService.findAll(limit));
       return "listTodo";
    }

    @GetMapping("/addTodo")
    public String todoDtoResponseEntity (Model model){
        model.addAttribute("todoDto",new TodoDto());
        return "addTodo";

    }
    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute TodoDto todo) {
        return Optional.ofNullable(todoService.create(todo))
                .map(t -> "success") // Trả về success nếu save thành công
                .orElse("failed"); // Trả về failed nếu không thành công

    }






}
