package ws.api.products.catalog.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.api.products.catalog.data.repository.CategoryRepository;
import ws.api.products.catalog.model.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category create(Category category) {

		Objects.requireNonNull(category);
		category.setUuid(null);

		return repository.save(category);
	}

	public Category update(Category category) {

		Objects.requireNonNull(category);
		Objects.requireNonNull(category.getUuid());

		return repository.save(category);
	}

	public void deleteById(UUID id) {
		repository.deleteById(id);
	}
}
