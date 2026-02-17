package org.example.gatewayserver.security;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@EnableDiscoveryClient
@Configuration
public class SecurityChain {

  @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
      return http.authorizeExchange(
              authorizeExchangeSpec -> {
                  authorizeExchangeSpec.pathMatchers("/**").permitAll();
                  authorizeExchangeSpec.pathMatchers("/**/*").authenticated();

              }
      ).csrf(ServerHttpSecurity.CsrfSpec::disable)
              .oauth2ResourceServer(oauth2->{oauth2.jwt(jwtSpec -> {});})
              .build();
  }

}
