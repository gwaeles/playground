package com.gwa.braves.controller;

import com.gwa.expos.model.Todo;
import com.gwa.expos.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/")
  List<Todo> getTodos() {
    return todoService.getAllTodos("gwa");
  }

  @GetMapping("/{id}")
  Todo getTodoById(@PathVariable Long id) {
    return todoService.getTodoById(id);
  }
}
