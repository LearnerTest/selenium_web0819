package com.imooc.handle;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseHandle {

    static WebDriver driver;

    //构造方法
    public BaseHandle(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * 获取title
     * */
    public String GetTitle() {
        return driver.getTitle();
    }
    /**
     * 		清空输入框
     * */
    public void ClearText(WebElement element){
        element.clear();
    }
    /**
     * 点击事件
     * */
    public void ClickElement(WebElement element){
        element.click();
    }

    public Boolean IsContains(String One,String Two){
        boolean flag = true;
        flag = One.contains(Two);
        return flag;
    }

    /**
     * 植入cookie
     * */
    public void  SetUserCookie() {
        String value = "QyNWRlZjllNmJlYzViMmM4YzAyMGY3NjA1N2ViNGYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANjMwMDYwMQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA3NDEyOTcyMjlAcXEuY29tAAAAAAAAAAAAAAAAAAAAAGExMTkwNzM5ZmRlNGU2ODI0ZmNjOWEwMTFhMjM3YmU4untIX7p7SF8%3DNm";
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("apsid",value,".imooc.com","/",null);
        driver.manage().addCookie(cookie);
    }

    /**
     * 切换alter窗口
     */
    public void SwtichAlter(){
        driver.switchTo().alert();
    }

    /**
     * 切换模态框
     */
    public void SwtichToMode(){
        driver.switchTo().activeElement();
    }
}
