package ws.api.products.catalog.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.api.products.catalog.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
