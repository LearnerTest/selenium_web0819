package com.imooc;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourseList {

    static WebDriver driver;
    @BeforeClass
    public void BeforeClass() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://coding.imooc.com");
        Thread.sleep(2000);
    }

    @AfterClass
    public void AfterClass() {
        driver.close();
    }
/***
    @Test
    public void test01() throws InterruptedException {
        List<String> TileList = ShopTitleList();
        for(int i =0;i<TileList.size();i++){
            driver.findElement(By.xpath("//p[@title='"+TileList.get(i)+"']")).click();
            driver.navigate().back();
            Thread.sleep(2000);
        }
    }
    ***/

    /**
     * 循环页数和循环点击课程列表
     * @throws InterruptedException
     */
    @Test
    public void test02() throws InterruptedException {
        List<Integer> PageList = GetPageNumberList();
        for(int j =0;j<PageList.size()-1;j++) {
            List<WebElement> elementList = driver.findElements(By.className("shizan-name"));
            for (int i =0; i < elementList.size(); i++) {
                elementList.get(i).click();
                driver.navigate().back();
                Thread.sleep(2000);
                elementList = driver.findElements(By.className("shizan-name"));
            }
            driver.findElement(By.linkText("下一页")).click();
            Thread.sleep(10000);
        }
    }

    /**
     * 获取页数的数组
     * @return GetPageNumberList
     */
    public List<Integer> GetPageNumberList(){
        List<Integer> PageNumberList = new ArrayList<Integer>();
        List<WebElement> PageElements =driver.findElement(By.className("page")).findElements(By.tagName("a"));
        for(WebElement aElement:PageElements){
            if(IsNumber(aElement.getText())==true){
                PageNumberList.add(Integer.valueOf(aElement.getText()));
            }
        }
        return PageNumberList;
    }
    /**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
    public Boolean IsNumber(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    public List<String> ShopTitleList(){
        List<String> TitleList = new ArrayList<String>();
        List<WebElement> elementList = driver.findElements(By.className("shizan-name"));
        for(WebElement GoodsElement:elementList){
                TitleList.add(GoodsElement.getText());
        }
        return  TitleList;
    }
}
