package com.imooc.util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.testng.IExecutionListener;

public class TestNGListennerSendEmail implements IExecutionListener{

	
	 public void onExecutionStart() {
		 System.out.println("所有case开始执行");
	 }

	  /**
	   * Invoked once all the suites have been run.
	   */
	 public void onExecutionFinish() {
			System.out.println("this is test----------------->");
			HtmlEmail email = new HtmlEmail();
		    email.setHostName("smtp.163.com");
		    email.setAuthentication("lijing19900721@163.com", "ljfe19900701");
			try {
				email.setFrom("lijing19900721@163.com");
				email.addTo("741297229@qq.com");
				email.setSubject("selenium subject");
				email.setCharset("UTF-8");
				email.setHtmlMsg("<a href=\"\"> 测试报告");
				EmailAttachment emailattachment = new EmailAttachment();
				emailattachment.setPath("E:\\selenium_web\\test-output\\report.html");
				emailattachment.setName("report.html");
				emailattachment.setDescription(EmailAttachment.ATTACHMENT);
				email.attach(emailattachment);
				email.send();
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }

	 public static void main(String[] args){
	 	TestNGListennerSendEmail s = new TestNGListennerSendEmail();
	 	s.onExecutionFinish();
	 }
}
