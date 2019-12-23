package app.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public Long curTime = System.currentTimeMillis();

    public static AndroidDriver<WebElement> driver;

    public WebElement findElement(By by) {
        System.out.println(by);
        try {
            return driver.findElement(by);
        }catch (Exception e) {
            handleAlert();
            System.out.println(by);
            return driver.findElement(by);
        }
    }

    public void click(By by) {
        System.out.println(by);
        try {
            driver.findElement(by).click();
        }catch (Exception e) {
            handleAlert();
            System.out.println(by);
            driver.findElement(by).click();
        }
    }

    public List<WebElement> findElements(By by) {
        System.out.println(by);
        return driver.findElements(by);
    }

    private void handleAlert() {
//        包含广告、升级框、提示框(每一个建立一个方法作出相应处理)
        List<By> alertBoxs = new ArrayList<>();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        alertBoxs.forEach(alert -> {
            System.out.println(alert);
            List<WebElement> ads = driver.findElements(alert);
            ads.get(0).click();
        });
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void handleAlertByPageSource() {
        String xml = driver.getPageSource();
        List<String> alertBoxs = new ArrayList<>();
        alertBoxs.add("xxx");
        alertBoxs.add("yyy");

        alertBoxs.forEach(alert -> {
            if (xml.contains(alert)) {
                driver.findElement(By.id(alert)).click();
            }
        });
    }

    /**
     * 对于样式一致，文字不同的控件定位统一封装，如自定义控件
     */
    public String textviewXpath(String id,String text) {
        StringBuilder sf = new StringBuilder();
        sf.append("//android.widget.TextView[@resource-id='");
        sf.append(id);
        sf.append("' and @text='");
        sf.append(text);
        sf.append("']");
        System.out.println(sf.toString());
        return sf.toString();
        //android.widget.TextView[@resource-id='com.tencent.wework:id/cw8' and @text='我']

    }

}
