package guru.springframework.orderservice.bootstrap;

import guru.springframework.orderservice.domain.OrderHeader;
import guru.springframework.orderservice.repositories.OrderHeaderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  5/9/2023
 */
@Service
public class BootstrapOrderService {

    @Autowired
    OrderHeaderRepository orderHeaderRepository;

    @Transactional
    public void readOrderData() {
        //This is the problem in read-only situation
        OrderHeader orderHeader = orderHeaderRepository.findById(1L).get();
        orderHeader.getOrderLines().forEach(orderLine -> {
            System.out.println(orderLine.getProduct().getDescription());

            orderLine.getProduct().getCategories().forEach(cat -> {
                System.out.println(cat.getDescription());
            });
        });
    }
}
