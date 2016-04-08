package com.mishi.appium.android.pageobject;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public abstract class BasePageObject {
	public abstract void setDriver(AndroidDriver<WebElement> driver);
}
