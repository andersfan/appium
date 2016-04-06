package com.mishi.appium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class LoginPageObject extends BasePageObject {

	public LoginPageObject(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		
		this.titleView = driver.findElement(By.id("com.mishi.android.seller:id/actionbar_tv_title"));
		this.nameView = driver.findElement(By.id("com.mishi.android.seller:id/title"));
		this.pwdView = driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]");
		this.forgetPwdView =  driver.findElement(By.id("com.mishi.android.seller:id/ui_tv_login_form_forget_password"));
		
		this.pwdTextBox = driver.findElement(By.id("com.mishi.android.seller:id/ui_et_login_password"));
		this.nameTextBox = driver.findElement(By.id("com.mishi.android.seller:id/edit_text"));
		
		this.loginButton = driver.findElement(By.id("com.mishi.android.seller:id/ui_btn_login"));
		this.registerButton = driver.findElement(By.id("com.mishi.android.seller:id/ui_btn_login_form_register"));
		this.backButton = driver.findElement(By.id("com.mishi.android.seller:id/actionbar_btn_back"));
	}
	
	private WebElement titleView;
	private WebElement nameView; 
	private WebElement pwdView; 
	private WebElement forgetPwdView; 
	
	private WebElement pwdTextBox;
	private WebElement nameTextBox;
	
	private WebElement loginButton;
	private WebElement registerButton; 
	private WebElement backButton;

	public WebElement getNameView() {
		return nameView;
	}

	public WebElement getPwdView() {
		return pwdView;
	}

	public WebElement getForgetPwdView() {
		return forgetPwdView;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
	
	public WebElement getPwdTextBox() {
		return pwdTextBox;
	}

	public WebElement getNameTextBox() {
		return nameTextBox;
	}
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getBackButton() {
		return backButton;
	}
	
	public WebElement getTitleView() {
		return titleView;
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
