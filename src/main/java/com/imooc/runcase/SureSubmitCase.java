package com.imooc.runcase;

import com.imooc.handle.SureSubmitHandle;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SureSubmitCase extends BaseCase {

    static SureSubmitHandle sureSubmitHandle;
    public static WebDriver driver;
    static org.apache.log4j.Logger logger = Logger.getLogger(SureSubmitCase.class);

    @Parameters({"test_url","browser"})
    @BeforeClass
    public void BeforeClass(String test_url,String browser) throws InterruptedException {
        logger.debug("初始化浏览器");
        driver = GetDriver(browser);
        logger.debug("启动浏览器");
        driver.get(test_url);
        Thread.sleep(2000);
        sureSubmitHandle = new SureSubmitHandle(driver);
//        sureSubmitHandle.SetUserCookie();
//        driver.get(test_url1);
        Thread.sleep(3000);
    }

    @AfterClass
    public void AfterClass() {
        driver.close();
    }

    @Parameters({"submit_title","test_url"})
    @Test
    public void LoginSubmit(String submit_title,String test_url) throws InterruptedException {
        String order_title;
//        sureSubmitHandle.SetUserCookie();
        driver.get(test_url);
//        driver.navigate().refresh();
        Thread.sleep(5000);
        order_title = sureSubmitHandle.GetTitle();
        System.out.println(order_title);
        System.out.println(submit_title);
        boolean flag = sureSubmitHandle.IsContains(order_title,submit_title);
        Assert.assertEquals(flag,true);
        sureSubmitHandle.ClickSubmit();

    }
    @Parameters({"test_url"})
    @Test
    public void SureSubmit(String test_url){
        String submit_title;
        driver.get(test_url);
        submit_title = sureSubmitHandle.GetTitle();
        boolean flag = submit_title.contains("登陆");
        Assert.assertEquals(flag, true);
    }

}
