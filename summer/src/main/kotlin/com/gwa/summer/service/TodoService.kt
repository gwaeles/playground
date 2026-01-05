package com.gwa.summer.service

import com.gwa.summer.model.Todo
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange

@HttpExchange(accept = ["application/json"], headers = ["system-id: none"])
interface TodoService {
    @GetExchange("/todos")
    fun getAllTodos(@RequestHeader(value = "system-id") systemId: String?): List<Todo>?

    @GetExchange("/todos/{id}")
    fun getTodoById(@PathVariable id: Long): Todo?

    @GetExchange("/todos?userId={userId}")
    fun getTodoByUserId(@PathVariable userId: Long): List<Todo>?

    @PostExchange("/todos")
    fun createTodo(@RequestBody todo: Todo): Todo
}