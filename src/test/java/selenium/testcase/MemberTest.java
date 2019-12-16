package selenium.testcase;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberTest extends BaseTest {

    String phone = "15600534762";

    @Test
    @Order(0)
    public void test_add() {
        web.toAddUser().add(phone,phone,phone);
    }

    @Test
    @Order(1)
    public void test_delete() {
        web.toContact().delete(phone);
    }
}
