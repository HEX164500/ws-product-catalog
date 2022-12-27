package ws.api.products.catalog.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.api.products.catalog.model.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {

}
