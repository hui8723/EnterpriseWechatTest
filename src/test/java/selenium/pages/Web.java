package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Web extends BasePage{

    public void loginWithCookie() {
        String url = "https://work.weixin.qq.com/";

        ChromeOptions options = new ChromeOptions();
/*
* page load 模式不建议使用
* 可用于解决页面加载缓慢，但对底层注释了解足够熟悉才可以用
* */
//        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        /*需把chrome driver放置于系统环境变量中*/
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();
        driver.manage().addCookie(new Cookie("wwrtx.refid","3300316855743240"));
        driver.manage().addCookie(new Cookie("wwrtx.sid","gdkdzt44z4BQ7RBFWf9humUFxuVuSaB5_8qNjF8U3QxmsqLA1ElPhCONN_LmsKhR"));
        driver.navigate().refresh();
    }


    public ContactPage toContact() {
        findElement(By.linkText("通讯录")).click();
        waitClickable(By.linkText("组织架构"),8);
        return new ContactPage();
    }

    public ContactPage toAddUser() {
        findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }

    public AppManagerPage toAppManager() {
        findElement(By.linkText("应用管理")).click();
        return new AppManagerPage();
    }

}
