package ws.api.products.catalog.service.mapping;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.api.products.catalog.model.dto.CategoryDTO;
import ws.api.products.catalog.model.entity.Category;
import ws.api.products.catalog.service.CategoryService;

@Service
public class CategoryMappedService implements InitializingBean {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ModelMapper modelMapper;

	private TypeMap<CategoryDTO, Category> toCategoryConverter;
	private TypeMap<Category, CategoryDTO> toDtoConverter;

	public List<CategoryDTO> findAll() {
		var result = categoryService.findAll();
		return result.stream().map(toDtoConverter::map).collect(Collectors.toList());
	}

	public CategoryDTO create(CategoryDTO category) {
		var mapped = categoryService.create(toCategoryConverter.map(category));
		return toDtoConverter.map(mapped);
	}

	public CategoryDTO update(CategoryDTO category) {
		var mapped = categoryService.update(toCategoryConverter.map(category));
		return toDtoConverter.map(mapped);
	}

	public void deleteById(UUID id) {
		categoryService.deleteById(id);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		toCategoryConverter = modelMapper.typeMap(CategoryDTO.class, Category.class);
		toDtoConverter = modelMapper.typeMap(Category.class, CategoryDTO.class);
	}
}
