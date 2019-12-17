package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import utils.ScreeShotUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 素材库
 */
public class MaterialLibraryPage extends BasePage{

    public MaterialLibraryPage addTextAndPicture(String title,String content,String filePath,String picturePath,String author) {
        findElement(By.linkText("图文")).click();
        findElement(By.linkText("添加图文")).click();

        findElement(By.cssSelector("#js_mpNews_editor_wrap .ww_editorTitle")).sendKeys(title);
//        new Actions(driver).contextClick().perform(); 鼠标右键
//        new Actions().moveByOffset(0,1200).perform();
//        System.out.println(driver.getWindowHandles());
        driver.switchTo().frame("ueditor_0");
        findElement(By.cssSelector("body")).sendKeys(content);
        driver.switchTo().defaultContent();

        findInput(By.name("uploadImageFile")).sendKeys(filePath);

        ((JavascriptExecutor)(driver)).executeScript("window.scroll(0, 1200)");
        findElement(By.cssSelector(".msg_infoItem_coverPlaceHolder")).click();
        findInput(By.xpath("//input[@class=\"ww_fileInput js_file\"]")).sendKeys(picturePath);
        findElement(By.linkText("确定")).click();
        findElement(By.cssSelector(".js_amrd_author_input"),20).sendKeys(author);
        findElement(By.linkText("完成")).click();
        return this;
    }

    public List getTextAndPictureList() {
        sleep(3);
        List<String> list = new ArrayList<String>();
        driver.findElements(By.cssSelector(".ww_msgCard_item_title")).forEach(webElement -> {
            list.add(webElement.getText());
        });
        return list;
    }

    public MaterialLibraryPage addPicture(String picPath) {
        findElement(By.linkText("图片")).click();
        findElement(By.linkText("添加图片")).click();
        findElement(By.name("uploadImageFile"),0).sendKeys(picPath);
        findElement(By.linkText("完成")).click();
        return this;
    }

    public List<String> getPictureList() {
        sleep(3);
        List<String> list = new ArrayList<String>();
        driver.findElements(By.cssSelector(".js_pic_name_show")).forEach(element -> {
            list.add(element.getText());
        });
        return list;
    }

    public MaterialLibraryPage addFile(String filePath) {
        findElement(By.linkText("文件")).click();
        findElement(By.linkText("添加文件")).click();
        findElement(By.id("js_upload_input"),0).sendKeys(filePath);
        findElement(By.linkText("完成")).click();
        return this;
    }

    public List<String> getFileList() {
//        等待图片列表更新完成
        sleep(3);
        List<String> list = new ArrayList<String>();
        driver.findElements(By.cssSelector(".js_file_show_name")).forEach(element -> {
            list.add(element.getText());
        });
        return list;

    }

    public void getSnapshot(String shotPath) {
        ScreeShotUtils.snapshot((TakesScreenshot)driver,shotPath);
    }
}
