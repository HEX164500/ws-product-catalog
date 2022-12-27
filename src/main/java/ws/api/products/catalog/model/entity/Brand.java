package ws.api.products.catalog.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "brands")
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "uuid", insertable = false, updatable = false, nullable = false)
	private UUID uuid;

	@Column(name = "name", nullable = false, length = 128)
	private String name;

}
