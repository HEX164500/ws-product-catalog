package ws.api.products.catalog.conf;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import ws.api.commons.security.RoleBasedJwtAuthenticationConverter;
import ws.api.commons.security.authorization.EndpointSecurityConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private Collection<EndpointSecurityConfigurer> endpointSecurityConfigurers;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.oauth2ResourceServer().jwt(configurer -> {
			configurer.jwtAuthenticationConverter(RoleBasedJwtAuthenticationConverter.singleton());
		});

		//http.anonymous().disable();

		for (EndpointSecurityConfigurer securityConfigurer : endpointSecurityConfigurers) {
			securityConfigurer.secure(http);
		}

		return http.build();
	}
}
