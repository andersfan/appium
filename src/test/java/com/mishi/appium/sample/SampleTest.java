package com.mishi.appium.sample;

import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mishi.appium.base.BaseDriverConfig;
import com.mishi.appium.pageobject.LoginPageObject;
import com.mishi.appium.pageobject.StartPageObject;

import io.appium.java_client.android.AndroidDriver;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SampleTest extends AbstractTestNGSpringContextTests {

	private AndroidDriver<WebElement> driver = null;

	@Autowired
	private StartPageObject pageObject;
	@Autowired
	private LoginPageObject loginPageObject;

	@BeforeTest(alwaysRun = true)
	public void setUp() throws Exception {
		this.driver = BaseDriverConfig.getInstance().getDriver();
	}

	@Test(groups = "login")
	public void login() throws InterruptedException {
		// 点击启动页的登录按钮
		this.pageObject.setDriver(this.driver);
		this.pageObject.clickToLogin();

		// 登录页，用户文本框输入18616521543，密码文本框输入qqqqqq，点击登录按钮
		this.loginPageObject.setDriver(this.driver);
		this.loginPageObject.inputUserName("18616521543");
		this.loginPageObject.inputPwd("qqqqqq");
		this.loginPageObject.clickToLogin();
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {
		this.driver.quit();
	}

	public StartPageObject getPageObject() {
		return this.pageObject;
	}

	public void setPageObject(StartPageObject pageObject) {
		this.pageObject = pageObject;
	}

	public LoginPageObject getLoginPageObject() {
		return loginPageObject;
	}

	public void setLoginPageObject(LoginPageObject loginPageObject) {
		this.loginPageObject = loginPageObject;
	}
}
