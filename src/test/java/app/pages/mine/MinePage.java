package app.pages.mine;

import app.pages.App;
import app.pages.BasePage;
import org.openqa.selenium.By;

public class MinePage extends BasePage {

    public App logout() {
//        TODO scroll
        click(By.id("com.tencent.wework:id/elb"));
        click(By.id("com.tencent.wework:id/elf"));
        click(By.id("com.tencent.wework:id/at7"));
        click(By.id("com.tencent.wework:id/ata"));
        return App.getInstance();

    }
}
