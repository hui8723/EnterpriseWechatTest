package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreeShotUtils {

    public static final String DIR = "src/test/java/snapshot/";

    public static void snapshot(TakesScreenshot driver,String filename) {
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(srcFile, new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
