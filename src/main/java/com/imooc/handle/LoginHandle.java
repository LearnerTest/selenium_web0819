package com.imooc.handle;

import com.imooc.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginHandle {

    static LoginPage loginPage;

    public LoginHandle(WebDriver driver) {
//        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void SendEmail(String email) {
        loginPage.GetEmailElement().sendKeys(email);
    }

    public void SendPassword(String password) {
        loginPage.GetPasswordElement().sendKeys(password);
    }

    public void ClickLogin() throws InterruptedException {
        loginPage.GetLoginButtonElement().click();
        Thread.sleep(2000);
    }

    public String GetUserText() {
        loginPage.MoveToElement(loginPage.GetUsePngElement());
        String UserName = loginPage.GetUseInfoElement().getText();
        return UserName;
    }
}
