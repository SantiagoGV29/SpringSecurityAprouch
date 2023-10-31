package io.jwttry.my_app.repos;

import io.jwttry.my_app.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
