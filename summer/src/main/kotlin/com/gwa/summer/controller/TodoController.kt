package com.gwa.summer.controller

import com.gwa.summer.model.Todo
import com.gwa.summer.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos")
class TodoController(val todoService: TodoService) {

    @GetMapping("/")
    fun getTodos(): ResponseEntity<List<Todo>> {
        return todoService.getAllTodos("gwa")
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: Long): ResponseEntity<Todo> {
        return todoService.getTodoById(id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }
}