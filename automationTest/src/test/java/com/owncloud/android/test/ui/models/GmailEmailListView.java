package com.owncloud.android.test.ui.models;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

public class GmailEmailListView {
	
	final AndroidDriver driver;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"me about UploadFile,  on May 11, conversation read\")")
	private AndroidElement emailAmericanFormatDate;
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"me about UploadFile,  on 11 May, conversation read\")")
	private AndroidElement emailEuropeanFormatDate;
	
		
	public GmailEmailListView (AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public GmailEmailView clickOnEmail (){
		try{
			emailAmericanFormatDate.click();
		}catch (NoSuchElementException e) {
			emailEuropeanFormatDate.click();
		}
		GmailEmailView gmailEmailView = new GmailEmailView(driver);
		return gmailEmailView;
	}
	
}
