package com.imooc.runcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseCase {

    public static WebDriver driver;
    public WebDriver GetDriver(String broser) {
        if (broser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.firefox.bin","F:\\procedure\\firefox\\firefox.exe");
            System.setProperty("webdriver.gecko.driver", "E:\\selenium_web\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

}
