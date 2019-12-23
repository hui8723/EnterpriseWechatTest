package app.pages;

import app.pages.contact.ContactPage;
import app.pages.message.MessagePage;
import app.pages.mine.MinePage;
import app.pages.work.WorkPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class App extends BasePage {

    private App() {}

    private static App app;

    public static App getInstance() {
        if (null == app) {
            app = new App();
        }
        return app;
    }

    public App start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName","W8RDU15919004616");
        desiredCapabilities.setCapability("appPackage", "com.tencent.wework");
        desiredCapabilities.setCapability("appActivity", ".launch.AppSchemeLaunchActivity");
//        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("noReset", false);
//        自动给app付权限
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("udid", System.getenv("UDID"));

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//        等待App启动
        new WebDriverWait(driver,40)
                .until(x->
                {
                    return isAppPage();
                });

        return this;
    }

    public Boolean isAppPage() {
        String xml = driver.getPageSource();
        return xml.contains("微信登录") || xml.contains("手机号登录");
    }

    public App toMain() {
        click(By.id("com.tencent.wework:id/sz"));
        click(By.id("com.tencent.wework:id/be1"));
        return this;
    }

    public ContactPage toContact() {
        click(MobileBy.xpath("//android.view.View[@resource-id='com.tencent.wework:id/eyy']/android.widget.RelativeLayout[2]"));
        return new ContactPage();
    }

    public MessagePage toMessage() {
        click(MobileBy.xpath("//android.view.View[@resource-id='com.tencent.wework:id/eyy']/android.widget.RelativeLayout[1]"));
        return new MessagePage();
    }

    public MinePage toMine() {
        click(MobileBy.xpath("//android.view.View[@resource-id='com.tencent.wework:id/eyy']/android.widget.RelativeLayout[4]"));
        return new MinePage();
    }

    public WorkPage toWork() {
        click(MobileBy.xpath("//android.view.View[@resource-id='com.tencent.wework:id/eyy']/android.widget.RelativeLayout[3]"));
        return new WorkPage();
    }

    public void quit() {
        driver.quit();
    }
}
