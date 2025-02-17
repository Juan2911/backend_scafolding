package com.myapp.infrastructure.clients.webClient.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import java.time.Duration;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        // Configuración de timeouts
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)  // Timeout de conexión
                .responseTimeout(Duration.ofMillis(5000))  // Timeout de respuesta
                .doOnConnected(conn ->
                        conn.addHandlerLast(new IdleStateHandler(0, 0, 5))  // Timeout por inactividad
                );

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient));  // Usar el HttpClient configurado
    }
}
