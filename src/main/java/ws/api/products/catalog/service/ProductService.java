package ws.api.products.catalog.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.api.products.catalog.data.repository.ProductRepository;
import ws.api.products.catalog.model.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product create(Product product) {

		Objects.requireNonNull(product);
		product.setUuid(null);

		return repository.save(product);
	}

	public Product update(Product product) {

		Objects.requireNonNull(product);
		Objects.requireNonNull(product.getUuid());

		return repository.save(product);
	}

	public void deleteById(UUID id) {
		repository.deleteById(id);
	}
}
