package ws.api.products.catalog.service.mapping;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.api.products.catalog.model.dto.BrandDTO;
import ws.api.products.catalog.model.entity.Brand;
import ws.api.products.catalog.service.BrandService;

@Service
public class BrandMappedService implements InitializingBean {

	@Autowired
	private BrandService brandService;

	@Autowired
	private ModelMapper modelMapper;

	private TypeMap<BrandDTO, Brand> toBrandConverter;
	private TypeMap<Brand, BrandDTO> toDtoConverter;

	public List<BrandDTO> findAll() {
		var result = brandService.findAll();
		return result.stream().map(toDtoConverter::map).collect(Collectors.toList());
	}

	public BrandDTO create(BrandDTO brand) {
		var mapped = brandService.create(toBrandConverter.map(brand));
		return toDtoConverter.map(mapped);
	}

	public BrandDTO update(BrandDTO brand) {
		var mapped = brandService.update(toBrandConverter.map(brand));
		return toDtoConverter.map(mapped);
	}

	public void deleteById(UUID id) {
		brandService.deleteById(id);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		toBrandConverter = modelMapper.typeMap(BrandDTO.class, Brand.class);
		toDtoConverter = modelMapper.typeMap(Brand.class, BrandDTO.class);
	}
}
