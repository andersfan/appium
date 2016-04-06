package com.mishi.appium.sample;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mishi.appium.base.BaseDriverConfig;
import com.mishi.appium.pageobject.LoginPageObject;
import com.mishi.appium.pageobject.StartPageObject;

import io.appium.java_client.android.AndroidDriver;

public class SampleTest {
	private AndroidDriver<WebElement> driver = null;

	@BeforeTest
	public void setUp() throws Exception {
		this.driver = BaseDriverConfig.getInstance().getDriver();
	}

	@Test
	public void login() throws InterruptedException {
		//点击启动页的登录按钮
		StartPageObject pageObject = new StartPageObject(this.driver);
		pageObject.clickToLogin();
		
		//登录页，用户文本框输入18616521543，密码文本框输入qqqqqq，点击登录按钮
		LoginPageObject loginPageObject = new LoginPageObject(this.driver);
		loginPageObject.inputUserName("18616521543");
		loginPageObject.inputPwd("qqqqqq");
		loginPageObject.clickToLogin();
		
		Thread.sleep(2000000);
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
