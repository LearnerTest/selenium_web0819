package com.imooc.handle;

import com.imooc.page.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginHandle {
    static Logger logger = Logger.getLogger(LoginHandle.class);
    static LoginPage loginPage;

    public LoginHandle(WebDriver driver) {
//        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void SendEmail(String email) {
        logger.debug("输入的用户名："+email);
        loginPage.GetEmailElement().sendKeys(email);
    }

    public void SendPassword(String password) {
        logger.debug("输入的密码："+password);
        loginPage.GetPasswordElement().sendKeys(password);
    }

    public void ClickLogin() throws InterruptedException {
        logger.debug("<<<<<<<--------------开始登录-------------->>>>>>");
        loginPage.GetLoginButtonElement().click();
        Thread.sleep(2000);
    }

    public String GetUserText() {
        loginPage.MoveToElement(loginPage.GetUsePngElement());
        String UserName = loginPage.GetUseInfoElement().getText();
        return UserName;
    }
}
