package ws.api.products.catalog.controller.endpoint;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ws.api.products.catalog.controller.hal.ProductHalAssembler;
import ws.api.products.catalog.model.dto.ProductDTO;
import ws.api.products.catalog.service.mapping.ProductMappedService;

@RestController
@RequestMapping(path = "/products", consumes = {
		MediaType.APPLICATION_JSON_VALUE,
		MediaType.ALL_VALUE
}, produces = MediaTypes.HAL_JSON_VALUE)
public class ProductController {

	@Autowired
	private ProductMappedService service;

	@Autowired
	private ProductHalAssembler assembler;

	@GetMapping
	public ResponseEntity<CollectionModel<EntityModel<ProductDTO>>> findAll() {
		var result = service.findAll();
		return ResponseEntity.ok(assembler.toCollectionModel(result));
	}

	@PostMapping
	public ResponseEntity<EntityModel<ProductDTO>> create(@RequestBody ProductDTO product) {
		var result = service.create(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(assembler.toModel(result));
	}

	@PutMapping
	public ResponseEntity<EntityModel<ProductDTO>> update(@RequestBody ProductDTO product) {
		var result = service.update(product);
		return ResponseEntity.ok(assembler.toModel(result));
	}

	@DeleteMapping(path = "/{uuid}")
	public ResponseEntity<Void> deleteById(@PathVariable UUID uuid) {
		return ResponseEntity.noContent().build();
	}

}
