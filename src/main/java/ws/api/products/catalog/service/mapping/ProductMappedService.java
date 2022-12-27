package ws.api.products.catalog.service.mapping;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.api.products.catalog.model.dto.ProductDTO;
import ws.api.products.catalog.model.entity.Product;
import ws.api.products.catalog.service.ProductService;

@Service
public class ProductMappedService implements InitializingBean {

	@Autowired
	private ProductService productService;

	@Autowired
	private ModelMapper modelMapper;

	private TypeMap<ProductDTO, Product> toProductConverter;
	private TypeMap<Product, ProductDTO> toDtoConverter;

	public List<ProductDTO> findAll() {
		var result = productService.findAll();
		return result.stream().map(toDtoConverter::map).collect(Collectors.toList());
	}

	public ProductDTO create(ProductDTO product) {
		var mapped = productService.create(toProductConverter.map(product));
		return toDtoConverter.map(mapped);
	}

	public ProductDTO update(ProductDTO product) {
		var mapped = productService.update(toProductConverter.map(product));
		return toDtoConverter.map(mapped);
	}

	public void deleteById(UUID id) {
		productService.deleteById(id);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		toProductConverter = modelMapper.typeMap(ProductDTO.class, Product.class);
		toDtoConverter = modelMapper.typeMap(Product.class, ProductDTO.class);
	}
}
