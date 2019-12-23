package app.pages.mine;

import app.pages.App;
import app.pages.BasePage;
import org.openqa.selenium.By;
import utils.ScrollUtils;

public class MinePage extends BasePage {

    public App logout() {
        ScrollUtils.swape(driver,0.5,0.8,0.5,0.5);
        click(By.id("com.tencent.wework:id/elb"));
        click(By.id("com.tencent.wework:id/elf"));
        click(By.id("com.tencent.wework:id/at7"));
        click(By.id("com.tencent.wework:id/ata"));
        return App.getInstance();

    }
}
