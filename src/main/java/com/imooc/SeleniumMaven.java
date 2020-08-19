package com.imooc;

import com.imooc.util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class SeleniumMaven {

    static WebDriver driver;
    public void InitDriver(){
        driver= new ChromeDriver();
        driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");
    }

    public void UserLogin() throws InterruptedException {
        //读取user.properties的信息
        for (int i = 0; i < 2; i++) {
            InitDriver();
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
            driver.close();
        }
    }

    public By GetByLocal(String key){
        String Locator = ProUtil.GetValue("element",key);
        String LocatorBy = Locator.split(">")[0];
        String LocatorValue = Locator.split(">")[1];
        if (LocatorBy.equals("id")){
            return By.id(LocatorValue);
        }else if(LocatorBy.equals("name")){
            return  By.name(LocatorValue);
        }else if(LocatorBy.equals("className")){
            return By.className(LocatorValue);
        }else
            return By.xpath(LocatorValue);
    }

    public WebElement GetElement(String key){
        WebElement Element = driver.findElement(GetByLocal(key));
        return Element;
    }

    public static void main(String[] args) throws InterruptedException {
        SeleniumMaven one = new SeleniumMaven();
//        one.InitDriver();
        one.UserLogin();
    }
}


