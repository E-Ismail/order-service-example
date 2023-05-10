package guru.springframework.orderservice.services;

import guru.springframework.orderservice.domain.Product;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  5/10/2023
 */

public interface ProductService {

    Product saveProduct(Product product);

    Product updateQOH(Long id, Integer quantityOnHand);
}
