package com.imooc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestngListerScreen.class})
public class TestngCase {

    public  WebDriver driver;

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
    public void test01(){
        this.driver.findElement(By.name("email12")).sendKeys("17789898890");
    }

    @Test
    public void test02(){
        driver.findElement(By.name("email1")).sendKeys("17789898890");
    }
}
