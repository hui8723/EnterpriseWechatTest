package app.testcase;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageTest extends BaseTest {

    @Test
    @Order(1)
    public void test_rest() {
        app.toMessage().rest(true);
        assertTrue(app.toMessage().hasRest());
    }

    @Test
    @Order(2)
    public void test_end_rest() {
        app.toMessage().endRest();
        assertFalse(app.toMessage().hasRest());
    }

    @Test
    public void test_newGroupChat() {
        app.toMessage().newGroupChat();
    }


}
