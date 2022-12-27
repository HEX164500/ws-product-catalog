package ws.api.products.catalog.model.dto;

import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ws.api.products.catalog.model.enumeration.ComercialUnit;
import ws.api.products.catalog.model.enumeration.ProductType;

@Data
public class ProductDTO {

	@org.hibernate.validator.constraints.UUID
	private UUID uuid;

	@NotBlank
	@Size(max = 128)
	private String name;

	@Size(max = 512)
	private String description;

	@NotBlank
	@Size(max = 40)
	private String barcode;

	@Size(max = 14)
	private String gtin;

	@Size(max = 14)
	private String dun14;

	@Positive
	private Short unitsPerPack;

	@NotNull
	private ComercialUnit comercialUnit;

	@NotNull
	private ProductType productType;

	@Valid
	private CategoryDTO category;

	@Valid
	private BrandDTO brand;
}
