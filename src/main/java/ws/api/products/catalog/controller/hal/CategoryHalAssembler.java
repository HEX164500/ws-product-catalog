package ws.api.products.catalog.controller.hal;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ws.api.products.catalog.controller.endpoint.CategoryController;
import ws.api.products.catalog.model.dto.CategoryDTO;

@Component
public class CategoryHalAssembler implements SimpleRepresentationModelAssembler<CategoryDTO> {

	@Override
	public void addLinks(EntityModel<CategoryDTO> resource) {

		var update = linkTo(CategoryController.class).withRel("update");
		var delete = linkTo(CategoryController.class).slash(resource.getContent().getUuid()).withRel("delete");

		resource.add(update, delete);
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<CategoryDTO>> resources) {
	}

}
