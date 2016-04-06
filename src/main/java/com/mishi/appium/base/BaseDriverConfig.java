package com.mishi.appium.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public final class BaseDriverConfig {
	private BaseDriverConfig(){
		return;
	}
	
	public static BaseDriverConfig getInstance(){
		return new BaseDriverConfig();
	}
	
	private AndroidDriver<WebElement> driver;

	public AndroidDriver<WebElement> getDriver() {
		if (this.driver == null) {
			try {
				this.initDriver();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return this.driver;
	}

	public void initDriver() throws MalformedURLException {
		// 设置apk的路径
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "app");
		File app = new File(appDir, "app-adhocConfig-debug.apk");

		// 设置自动化相关参数
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");

		// 设置安卓系统版本
		capabilities.setCapability("platformVersion", "6.0");
		// 设置apk路径
		capabilities.setCapability("app", app.getAbsolutePath());

		capabilities.setCapability("noSign", "True");

		// support Chinese
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");

		// 设置app的主包名和主类名
		// Package名称
		capabilities.setCapability("appPackage", "com.mishi.android.seller");
		// main函数所在类目录 可以是相对目录，例如com.mishi.android.seller.MainActivity 可以
		capabilities.setCapability("appActivity", "com.mishi.ui.SplashActivity");

		// 初始化
		this.driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
}
