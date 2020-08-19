package com.imooc;

import com.google.common.io.Files;
import com.imooc.util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OneTestClass {

    static WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");
    }

    @AfterClass
    public void AfterClass() {
        driver.close();
    }

    @Test
    public void UserLogin() throws InterruptedException {
        //读取user.properties的信息
        for (int i = 0; i < 2; i++) {
            String user = ProUtil.GetValue("user", ("user" + i));
            //获取对应的用户名、密码
            String username = user.split(">")[0];
            String password = user.split(">")[1];
            //获取用户、密码、登录的element
            WebElement EmailElement = GetElement("username");
            WebElement PassWordElement = GetElement("password");
            WebElement LoginButtonElement = GetElement("loginbutton");
            EmailElement.sendKeys(username);
            PassWordElement.sendKeys(password);
            LoginButtonElement.click();
            ScreenShot();
            Thread.sleep(5000);
            try {
                //移动到用户头像的element后获取用户名进行比对
                WebElement UserPng = GetElement("headpng");
                Actions actions = new Actions(driver);
                actions.moveToElement(UserPng).perform();
                Thread.sleep(3000);
                String UserInfoName = GetElement("userinfo").getText();
                if (UserInfoName.equals("慕瓜1108229")) {
                    System.out.println("登录成功");
                } else
                    System.out.println("登录失败，用户名不符：" + UserInfoName);

            } catch (Exception e) {
                System.out.println("登录失败:" + e);
            }
            EmailElement.clear();
            PassWordElement.clear();
        }
    }

    public By GetByLocal(String key) {
        String Locator = ProUtil.GetValue("element", key);
        String LocatorBy = Locator.split(">")[0];
        String LocatorValue = Locator.split(">")[1];
        if (LocatorBy.equals("id")) {
            return By.id(LocatorValue);
        } else if (LocatorBy.equals("name")) {
            return By.name(LocatorValue);
        } else if (LocatorBy.equals("className")) {
            return By.className(LocatorValue);
        } else
            return By.xpath(LocatorValue);
    }

    public WebElement GetElement(String key) {
        WebElement Element = driver.findElement(GetByLocal(key));
        return Element;
    }

    public void ScreenShot() {

        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String CurentTime = sdf.format(new Date());
        //获取当前类名，图片名称为类名+时间
        String CurClassName = this.getClass().getName();
        String PngName = CurClassName + "_" + CurentTime + ".png";
        File ScrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        try {
            //将图片保存到指定目录下
            Files.copy(ScrFile, new File("E:\\selenium-web\\src\\main\\ScreenShoot\\" + PngName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
