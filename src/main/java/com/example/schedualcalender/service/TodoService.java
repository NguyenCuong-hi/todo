package com.example.schedualcalender.service;

import com.example.schedualcalender.domain.Todo;
import com.example.schedualcalender.dto.TodoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
    public List<Todo> findAll (Integer limit);
    public Todo create (TodoDto todoDto);
}
