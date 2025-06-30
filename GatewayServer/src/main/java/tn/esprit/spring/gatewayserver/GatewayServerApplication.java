package tn.esprit.spring.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

/*    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("livres-route", p -> p.path("/api/livres/**").uri("http://localhost:8082")) // Forward requests to 8082
//                .route("author-route", p -> p.path("/api/livres/**").uri("http://localhost:8082")) // Forward requests to 8082
                .build();
    }*/
}
