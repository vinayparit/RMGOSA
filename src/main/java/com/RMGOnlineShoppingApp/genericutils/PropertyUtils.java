package com.RMGOnlineShoppingApp.genericutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.FilePath);
		Properties pObj = new Properties();
		pObj.load(fis);

		String value = pObj.getProperty(key);
		return value;
	}
}
