package com.cloud.gateway.api_gateway.configurations;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public RouteLocator gatewayLocator (RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes().route(r -> r.path("/currency-exchange/**").uri("lb://currency-exchange"))
			       .route(r -> r.path("/currency-conversion-feign/**").uri("lb://currency-conversion")).route(
				r -> r.path("/cc/**")
					     .filters(f -> f.rewritePath("/cc/(?<segment>.*)", "/currency-conversion-feign/${segment}"))
					     .uri("lb://currency-conversion")).build();
	}
}