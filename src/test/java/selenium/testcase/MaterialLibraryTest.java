package selenium.testcase;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import utils.ScreeShotUtils;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MaterialLibraryTest extends BaseTest {

    String filePath = System.getProperty("user.dir") +"/target/classes/selenium/add_file.txt";
    String picturePath = System.getProperty("user.dir") +"/target/classes/selenium/test_picture_new.jpg";
    String shotPath = ScreeShotUtils.DIR + "m.jpg";

    @Test
    public void test_add_picture() {
        List<String> pictureList = web.toManagerTools().toMaterialLibrary().addPicture(picturePath).getPictureList();
        System.out.println(pictureList);
        assertThat(pictureList,hasItem("test_picture_new.jpg"));
    }

    @Test
    public void test_add_test_and_picture() {
        List<String> list = web.toManagerTools()
                .toMaterialLibrary()
                .addTextAndPicture("test add test and picture","test add test and picture", filePath,picturePath,"test01")
                .getTextAndPictureList();
        System.out.println(list);
        assertThat(list,hasItem("test add test and picture"));
    }

    @Test
    public void test_add_file() {
        List<String> fileList = web.toManagerTools().toMaterialLibrary().addFile(filePath).getFileList();
        System.out.println(fileList);
        assertThat(fileList,hasItem("add_file.txt"));
    }

    @Test
    public void test_snapshot() {
        web.toManagerTools().toMaterialLibrary().getSnapshot(shotPath);

    }
}
