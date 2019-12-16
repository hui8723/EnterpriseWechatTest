package selenium.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import selenium.pages.Web;

public class BaseTest {

    public static Web web;

    @BeforeAll
    public static void beforeAll() {
        web = new Web();
        web.loginWithCookie();
    }

    @AfterAll
    public static void afterAll() throws InterruptedException {
        web.quit();
    }

}
