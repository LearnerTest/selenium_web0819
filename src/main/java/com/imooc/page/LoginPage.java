package com.imooc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取用户的element
     * @return
     */
    public WebElement GetEmailElement(){
        return GetElement("username");
    }

    /**
     * 获取密码的element
     * @return
     */
    public WebElement GetPasswordElement() {
        return GetElement("password");
    }

//    /**
//     * 获取
//     * @return
//     */
//    public WebElement GetSenvenElement() {
//        return GetElement("senven");
//    }
    /**
     * 获取登录的element
     * @return
     */
    public WebElement GetLoginButtonElement() {
        return GetElement("loginbutton");
    }
    /**
     * 获取用户图片的element
     * @return
     */
    public WebElement GetUsePngElement() {
        return GetElement("headpng");
    }
    /**
     * 获取用户名的element
     * @return
     */
    public WebElement GetUseInfoElement() {
        return GetElement("userinfo");
    }
    /**
     * 获取注册按钮的element
     * @return
     */
    public WebElement GetSigninButtonElement() {
        return GetElement("signin_button");
    }

}
