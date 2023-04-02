package guru.springframework.orderservice.repositories;

import guru.springframework.orderservice.domain.OrderApproval;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  3/29/2023
 */
public interface OrderApprovalRepository extends JpaRepository<OrderApproval, Long> {
}
