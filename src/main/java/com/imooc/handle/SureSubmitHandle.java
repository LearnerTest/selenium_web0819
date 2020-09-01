package com.imooc.handle;

import com.imooc.page.SureSubmitPage;
import org.openqa.selenium.WebDriver;

public class SureSubmitHandle extends BaseHandle {

    public SureSubmitPage sureSubmitPage;

    public SureSubmitHandle(WebDriver driver) {
        super(driver);
        sureSubmitPage = new SureSubmitPage(driver);
    }

    /**
     * 点击确认订单按钮
     * */
    public void ClickSubmit(){
        ClickElement(sureSubmitPage.GetSureSubmitElement());
    }
}
