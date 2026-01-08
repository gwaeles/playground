package com.gwa.winter.output

import com.gwa.winter.model.OrderLineDto
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange

@HttpExchange(accept = ["application/json"])
interface CoreBackendClient {

    @GetExchange("/orders/")
    fun getAllItems(): List<OrderLineDto>?

    @GetExchange("/orders/{id}")
    fun getItemById(@PathVariable id: Long): OrderLineDto?
}