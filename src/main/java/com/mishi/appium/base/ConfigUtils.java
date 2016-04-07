package com.mishi.appium.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

	private Properties prop = new Properties();
	
	private ConfigUtils(String path) {
		InputStream inputStream = ConfigUtils.class
				.getResourceAsStream(path);
		try {
			if (inputStream != null) {
				prop.load(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ConfigUtils getInstance(String path) {
		return new ConfigUtils(path);
	}

	public String getValue(String key) {
		return prop.getProperty(key);
	}

	public int getInt(String key) {
		String val = getValue(key);
		try {
			if (val != null && !"".equals(val)) {
				return Integer.parseInt(val);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
