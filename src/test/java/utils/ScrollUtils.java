package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ScrollUtils {

    public static void swape(AndroidDriver<WebElement> driver, double startX, double startY, double endX, double endY) {
        Dimension size = driver.manage().window().getSize();
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point((int) (size.width * startX), (int) (size.height * startY)));
        touchAction.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
        touchAction.moveTo(PointOption.point((int) (size.width * endX),(int) (size.height*endY)));
        touchAction.release();
        touchAction.perform();
    }
}
