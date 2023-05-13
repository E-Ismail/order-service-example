package guru.springframework.orderservice.bootstrap;

import guru.springframework.orderservice.domain.Customer;
import guru.springframework.orderservice.domain.Product;
import guru.springframework.orderservice.domain.ProductStatus;
import guru.springframework.orderservice.repositories.CustomerRepository;
import guru.springframework.orderservice.repositories.OrderHeaderRepository;
import guru.springframework.orderservice.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  5/7/2023
 */
@Component
public class Bootstrap implements CommandLineRunner {


    private final OrderHeaderRepository orderHeaderRepository;
    private final CustomerRepository customerRepository;

    private final ProductService productService;

    private final BootstrapOrderService bootstrapOrderService;

    public Bootstrap(OrderHeaderRepository orderHeaderRepository, CustomerRepository customerRepository, ProductService productService, BootstrapOrderService bootstrapOrderService) {
        this.orderHeaderRepository = orderHeaderRepository;
        this.customerRepository = customerRepository;
        this.productService = productService;
        this.bootstrapOrderService = bootstrapOrderService;
    }

    private void updateProduct() {
        Product product = new Product();
        product.setDescription("My Product");
        product.setProductStatus(ProductStatus.NEW);

        Product savedProduct = productService.saveProduct(product);

        //savedProduct.setQuantityOnHand(25);

        Product savedProduct2 = productService.updateQOH(savedProduct.getId(), 25);

        System.out.println("Update Qty: " + savedProduct2.getQuantityOnHand());
    }


    //@Transactional will fail bcs of lazily initialization ...
    // see spring docs: Because of proxy method
//    public void readOrderData() {
//        OrderHeader orderHeader = orderHeaderRepository.findById(1L).get();
//        orderHeader.getOrderLines().forEach(orderLine -> {
//            System.out.println(orderLine.getProduct().getDescription());
//
//            orderLine.getProduct().getCategories().forEach(cat -> {
//                System.out.println(cat.getDescription());
//            });
//        });
//    }


    @Override
    //Internal call
    public void run(String... args) throws Exception {

        updateProduct();

        //external call of readOrderData() cause to be around the proxy
        bootstrapOrderService.readOrderData();

        Customer customer = new Customer();
        customer.setCustomerName("Testing version");
        Customer savedCustomer = customerRepository.save(customer);

        System.out.println("Version is: " + savedCustomer.getVersion());

        savedCustomer.setCustomerName("Testing version 2");
        Customer savedCustomer2 = customerRepository.save(savedCustomer);
        System.out.println("Version is: " + savedCustomer2.getVersion());

        savedCustomer.setCustomerName("Testing version 3");
        Customer savedCustomer3 = customerRepository.save(savedCustomer2);
        System.out.println("Version is: " + savedCustomer3.getVersion());

        customerRepository.delete(savedCustomer3);
        //customerRepository.deleteById(savedCustomer2.getId());
        //customerRepository.deleteById(savedCustomer3.getId());
    }
}
