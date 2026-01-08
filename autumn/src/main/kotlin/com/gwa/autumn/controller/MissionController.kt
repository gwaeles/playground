package com.gwa.autumn.controller

import com.gwa.winter.model.TodoDto
import com.gwa.winter.output.WinterClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos")
class TodoController(val winterClient: WinterClient) {

    @GetMapping("/")
    fun getTodos(): ResponseEntity<List<TodoDto>> {
        return winterClient.getAllItems(systemId = "autumn")
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: Long): ResponseEntity<TodoDto> {
        return winterClient.getItemById(id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }
}