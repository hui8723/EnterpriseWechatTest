package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static WebDriver driver;

    public WebElement findElement(By by) {
        return findElement(by,10);
    }

    public WebElement findInput(By by) {
        return findElement(by,0);
    }

    public WebElement findElement(By by,int timeout) {
        System.out.println(by);
        if (timeout > 0) {
            waitClickable(by, timeout);
        }
        return driver.findElement(by);
    }

    public void waitClickable(By by) {
        waitClickable(by,3);
    }

    public void waitClickable(By by,int timeout) {
        new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
        new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void sleep(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void quit() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

}
