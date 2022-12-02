package com.example.schedualcalender.service.Impl;

import com.example.schedualcalender.convert.ConvertDtoToEntity;
import com.example.schedualcalender.domain.Todo;
import com.example.schedualcalender.dto.TodoDto;
import com.example.schedualcalender.repository.TodoRepository;
import com.example.schedualcalender.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private ConvertDtoToEntity convertDtoToEntity;

    @Override
    public List<Todo> findAll (Integer limit){
        return Optional.ofNullable(limit).map(value -> todoRepository.findAll(PageRequest.of(0,value)).getContent()).orElseGet(()->todoRepository.findAll());
    }

    @Override
    public Todo create (TodoDto todoDto){
        Todo todo  = new Todo();
        todoRepository.save(convertDtoToEntity.convertDtoToEntityTodo(todo,todoDto));
        return todo;
    }

}
