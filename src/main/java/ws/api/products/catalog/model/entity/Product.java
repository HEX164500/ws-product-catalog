package ws.api.products.catalog.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import ws.api.products.catalog.model.enumeration.ComercialUnit;
import ws.api.products.catalog.model.enumeration.ProductType;

@Data
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "uuid", insertable = false, updatable = false, nullable = false)
	private UUID uuid;

	@Column(name = "name", nullable = false, length = 128)
	private String name;

	@Column(name = "description", nullable = true, length = 512)
	private String description;

	@Column(name = "barcode", nullable = false, length = 40)
	private String barcode;

	@Column(name = "gtin", nullable = true, length = 14)
	private String gtin;

	@Column(name = "dun14", nullable = true, length = 14)
	private String dun14;

	@Column(name = "units_per_pack", nullable = false)
	private Short unitsPerPack;

	@Column(name = "comercial_unit", nullable = false, length = 20)
	private ComercialUnit comercialUnit;

	@Enumerated(EnumType.STRING)
	@Column(name = "product_type", nullable = false, length = 32)
	private ProductType productType;

	@ManyToOne
	@JoinColumn(name = "category_uuid")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "brand_uuid")
	private Brand brand;
}
