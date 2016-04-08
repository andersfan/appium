package com.mishi.appium.android.pageobject;

import org.openqa.selenium.WebElement;

import com.mishi.appium.controlobject.WebElementObject;

import io.appium.java_client.android.AndroidDriver;

public class StartPageObject extends BasePageObject {
	
	private WebElementObject registerButton;
	private WebElementObject loginButton;

	public void clickToLogin(){
		this.loginButton.getWebelement().click();
	}

	public WebElementObject getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(WebElementObject registerButton) {
		this.registerButton = registerButton;
	}

	public WebElementObject getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElementObject loginButton) {
		this.loginButton = loginButton;
	}

	@Override
	public void setDriver(AndroidDriver<WebElement> driver) {
		this.loginButton.setDriver(driver);
		this.registerButton.setDriver(driver);
	}
}
