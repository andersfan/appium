package com.mishi.appium.controlobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class WebElementObject {
	private WebElement webelement;
	private AppiumDriver<WebElement> driver;

	private String resourceId;
	private String xpath;
	private String name;

	public WebElement getWebelement() {
		return webelement;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDriver(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		this.initWebElement();
	}

	public void initWebElement() {
		if (this.resourceId != null) {
			this.webelement = this.driver.findElement(By.id(this.resourceId));
		} else if (this.xpath != null) {
			this.webelement = this.driver.findElement(By.xpath(this.xpath));
		} else if (this.name != null) {
			this.webelement = this.driver.findElement(By.name(this.name));
		}
	}
}
