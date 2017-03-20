package org.chiwooplatform.cloud.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class CircuitBreakerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run( CircuitBreakerApplication.class, args );
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate( RestTemplateBuilder builder )
    {
        return builder.build();
    }
}
