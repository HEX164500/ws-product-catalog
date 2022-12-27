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

import ws.api.products.catalog.controller.hal.BrandHalAssembler;
import ws.api.products.catalog.model.dto.BrandDTO;
import ws.api.products.catalog.service.mapping.BrandMappedService;

@RestController
@RequestMapping(path = "/brands", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
public class BrandController {

	@Autowired
	private BrandMappedService service;

	@Autowired
	private BrandHalAssembler assembler;

	@GetMapping
	public ResponseEntity<CollectionModel<EntityModel<BrandDTO>>> findAll() {
		var result = service.findAll();
		return ResponseEntity.ok(assembler.toCollectionModel(result));
	}

	@PostMapping
	public ResponseEntity<EntityModel<BrandDTO>> create(@RequestBody BrandDTO brand) {
		var result = service.create(brand);
		return ResponseEntity.status(HttpStatus.CREATED).body(assembler.toModel(result));
	}

	@PutMapping
	public ResponseEntity<EntityModel<BrandDTO>> update(@RequestBody BrandDTO brand) {
		var result = service.update(brand);
		return ResponseEntity.ok(assembler.toModel(result));
	}

	@DeleteMapping(path = "/{uuid}")
	public ResponseEntity<Void> deleteById(@PathVariable UUID uuid) {
		service.deleteById(uuid);
		return ResponseEntity.noContent().build();
	}

}
