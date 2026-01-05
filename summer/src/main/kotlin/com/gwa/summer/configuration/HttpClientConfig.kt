package com.gwa.summer.configuration

import com.gwa.summer.service.TodoService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import org.springframework.web.service.invoker.createClient

@Configuration(proxyBeanMethods = false)
class HttpClientConfig {

    @Value("\${client.todo.url}")
    lateinit var todoBaseUrl: String

    @Bean
    fun todoService(): TodoService? {
        val restClient = RestClient.builder()
            .baseUrl(todoBaseUrl)
            .defaultHeader("Content-Type", "application/json")
            .build()

        val factory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return factory.createClient<TodoService>()
    }
}