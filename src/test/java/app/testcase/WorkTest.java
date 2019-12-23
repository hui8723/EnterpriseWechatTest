package app.testcase;

import app.pages.work.WorkPage;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.*;

public class WorkTest extends BaseTest {

    @Test
    public void test_manager(String workName,Boolean hasAdd) {
        WorkPage workPage = app.toWork().toManager().change(workName,hasAdd);
        if (hasAdd) {
            assertTrue(workPage.existWork(workName));
        }else {
            assertFalse(workPage.existWork(workName));
        }

    }
}
