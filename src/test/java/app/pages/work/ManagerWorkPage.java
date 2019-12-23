package app.pages.work;

import app.pages.BasePage;
import org.openqa.selenium.By;
import utils.ScrollUtils;
import utils.UIAutomatorUtils;

public class ManagerWorkPage extends BasePage {

    public WorkPage change(String workName,Boolean hasAdd) {
        clickAddOrDel(workName,hasAdd);
        click(By.id("com.tencent.wework:id/f_o"));
        return new WorkPage();
    }

    private void clickAddOrDel(String workName,Boolean hasAdd) {
        if (hasAdd) {
//            可视化操作。
            ScrollUtils.swape(driver,0.5,0.8,0.5,0.1);
        }
        findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.tencent.wework:id/oj']/android.widget.RelativeLayout")).forEach(element -> {

            try {
////                不是所有的RelativeLayout都有以下元素。
//                String loc = "resourceId(\"com.tencent.wework:id/ddl\").text(\"客户群\")";
//                String scroll_loc = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" + loc + "\"))";
//                driver.findElementByAndroidUIAutomator(loc).click();
                if (element.findElement(By.id("com.tencent.wework:id/ddl")).getText().equals(workName)) {

                    System.out.println(By.id("com.tencent.wework:id/bl"));
                    element.findElement(By.id("com.tencent.wework:id/bl")).click();
                    return;
                }
            } catch (Exception e) {
            }

        });
    }

}
