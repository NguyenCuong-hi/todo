package com.example.schedualcalender.convert;

import com.example.schedualcalender.domain.Todo;
import com.example.schedualcalender.dto.TodoDto;
import org.springframework.stereotype.Component;

@Component
public class ConvertDtoToEntity {
    public Todo convertDtoToEntityTodo(Todo todoEntity, TodoDto todoDto){
        todoEntity.setTitle(todoDto.getTitle());
        todoEntity.setDetail(todoDto.getDetail());
        return todoEntity;
    }
}
