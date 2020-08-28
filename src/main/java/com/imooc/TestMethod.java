package com.imooc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestMethod {


    public Boolean IsContains(String One, String Two) {
        boolean flag = true;
        flag = One.contains(Two);
        System.out.println(flag);
        return flag;
    }

    public static  void main(String[] args){
        TestMethod t = new TestMethod();
        t.IsContains("测试123","测2212试");
    }

}
