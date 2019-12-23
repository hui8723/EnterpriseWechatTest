package app.testcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MineTest extends BaseTest {

    @Test
    public void test_logout() {
        app.toMine().logout();
        assertTrue(app.isAppPage());
    }
}
