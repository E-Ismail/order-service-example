package guru.springframework.orderservice.domain;

import jakarta.persistence.Entity;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  3/29/2023
 */
@Entity
public class OrderApproval extends BaseEntity {
    private String approvedBy;

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }


}
