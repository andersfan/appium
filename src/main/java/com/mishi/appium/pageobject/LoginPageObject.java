package com.mishi.appium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class LoginPageObject extends BasePageObject {

	public LoginPageObject(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		
		this.loginButton = driver.findElement(By.id("com.mishi.android.seller:id/ui_btn_login"));
		this.pwdTextBox = driver.findElement(By.id("com.mishi.android.seller:id/ui_et_login_password"));
		this.nameTextBox = driver.findElement(By.id("com.mishi.android.seller:id/edit_text"));
	}

	private WebElement loginButton;
	private WebElement pwdTextBox;
	private WebElement nameTextBox;

	public WebElement getPwdTextBox() {
		return pwdTextBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getNameTextBox() {
		return nameTextBox;
	}

	public void inputUserName(String name) {
		this.nameTextBox.sendKeys(name);
		
		while (!this.nameTextBox.getText().replace(" ", "").equals(name)) {
			this.nameTextBox.clear();
			this.nameTextBox.sendKeys(name);
		}
	}

	public void inputPwd(String pwd) {
		this.pwdTextBox.sendKeys(pwd);
	}

	public void clickToLogin() {
		this.loginButton.click();
	}
}
