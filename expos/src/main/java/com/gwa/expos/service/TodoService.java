package com.gwa.expos.service;

import com.gwa.expos.model.Todo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange(accept = "application/json", headers = "system-id: none")
public interface TodoService {

  @GetExchange("/todos")
  List<Todo> getAllTodos(@RequestHeader(value = "system-id") String systemId);

  @GetExchange("/todos/{id}")
  Todo getTodoById(@PathVariable Long id);

  @GetExchange("/todos?userId={userId}")
  List<Todo> getTodoByUserId(@PathVariable Long userId);

  @PostExchange("/todos")
  Todo createTodo(@RequestBody Todo todo);

}
