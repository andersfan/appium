package com.mishi.appium.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public final class BaseDriverConfig {
	private BaseDriverConfig() {
		return;
	}

	public static BaseDriverConfig getInstance() {
		return new BaseDriverConfig();
	}

	private AndroidDriver<WebElement> androidDriver;

	private IOSDriver<WebElement> iosDriver;

	public AndroidDriver<WebElement> getAndroidDriver() throws InterruptedException {
		if (this.androidDriver == null) {
			try {
				this.initAndroidDriver();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return this.androidDriver;
	}

	public void initAndroidDriver() throws MalformedURLException, InterruptedException {
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
		this.androidDriver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		// 等待10秒,等待模拟器启动app程序进入首页,保证test project的健壮性
		Thread.sleep(10000);
	}

	public void initIosDriver() throws MalformedURLException, InterruptedException {
		// set up appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Mac");
		capabilities.setCapability("deviceName", "iPhone 5");
		capabilities.setCapability("platformVersion", "8.4");

		// if no need install don't add this
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "app");
		File app = new File(appDir, "MishiOS.ipa");
		System.out.println("---->" + app.getAbsolutePath());
		capabilities.setCapability("app", app.getAbsolutePath());

		capabilities.setCapability("noSign", "True");
		
		// support Chinese
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");

		this.iosDriver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		// 等待10秒,等待模拟器启动app程序进入首页,保证test project的健壮性
		Thread.sleep(10000);
	}

	public IOSDriver<WebElement> getIosDriver() {
		if (this.iosDriver == null) {
			try {
				this.initIosDriver();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return this.iosDriver;
	}

}
