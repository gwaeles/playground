package com.gwa.winter.output

import com.gwa.winter.model.TodoDto
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange

const val WINTER_CLIENT_VERSION = "1.0.3"

@HttpExchange(accept = ["application/json"])
interface WinterClient {

    @GetExchange("/todos/")
    fun getAllItems(
        @RequestHeader version: String = WINTER_CLIENT_VERSION,
        @RequestHeader(value = "system-id") systemId: String
    ): List<TodoDto>?

    @GetExchange("/todos/{id}")
    fun getItemById(@PathVariable id: Long): TodoDto?
}