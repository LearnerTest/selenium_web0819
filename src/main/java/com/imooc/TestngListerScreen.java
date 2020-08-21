package com.imooc;

import com.google.common.io.Files;
import com.imooc.runcase.LoginCase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestngListerScreen extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr){
        System.out.println("失败的case");
        LoginCase tc = (LoginCase) tr.getInstance();
        WebDriver driver = tc.driver;
        ScreenShot(driver);
        super.onTestFailure(tr);
    }

    public void ScreenShot(WebDriver driver) {
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String CurentTime = sdf.format(new Date());
        //获取当前类名，图片名称为类名+时间
        String CurClassName = this.getClass().getName();
        String PngName = CurClassName + "_" + CurentTime + ".png";
        File ScrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        try {
            //将图片保存到指定目录下
            Files.copy(ScrFile, new File("E:\\selenium_web\\src\\main\\ScreenShoot\\" + PngName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
