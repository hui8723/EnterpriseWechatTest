package selenium.pages;

import org.openqa.selenium.By;

public class AppManagerPage extends BasePage{

    public MaterialLibraryPage toMaterialLibrary() {
        findElement(By.xpath("//div[text()=\"素材库\"]")).click();
        return new MaterialLibraryPage();
    }
}
