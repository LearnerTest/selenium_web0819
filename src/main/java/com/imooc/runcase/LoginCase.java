package com.imooc.runcase;

import com.imooc.TestngListerScreen;
import com.imooc.handle.LoginHandle;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({TestngListerScreen.class})
public class LoginCase extends BaseCase{

    static LoginHandle loginHandle;
    public static WebDriver driver;
    static org.apache.log4j.Logger logger = Logger.getLogger(LoginCase.class);

    @Parameters({"test_url","browser"})
    @BeforeClass
    public void BeforeClass(String test_url,String browser) throws InterruptedException {
        logger.debug("初始化浏览器");
        driver = GetDriver(browser);
        logger.debug("启动浏览器");
        driver.get(test_url);
        Thread.sleep(2000);
        loginHandle = new LoginHandle(driver);
        loginHandle.ClickSigninButton();
        Thread.sleep(3000);
    }

    @AfterClass
    public void AfterClass() {
        driver.close();
    }

    @Parameters({"username","password"})
    @Test
    public void LoginSuccess(String username,String password) throws InterruptedException {
        logger.debug("《--------------开始执行第一个case----------》");
        loginHandle.SendEmail(username);
        loginHandle.SendPassword(password);
        loginHandle.ClickLogin();
        String UserName = loginHandle.GetUserText();
        Assert.assertEquals(UserName,"慕瓜1108229");
    }

    @Parameters({"username","password"})
    @Test(description = "失败case")
    public void LoginFailed(String username,String password) throws InterruptedException {
        logger.debug("《--------------开始执行第二个case----------》");
        loginHandle.SendEmail(username);
        loginHandle.SendPassword(password);
        loginHandle.ClickLogin();
        String UserName = loginHandle.GetUserText();
        Assert.assertEquals(UserName,"慕瓜1108229");
    }
}
