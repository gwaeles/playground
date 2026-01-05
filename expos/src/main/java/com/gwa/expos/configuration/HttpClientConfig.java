package com.gwa.expos.configuration;

import com.gwa.expos.service.TodoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration(proxyBeanMethods = false)
public class HttpClientConfig {

  @Value("${client.todo.url}")
  private String todoBaseUrl;

  @Bean
  public TodoService todoService() {
    RestClient restClient = RestClient.builder()
        .baseUrl(todoBaseUrl)
        .defaultHeader("Content-Type", "application/json")
        .build();

    HttpServiceProxyFactory factory = HttpServiceProxyFactory
        .builderFor(RestClientAdapter.create(restClient))
        .build();

    return factory.createClient(TodoService.class);
  }
}
