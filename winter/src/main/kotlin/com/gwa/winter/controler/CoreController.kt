package com.gwa.winter.controler

import com.gwa.summer.service.TodoService
import com.gwa.winter.model.OrderLineDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.collections.map

@RestController
@RequestMapping("/orders")
class CoreController(val todoService: TodoService) {

    @GetMapping("/")
    fun getOrderLines(): ResponseEntity<List<OrderLineDto>> {

        return todoService.getAllTodos("gwa")
            ?.map { OrderLineDto.fromEntity(it) }
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/{id}")
    fun getOrderLineById(@PathVariable id: Long): ResponseEntity<OrderLineDto> {
        return todoService.getTodoById(id)
            ?.let { OrderLineDto.fromEntity(it) }
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }
}