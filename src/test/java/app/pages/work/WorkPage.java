package app.pages.work;

import app.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WorkPage extends BasePage {

    public ManagerWorkPage toManager() {
        click(By.id("com.tencent.wework:id/f_r"));
        return new ManagerWorkPage();
    }

    public Boolean existWork(String workName) {
        Boolean isExist = false;
        for (WebElement webElement : driver.findElements(By.id("com.tencent.wework:id/ddl"))) {
            if (webElement.getText().equals(workName)) {
                isExist = true;
                return isExist;
            }
        }
        return isExist;
    }

    public WorkPage toDailyPaper() {
        click(By.xpath(textviewXpath("com.tencent.wework:id/ddl","汇报")));
        click(By.xpath(textviewXpath("com.tencent.wework:id/ddl","周报")));
        return this;
    }

}
