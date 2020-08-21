package com.imooc.runcase;

import com.imooc.TestngListerScreen;
import com.imooc.handle.LoginHandle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestngListerScreen.class})
public class LoginCase {

    static LoginHandle loginHandle;
    public static WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");
        loginHandle = new LoginHandle(driver);
    }

    @AfterClass
    public void AfterClass() {
        driver.close();
    }

    @Test
    public void LoginSuccess() throws InterruptedException {
        loginHandle.SendEmail("18806525771");
        loginHandle.SendPassword("ljfe199007021");
        loginHandle.ClickLogin();
        String UserName = loginHandle.GetUserText();
        Assert.assertEquals(UserName,"慕瓜1108229");
    }

    @Test
    public void LoginFailed() throws InterruptedException {
        loginHandle.SendEmail("188065257711");
        loginHandle.SendPassword("ljfe19900701");
        loginHandle.ClickLogin();
        String UserName = loginHandle.GetUserText();
        Assert.assertEquals(UserName,"慕瓜1108229");
    }
}