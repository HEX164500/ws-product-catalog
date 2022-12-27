package ws.api.products.catalog.conf.authorization;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

import ws.api.commons.security.authorization.EndpointSecurityConfigurer;
import ws.api.commons.security.authorization.roles.productcatalog.ProductRoles;
import ws.api.products.catalog.controller.endpoint.ProductController;

@Component
public class ProductControllerEndpointSecurityConfigurer implements EndpointSecurityConfigurer {

	@Override
	public void secure(HttpSecurity http) throws Exception {

		String path = WebMvcLinkBuilder.linkTo(ProductController.class).toUri().getPath();

		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.GET, path)
				.hasRole(ProductRoles.READ_ALL_PRODUCTS.name());

		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.POST, path)
				.hasRole(ProductRoles.CREATE_PRODUCT_ITEM.name());

		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.PUT, path)
				.hasRole(ProductRoles.UPDATE_SINGLE_PRODUCT.name());

		http.authorizeHttpRequests()
				.requestMatchers(HttpMethod.DELETE, path)
				.hasRole(ProductRoles.DELETE_SINGLE_PRODUCT.name());
	}

}
