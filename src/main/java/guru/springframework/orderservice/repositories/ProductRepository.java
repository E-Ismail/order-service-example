package guru.springframework.orderservice.repositories;

import guru.springframework.orderservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  3/27/2023
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByDescription(String description);
}
