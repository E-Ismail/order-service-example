package guru.springframework.orderservice.services;

import guru.springframework.orderservice.domain.Product;
import guru.springframework.orderservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  5/10/2023
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        //SaveAndFlush changes will be flushed to DB immediately
        //Save it's not true, may stay in memory until flush or commit command are issued
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product updateQOH(Long id, Integer quantityOnHand) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setQuantityOnHand(quantityOnHand);
        return productRepository.saveAndFlush(product);
    }
}
