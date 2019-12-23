package app.testcase;

import app.pages.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;

public class BaseTest {

    public static App app;

    @BeforeAll
    public static void initAll() throws MalformedURLException {
        app = App.getInstance();
        app.start().toMain();
    }

    @AfterAll
    public static void tearDown() {
        app.quit();
    }
}
