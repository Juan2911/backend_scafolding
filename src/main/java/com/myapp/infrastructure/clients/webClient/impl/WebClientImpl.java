package com.myapp.infrastructure.clients.webClient.impl;

import com.myapp.infrastructure.clients.webClient.IWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WebClientImpl implements IWebClient {

    private final WebClient.Builder webClientBuilder;

    @Override
    public List<String> getDataFromExternalApi(String url /*HttpMethod method, Headers, RequestBody*/) {
        return webClientBuilder.baseUrl(url)
                .build()
                .method(HttpMethod.GET)
                .retrieve()
                .bodyToFlux(String.class)
                .timeout(Duration.ofMillis(5000))  // Timeout adicional para la respuesta
                .onErrorResume(e -> Mono.just("Timeout exceeded, please try again"))
                .collectList()
                .block();  // block() hace que sea sincrónico
    }
}
