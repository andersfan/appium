package com.mishi.appium.sample;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest {
	private AndroidDriver<WebElement> driver = null;

	@BeforeTest
	public void setUp() throws Exception {
		// 设置apk的路径
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot,"app");
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
        
        //support Chinese 
        capabilities.setCapability("unicodeKeyboard" ,"True");
        capabilities.setCapability("resetKeyboard", "True");

		// 设置app的主包名和主类名
        //Package名称
		capabilities.setCapability("appPackage", "com.mishi.android.seller"); 
		//main函数所在类目录 可以是相对目录，例如com.mishi.android.seller.MainActivity 可以
		capabilities.setCapability("appActivity", "com.mishi.ui.SplashActivity"); 

		// 初始化
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void addContact() throws InterruptedException {
		Thread.sleep(1000000);
		
		WebElement el = driver.findElement(By.name("登录"));
		el.click();
		List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
		textFieldsList.get(0).sendKeys("18616521543");
		textFieldsList.get(1).sendKeys("qqqqqq");
		driver.swipe(100, 500, 100, 100, 2);
		driver.findElementByName("登录").click();
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
