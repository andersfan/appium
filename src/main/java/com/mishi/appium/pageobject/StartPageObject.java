package com.mishi.appium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class StartPageObject extends BasePageObject {
	public StartPageObject(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		this.registerButton = driver.findElement(By.id("com.mishi.android.seller:id/ui_btn_viewpage_reg"));
		this.loginButton = driver.findElement(By.id("com.mishi.android.seller:id/ui_btn_viewpage_login"));
	}
	
	private WebElement registerButton;
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	public void clickToLogin(){
		this.loginButton.click();
	}
}
