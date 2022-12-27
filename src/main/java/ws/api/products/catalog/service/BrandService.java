package ws.api.products.catalog.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.api.products.catalog.data.repository.BrandRepository;
import ws.api.products.catalog.model.entity.Brand;

@Service
public class BrandService {

	@Autowired
	private BrandRepository repository;

	public List<Brand> findAll() {
		return repository.findAll();
	}

	public Brand create(Brand brand) {

		Objects.requireNonNull(brand);
		brand.setUuid(null);

		return repository.save(brand);
	}

	public Brand update(Brand brand) {

		Objects.requireNonNull(brand);
		Objects.requireNonNull(brand.getUuid());

		return repository.save(brand);
	}

	public void deleteById(UUID id) {
		repository.deleteById(id);
	}
}
