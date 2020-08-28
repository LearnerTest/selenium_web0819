package com.imooc.page;

import com.imooc.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CoursePage extends BasePage {

    public CoursePage(WebDriver driver){
        super(driver);
    }

    /**
     * 获取购买按钮
     */
    public WebElement GetBuyElement(){
        return GetElement("buy_now");
    }
    /**
     * 获取添加购物车按钮
     */
    public WebElement GetAddCartElement(){
        return GetElement("add_cart");
    }

    /**
     * 获取购物车按钮
     * @return
     */
    public WebElement GetCartElement(){
        return GetElement("cart");
    }

    /**
     * 购物车数量
     * @return
     */
    public WebElement GetCartNumElement(){
        return GetElement("cart_num");
    }
    /**
     * 获取订单名称
     */
    public WebElement GetOrderNameElement(){
        return GetElement("order_name");
    }

    /**
     * 获取购买课程名称
     * @return
     */
    public WebElement GetBuyNameElement(){
        return GetElement("buy_name");
    }

    /**
     * 重复点击添加购物车获取，取消
     * @return
     */
    public WebElement GetCartSureElement(){
        return  GetElement("cart_already");
    }
}
