package com.imooc.page;

import com.imooc.util.ProUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

    static Logger logger = Logger.getLogger(BasePage.class);
    static WebDriver driver;
    //构造方法
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public static By GetByLocal(String key){
        String Locator = ProUtil.GetValue("element",key);
        logger.debug("定位信息的key值为："+key);
        String LocatorBy = Locator.split(">")[0];
        String LocatorValue = Locator.split(">")[1];
        logger.debug("定位信息的方式为："+LocatorBy);
        logger.debug("定位值为："+LocatorValue);
        if (LocatorBy.equals("id")){
            return By.id(LocatorValue);
        }else if(LocatorBy.equals("name")){
            return  By.name(LocatorValue);
        }else if(LocatorBy.equals("className")){
            return By.className(LocatorValue);
        }else
            return By.xpath(LocatorValue);
    }

    public static WebElement GetElement(String key){
        WebElement Element = driver.findElement(GetByLocal(key));
        return Element;
    }
    /**
     * 疑点鼠标操作
     * @param ToElement
     */
    public void MoveToElement(WebElement ToElement){
//        WebElement ToElement = GetElement(key);
        Actions actions = new Actions(driver);
        actions.moveToElement(ToElement).perform();
    }
}
