package app.core;

import app.pages.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PageObjectElement {

    public List<HashMap<String,String>> element = new ArrayList<>();

    public By getLocator(){
        String platform = BasePage.driver.getCapabilities().getPlatform().toString().toLowerCase();
        String version = BasePage.driver.getCapabilities().getVersion().toLowerCase();
        for(HashMap<String, String> map : element){
            if (map.get("os") != null) {
                switch (platform) {
                    case "android":
                        if (map.get("version") != null) {
//                            不同版本判断
                            return locator(map);
                        }else {
                            return locator(map);
                        }
                    case "ios":
                        return locator(map);
                }
            }
            return locator(map);
        }
        return null;
    }

    private By locator(HashMap<String,String> map) {
        if (map.get("id") != null) {
            return By.id(map.get("id"));
        }else if (map.get("xpath") != null) {
            return By.xpath(map.get("xpath"));
        }else if(map.get("aid")!=null){
            return MobileBy.AccessibilityId(map.get("aid"));
        }
        return null;
    }
}
