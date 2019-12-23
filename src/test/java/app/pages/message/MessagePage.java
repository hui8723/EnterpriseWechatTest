package app.pages.message;

import app.pages.BasePage;
import app.pages.contact.ChooseContactPage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MessagePage extends BasePage {

    public MessagePage toAdd() {
        click(By.id("com.tencent.wework:id/f_r"));
        return this;
    }

    public ChooseContactPage newGroupChat() {
        toAdd();
        click(MobileBy.xpath(textviewXpath("com.tencent.wework:id/cw8","发起群聊")));
        findElements(By.id("com.tencent.wework:id/cp1")).forEach(element -> {
            try {
                element.findElement(By.xpath("//*[@resource-id='com.tencent.wework:id/cw1']/android.widget.TextView[@text='唐明惠']"));
                element.findElement(By.id("com.tencent.wework:id/ef4")).click();
            }catch (Exception e) {

            }
        });
        click(By.id("com.tencent.wework:id/ef3"));
        return new ChooseContactPage();
    }

    public MessagePage rest(Boolean hasOffWork) {
        toAdd();
        click(MobileBy.xpath(textviewXpath("com.tencent.wework:id/cw8","休息一下")));
        if (hasOffWork) {
            click(By.id("com.tencent.wework:id/ad6"));
        }else {
            click(By.id("com.tencent.wework:id/ad5"));
        }
        return this;
    }

    public MessagePage endRest() {
        toAdd();
        click(MobileBy.xpath(textviewXpath("com.tencent.wework:id/cw8","结束休息")));
        return this;
    }

    public Boolean hasRest() {
//        3秒内查询此id是否显示出来
        try {
            new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.tencent.wework:id/e57")));
            return true;
        }catch (TimeoutException e) {
            return false;
        }
    }

}
