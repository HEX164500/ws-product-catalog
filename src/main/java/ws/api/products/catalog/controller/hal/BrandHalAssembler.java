package ws.api.products.catalog.controller.hal;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ws.api.products.catalog.controller.endpoint.BrandController;
import ws.api.products.catalog.model.dto.BrandDTO;

@Component
public class BrandHalAssembler implements SimpleRepresentationModelAssembler<BrandDTO> {

	@Override
	public void addLinks(EntityModel<BrandDTO> resource) {

		var update = linkTo(BrandController.class).withRel("update");
		var delete = linkTo(BrandController.class).slash(resource.getContent().getUuid()).withRel("delete");

		resource.add(update, delete);
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<BrandDTO>> resources) {
	}

}
