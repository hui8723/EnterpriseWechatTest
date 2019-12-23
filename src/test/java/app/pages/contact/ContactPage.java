package app.pages.contact;

import app.pages.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactPage extends BasePage {

    public ContactPage toSearch(String searchContent) {
        click(By.id("com.tencent.wework:id/fa1"));
        findElement(By.id("com.tencent.wework:id/ect")).clear();
        findElement(By.id("com.tencent.wework:id/ect")).sendKeys(searchContent);
//        driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
        return this;
    }

    public List<String> getSearchResult() {
        List<String> result = new ArrayList<>();
        findElements(By.id("com.tencent.wework:id/cw1")).forEach(element -> {
            System.out.println(element.findElement(MobileBy.className("android.widget.TextView")).getText());
            result.add(element.findElement(MobileBy.className("android.widget.TextView")).getText());
        });
        System.out.println(result);
        System.out.println("搜索结果" + result);
        return result;
    }


}
