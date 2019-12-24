package app.pages.contact;

import app.pages.BasePage;
import org.openqa.selenium.By;


public class ContactPage extends BasePage {

    public SearchContactPage toSearch() {
        click(By.id("com.tencent.wework:id/fa1"));
//        driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
        return new SearchContactPage();
    }


}
