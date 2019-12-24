package app.testcase;

import app.pages.work.WorkPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorkTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("data")
    public void test_manager(String workName,Boolean hasAdd) {
        WorkPage workPage = app.toWork().toManager().change(workName,hasAdd);
        if (hasAdd) {
            assertTrue(workPage.existWork(workName));
        }else {
            assertFalse(workPage.existWork(workName));
        }
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments("客户联系",false),
                Arguments.arguments("客户联系",true),
                Arguments.arguments("日程",false),
                Arguments.arguments("日程",true),
                Arguments.arguments("审批",false),
                Arguments.arguments("审批",true)
        );
    }
}
