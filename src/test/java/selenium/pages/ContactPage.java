package selenium.pages;

import org.openqa.selenium.By;

public class ContactPage extends BasePage{

    private void gotoDepartment(String name) {
        String xpath = "//a[contains(text(),'" + name + "')]/span";
        findElement(By.linkText(name)).click();
        findElement(By.xpath(xpath)).click();
    }

    public ContactPage addDepartment(String name,String parentName) {
        String xpath = "(//a[contains(text(),'" + parentName + "')])[2]";
        findElement(By.xpath("//a[@class=\"member_colLeft_top_addBtnWrap js_create_dropdown\"]")).click();
        findElement(By.linkText("添加部门")).click();
        findElement(By.name("name")).sendKeys(name);
        findElement(By.cssSelector("span.js_parent_party_name")).click();
        findElement(By.xpath(xpath)).click();
        findElement(By.linkText("确定")).click();
        return this;
    }

    public ContactPage changeDepartment(String originName,String newName) {
        gotoDepartment(originName);
        findElement(By.linkText("修改名称")).click();
        findElement(By.name("name")).sendKeys(newName);
        findElement(By.linkText("保存")).click();
        return this;
    }

    public ContactPage delDepartment(String name) {
        gotoDepartment(name);
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确定")).click();
        return this;
    }

    public ContactPage upDepartment(String name) {
        gotoDepartment(name);
        findElement(By.linkText("上移")).click();
        return this;
    }

    public ContactPage downDepartment(String name) {
        gotoDepartment(name);
        findElement(By.linkText("下移")).click();
        return this;
    }


    public ContactPage add(String username,String id,String phone) {
        findElement(By.name("username")).sendKeys(username);
        findElement(By.name("acctid")).sendKeys(id);
        findElement(By.name("mobile")).sendKeys(phone);
        findElement(By.linkText("保存")).click();
        return this;
    }

    public ContactPage delete(String username) {
        findElement(By.id("memberSearchInput")).clear();
        findElement(By.id("memberSearchInput")).sendKeys(username);
        try {
            waitClickable(By.linkText("编辑"),2);
        }catch (Exception e) {
            System.out.println("not found");
            return this;
        }
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
        return this;
    }

}
