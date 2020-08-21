package com.imooc;



import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
//import jdk.nashorn.internal.runtime.logging.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestngListerScreen.class})
class TestngCase {

    static Logger logger = Logger.getLogger(TestngCase.class);
    static WebDriver driver;

    @BeforeClass
    public void BeforeClass() {

        driver = new ChromeDriver();
        driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");
    }

    @AfterClass
    public void AfterClass() {
        driver.close();
        SendEmail();
    }

    @Test
    public void test01(){

        this.driver.findElement(By.name("email")).sendKeys("17789898890");

    }

    @Test
    public void test02(){
        logger.debug("信息测试");
        logger.error("错误的密码");
        logger.info("测试");
        driver.findElement(By.name("password1")).sendKeys("17789898890");
    }

    public void SendEmail(){

        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.163.com");
        email.setAuthentication("lijing19900721@163.com", "ljfe19900701");
        try {
            email.setFrom("lijing19900721@163.com");
            email.addTo("741297229@qq.com");
            email.setSubject("selenium subject");
            email.setMsg("测试邮件");
            email.send();
            logger.debug("发送成功");
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
