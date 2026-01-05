package com.gwa.autumn.configuration

import com.gwa.winter.output.WinterClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import org.springframework.web.service.invoker.createClient

@Configuration(proxyBeanMethods = false)
class HttpClientConfig {

    @Value("\${client.winter.url}")
    lateinit var winterBaseUrl: String

    @Bean
    fun winterClient(): WinterClient {
        val restClient = RestClient.builder()
            .baseUrl(winterBaseUrl)
            .defaultHeader("Content-Type", "application/json")
            .build()

        val factory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return factory.createClient<WinterClient>()
    }
}