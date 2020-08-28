package com.imooc.handle;

import com.imooc.page.CoursePage;
import com.imooc.page.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CourseHandle extends BaseHandle {

    static Logger logger = Logger.getLogger(CourseHandle.class);
    static CoursePage coursePage;
    static WebDriver driver;

    public CourseHandle(WebDriver driver){
        super(driver);
        this.driver = driver;
        coursePage = new CoursePage(driver);
    }

    /**
     * 点击添加购物车
     */
    public void ClickAddCart(){
        coursePage.GetAddCartElement().click();
    }

    /**
     * 点击立即购买
     */
    public void ClickBuyNow(){
        coursePage.GetBuyElement().click();
    }

    /**
     * 点击购物车按钮
     * */
    public void ClickCart(){
        coursePage.GetCartElement().click();
    }

    /**
     * 获取购物车数量
     * */
    public Integer GetNum(){
        int CartNum;
        try{
            CartNum = Integer.parseInt(coursePage.GetCartNumElement().getText());
        }catch (Exception e){
            CartNum = 0;
        }
        return CartNum;
    }
    /**
     * 获取课程名称
     * */
    public String GetOrderName(){
        return coursePage.GetOrderNameElement().getText();
    }

    /**
     * 获取购买的课程名称
     */
    public String GetBuyName(){
        return coursePage.GetBuyNameElement().getText();
    }

    /**
     * 重复添加课程取消
     */
    public void ClickCartSure(){
        coursePage.GetCartSureElement().click();
    }
}
