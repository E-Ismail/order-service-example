package guru.springframework.orderservice.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  3/27/2023
 */
class OrderHeaderTest {

    @Test
    void testEquals() {
        //GIVEN
        OrderHeader oh1 = new OrderHeader();
        oh1.setId(1L);
        OrderHeader oh2 = new OrderHeader();
        oh2.setId(1L);
        //WHEN
        //THEN
        assertThat(oh1).isEqualTo(oh2);
    }

    @Test
    void testNotEquals() {
        //GIVEN
        OrderHeader oh1 = new OrderHeader();
        oh1.setId(1L);
        OrderHeader oh2 = new OrderHeader();
        oh2.setId(2L);
        //WHEN
        //THEN
        assertFalse(oh1.equals(oh2));
    }
}