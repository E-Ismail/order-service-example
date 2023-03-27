package guru.springframework.orderservice.repositories;

import guru.springframework.orderservice.domain.Product;
import guru.springframework.orderservice.domain.ProductStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  3/27/2023
 */
@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void testSaveProduct() {
        Product product = new Product();
        product.setDescription("New product");
        product.setProductStatus(ProductStatus.NEW);
        Product savedProduct = productRepository.save(product);

        assertAll("It should test product repository",
                () -> assertNotNull(savedProduct),
                () -> assertNotNull(savedProduct.getId()),
                () -> assertNotNull(savedProduct.getCreatedDate()),
                () -> assertNotNull(savedProduct.getLastModifiedDate()));
    }

}