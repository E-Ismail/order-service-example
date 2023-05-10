package guru.springframework.orderservice.bootstrap;

import guru.springframework.orderservice.domain.Customer;
import guru.springframework.orderservice.repositories.CustomerRepository;
import guru.springframework.orderservice.repositories.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  5/7/2023
 */
@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    OrderHeaderRepository orderHeaderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BootstrapOrderService bootstrapOrderService;
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
