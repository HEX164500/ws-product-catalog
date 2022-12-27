package ws.api.products.catalog.controller.hal;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ws.api.products.catalog.controller.endpoint.ProductController;
import ws.api.products.catalog.model.dto.ProductDTO;

@Component
public class ProductHalAssembler implements SimpleRepresentationModelAssembler<ProductDTO> {

	@Override
	public void addLinks(EntityModel<ProductDTO> resource) {

		var update = linkTo(ProductController.class).withRel("update");
		var delete = linkTo(ProductController.class).slash(resource.getContent().getUuid()).withRel("delete");

		resource.add(update, delete);
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<ProductDTO>> resources) {
	}

}
