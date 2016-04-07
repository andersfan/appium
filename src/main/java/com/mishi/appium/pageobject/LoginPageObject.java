package com.mishi.appium.pageobject;

import org.openqa.selenium.WebElement;

import com.mishi.appium.controlobject.WebElementObject;

import io.appium.java_client.android.AndroidDriver;

public class LoginPageObject extends BasePageObject {

	private WebElementObject titleView;
	private WebElementObject nameView;
	private WebElementObject pwdView;
	private WebElementObject forgetPwdView;

	private WebElementObject pwdTextBox;
	private WebElementObject nameTextBox;

	private WebElementObject loginButton;
	private WebElementObject registerButton;
	private WebElementObject backButton;

	public void inputUserName(String name) {
		this.nameTextBox.getWebelement().sendKeys(name);

		while (!this.nameTextBox.getWebelement().getText().replace(" ", "").equals(name)) {
			this.nameTextBox.getWebelement().clear();
			this.nameTextBox.getWebelement().sendKeys(name);
		}
	}

	public void inputPwd(String pwd) {
		this.pwdTextBox.getWebelement().sendKeys(pwd);
	}

	public void clickToLogin() {
		this.loginButton.getWebelement().click();
	}

	@Override
	public void setDriver(AndroidDriver<WebElement> driver) {
		this.titleView.setDriver(driver);
		this.nameView.setDriver(driver);
		this.pwdView.setDriver(driver);
		this.forgetPwdView.setDriver(driver);
		this.pwdTextBox.setDriver(driver);
		this.nameTextBox.setDriver(driver);
		this.loginButton.setDriver(driver);
		this.registerButton.setDriver(driver);
		this.backButton.setDriver(driver);
	}

	public WebElementObject getTitleView() {
		return titleView;
	}

	public void setTitleView(WebElementObject titleView) {
		this.titleView = titleView;
	}

	public WebElementObject getNameView() {
		return nameView;
	}

	public void setNameView(WebElementObject nameView) {
		this.nameView = nameView;
	}

	public WebElementObject getPwdView() {
		return pwdView;
	}

	public void setPwdView(WebElementObject pwdView) {
		this.pwdView = pwdView;
	}

	public WebElementObject getForgetPwdView() {
		return forgetPwdView;
	}

	public void setForgetPwdView(WebElementObject forgetPwdView) {
		this.forgetPwdView = forgetPwdView;
	}

	public WebElementObject getPwdTextBox() {
		return pwdTextBox;
	}

	public void setPwdTextBox(WebElementObject pwdTextBox) {
		this.pwdTextBox = pwdTextBox;
	}

	public WebElementObject getNameTextBox() {
		return nameTextBox;
	}

	public void setNameTextBox(WebElementObject nameTextBox) {
		this.nameTextBox = nameTextBox;
	}

	public WebElementObject getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElementObject loginButton) {
		this.loginButton = loginButton;
	}

	public WebElementObject getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(WebElementObject registerButton) {
		this.registerButton = registerButton;
	}

	public WebElementObject getBackButton() {
		return backButton;
	}

	public void setBackButton(WebElementObject backButton) {
		this.backButton = backButton;
	}

}
