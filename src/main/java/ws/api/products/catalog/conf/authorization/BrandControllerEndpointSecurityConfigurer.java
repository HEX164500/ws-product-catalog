package ws.api.products.catalog.conf.authorization;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

import ws.api.commons.security.authorization.EndpointSecurityConfigurer;
import ws.api.commons.security.authorization.roles.productcatalog.BrandRoles;
import ws.api.products.catalog.controller.endpoint.BrandController;

@Component
public class BrandControllerEndpointSecurityConfigurer implements EndpointSecurityConfigurer {

	@Override
	public void secure(HttpSecurity http) throws Exception {

		String path = WebMvcLinkBuilder.linkTo(BrandController.class).toUri().getPath();

		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.GET, path)
				.hasRole(BrandRoles.READ_ALL_BRANDS.name());

		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.POST, path)
				.hasRole(BrandRoles.CREATE_BRAND_ITEM.name());

		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.PUT, path)
				.hasRole(BrandRoles.UPDATE_SINGLE_BRAND.name());

		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.DELETE, path)
				.hasRole(BrandRoles.DELETE_SINGLE_BRAND.name());
	}

}
