package com.mishi.appium.sample;

import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mishi.appium.android.pageobject.LoginPageObject;
import com.mishi.appium.android.pageobject.StartPageObject;
import com.mishi.appium.base.BaseDriverConfig;

import io.appium.java_client.ios.IOSDriver;


@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class IosSampleTest extends AbstractTestNGSpringContextTests  {
	private IOSDriver<WebElement> driver = null;
	
	@Autowired
	private StartPageObject pageObject;
	@Autowired
	private LoginPageObject loginPageObject;
	
	@BeforeTest(alwaysRun = true)
	public void setUp() throws Exception {
		this.driver = BaseDriverConfig.getInstance().getIosDriver();
	}
	
	@Test(groups = "login")
	public void login() throws InterruptedException {
		return;
	}

}
