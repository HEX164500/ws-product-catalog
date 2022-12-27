package ws.api.products.catalog.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ws.api.products.catalog.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
