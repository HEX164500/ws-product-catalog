package ws.api.products.catalog.conf.authorization;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

import ws.api.commons.security.authorization.EndpointSecurityConfigurer;
import ws.api.commons.security.authorization.roles.productcatalog.CategoryRoles;
import ws.api.products.catalog.controller.endpoint.CategoryController;

@Component
public class CategoryControllerEndpointSecurityConfigurer implements EndpointSecurityConfigurer {

	@Override
	public void secure(HttpSecurity http) throws Exception {

		String path = WebMvcLinkBuilder.linkTo(CategoryController.class).toUri().getPath();

		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.GET, path)
				.hasRole(CategoryRoles.READ_ALL_CATEGORIES.name());

		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.POST, path)
				.hasRole(CategoryRoles.CREATE_CATEGORY_ITEM.name());

		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.PUT, path)
				.hasRole(CategoryRoles.UPDATE_SINGLE_CATEGORY.name());

		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.DELETE, path)
				.hasRole(CategoryRoles.DELETE_SINGLE_CATEGORY.name());
	}

}
