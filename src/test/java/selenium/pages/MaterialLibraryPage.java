package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

/**
 * 素材库
 */
public class MaterialLibraryPage extends BasePage{

    public MaterialLibraryPage addTextAndPicture(String title,String content,String filePath,String author) {
        findElement(By.linkText("图文")).click();
        findElement(By.linkText("添加图文")).click();
        findElement(By.cssSelector(".ww_editorTitle")).sendKeys(title);

        System.out.println(driver.getWindowHandles());
        driver.switchTo().frame("ueditor_0");
        findElement(By.cssSelector("body")).sendKeys(content);
        driver.switchTo().defaultContent();

        findElement(By.xpath("//input[@class=\"js_amrd_uploadFile ww_fileInput\"]")).click();
//        new Actions(driver).contextClick().perform(); 鼠标右键
//        new Actions().moveByOffset(0,1200).perform();
        ((JavascriptExecutor)(driver)).executeScript("window.scroll(0, 1200)");
        findElement(By.cssSelector(".js_amrd_author_input")).sendKeys(author);
        findElement(By.linkText("完成")).click();
        return this;
    }

    public MaterialLibraryPage addPicture(String picPath) {
        findElement(By.linkText("图片")).click();
        findElement(By.linkText("添加图片")).click();
        findElement(By.name("uploadImageFile")).sendKeys(picPath);
        findElement(By.linkText("完成")).click();
        return this;
    }

    public MaterialLibraryPage addFile(String filePath) {
        findElement(By.linkText("文件")).click();
        findElement(By.linkText("添加文件")).click();
        findElement(By.cssSelector("#js_upload_input")).sendKeys(filePath);
        findElement(By.linkText("完成")).click();
        return this;
    }
}
