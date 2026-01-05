package com.gwa.winter.controler

import com.gwa.summer.service.TodoService
import com.gwa.winter.model.TodoDto
import com.gwa.winter.output.WINTER_CLIENT_VERSION
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.collections.map

@RestController
@RequestMapping("/api/todos")
class TodoController(val todoService: TodoService) {

    @GetMapping("/")
    fun getTodos(
        @RequestHeader version: String,
        @RequestHeader(value = "system-id") systemId: String
    ): ResponseEntity<List<TodoDto>> {

        println("getTodos ---> WINTER_CLIENT_VERSION: $WINTER_CLIENT_VERSION, version: $version, systemId: $systemId")

        return todoService.getAllTodos("gwa")
            ?.map { TodoDto.fromEntity(it) }
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: Long): ResponseEntity<TodoDto> {
        return todoService.getTodoById(id)
            ?.let { TodoDto.fromEntity(it) }
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }
}