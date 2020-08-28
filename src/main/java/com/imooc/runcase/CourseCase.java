package com.imooc.runcase;

import com.imooc.handle.CourseHandle;
import com.imooc.handle.LoginHandle;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CourseCase extends BaseCase {

    static CourseHandle courseHandle;
    public static WebDriver driver;
    static org.apache.log4j.Logger logger = Logger.getLogger(CourseCase.class);

    @Parameters({"test_url","browser"})
    @BeforeClass
    public void BeforeClass(String test_url,String browser) throws InterruptedException {
        logger.debug("初始化浏览器");
        driver = GetDriver(browser);
        logger.debug("启动浏览器");
        driver.get(test_url);
        Thread.sleep(2000);
        courseHandle = new CourseHandle(driver);
//        courseHandle.ClickSigninButton();
        Thread.sleep(3000);
    }

    @AfterClass
    public void AfterClass() {
        driver.close();
    }
    
    @Parameters({"coursename"})
    @Test
    public void AddCartSuccess(String coursename) throws InterruptedException {
        System.out.println("---------->case开始执行的第一个coursecase");
        logger.info("开始执行第一个case--------------------》");
        courseHandle.SetUserCookie();
        Thread.sleep(2000);
        driver.navigate().refresh();
        String course_title = courseHandle.GetTitle();
        boolean flag = courseHandle.IsContains(course_title,coursename);
        Assert.assertEquals(flag,true);
        int a =0;
        int beforeCartNum = courseHandle.GetNum();
        courseHandle.ClickAddCart();
        Thread.sleep(3000);
        int afterCartNum = courseHandle.GetNum();
        a = afterCartNum - beforeCartNum;
        Assert.assertEquals(a,1);
    }

    @Test
    public void TestAleradyBuy() throws InterruptedException {
        courseHandle.ClickAddCart();
        Thread.sleep(3000);
        courseHandle.ClickCartSure();
    }

    @Test
    public void TestAlreadyLogin() throws InterruptedException {
        courseHandle.SetUserCookie();
        Thread.sleep(2000);
        driver.navigate().refresh();
        courseHandle.ClickBuyNow();
        Thread.sleep(2000);
    }
}
