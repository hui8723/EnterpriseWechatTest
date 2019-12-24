package app.pages;

import app.core.PageObjectMethod;
import app.core.PageObjectModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public Long curTime = System.currentTimeMillis();

    public static AndroidDriver<WebElement> driver;

    private PageObjectModel model=new PageObjectModel();

    //测试步骤参数化
    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }

    public static HashMap<String, Object> getParams() {
        return params;
    }

    private static HashMap<String, Object> params=new HashMap<>();

    //测试步骤结果读取
    public static HashMap<String, Object> getResults() {
        return results;
    }

    private static HashMap<String, Object> results=new HashMap<>();

    public WebElement findElement(By by) {
        System.out.println(by);
        try {
            return driver.findElement(by);
        }catch (Exception e) {
            handleAlert();
            System.out.println(by);
            return driver.findElement(by);
        }
    }

    public void click(By by) {
        System.out.println(by);
        try {
            driver.findElement(by).click();
        }catch (Exception e) {
            handleAlert();
            System.out.println(by);
            driver.findElement(by).click();
        }
    }

    public List<WebElement> findElements(By by) {
        System.out.println(by);
        return driver.findElements(by);
    }

//  异常处理机制
    private void handleAlert() {
//        包含广告、升级框、提示框(每一个建立一个方法作出相应处理)
        List<By> alertBoxs = new ArrayList<>();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        alertBoxs.forEach(alert -> {
            System.out.println(alert);
            List<WebElement> ads = driver.findElements(alert);
            ads.get(0).click();
        });
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void handleAlertByPageSource() {
        String xml = driver.getPageSource();
        List<String> alertBoxs = new ArrayList<>();
        alertBoxs.add("xxx");
        alertBoxs.add("yyy");

        alertBoxs.forEach(alert -> {
            if (xml.contains(alert)) {
                driver.findElement(By.id(alert)).click();
            }
        });
    }

    public void parseSteps() {
        String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println("method=" + method);
        parseSteps(method);
    }

    public void parseSteps(String method) {
        String path = "/" + this.getClass().getCanonicalName().replace('.', '/') + ".yaml";
        System.out.println(path);
        parseSteps(path,method);
    }

    public void parseSteps(String path,String method) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            model = mapper.readValue(
                    BasePage.class.getResourceAsStream(path), PageObjectModel.class
            );
            System.out.println(model);
            parseSteps(model.methods.get(method));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseSteps(PageObjectMethod steps) {
        steps.getSteps().forEach(step->{
            WebElement element = null;
            String id=step.get("id");
            if(id!=null){
                element=findElement(By.id(id));
            }else if(step.get("xpath")!=null){
                element=findElement(By.xpath(step.get("xpath")));
            }else if(step.get("aid")!=null){
                element=findElement(MobileBy.AccessibilityId(step.get("aid")));
            }else if(step.get("element")!=null){
                element=findElement(model.elements.get(step.get("element")).getLocator());
            }

            String send=step.get("send");

            if(send!=null){
                //配置文件中的参数替换
                for(Map.Entry<String, Object> kv: params.entrySet()){
                    String matcher="${"+kv.getKey()+"}";
                    if(send.contains(matcher)) {
                        System.out.println(kv);
                        send = send.replace(matcher, kv.getValue().toString());
                    }
                }
                element.sendKeys(send);

            }else if(step.get("get")!=null){
                String attribute=element.getAttribute(step.get("get"));
                getResults().put(step.get("dump"), attribute);

            }else if (step.get("clear") != null) {
                element.clear();
            }
            else{
                element.click();
            }

        });
    }

    /**
     * 对于样式一致，文字不同的控件定位统一封装，如自定义控件
     */
    public String textviewXpath(String id,String text) {
        StringBuilder sf = new StringBuilder();
        sf.append("//android.widget.TextView[@resource-id='");
        sf.append(id);
        sf.append("' and @text='");
        sf.append(text);
        sf.append("']");
        System.out.println(sf.toString());
        return sf.toString();
        //android.widget.TextView[@resource-id='com.tencent.wework:id/cw8' and @text='我']

    }

}
