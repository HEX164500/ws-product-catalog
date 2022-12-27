package ws.api.products.catalog.model.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BrandDTO {

	@org.hibernate.validator.constraints.UUID(allowNil = false)
	private UUID uuid;

	@NotBlank
	@Size(max = 128)
	private String name;
}
