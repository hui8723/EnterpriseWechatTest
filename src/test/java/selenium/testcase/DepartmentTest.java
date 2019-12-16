package selenium.testcase;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentTest extends BaseTest {

    String departmentName = "测试部门";
    String departmentNameNew = "新测试部门";

    @Test
    @Order(0)
    public void test_add() {
        web.toContact().addDepartment(departmentName,"测评");
    }

    @Test
    @Order(1)
    public void test_change() {
        web.toContact().changeDepartment(departmentName,departmentNameNew);
    }

    @Test
    @Order(2)
    public void test_up() {
        web.toContact().upDepartment(departmentNameNew);
    }

    @Test
    @Order(3)
    public void test_down() {
        web.toContact().downDepartment(departmentNameNew);
    }

    @Test
    @Order(4)
    public void test_delete() {
        web.toContact().delDepartment(departmentNameNew);
    }
}
