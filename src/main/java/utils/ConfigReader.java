package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties readProp() {

		String filename = System.getProperty("user.dir") + "//src//test//resources//config.properties";
		FileInputStream fis;
		Properties prop = null;
		try {
			fis = new FileInputStream(filename);
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {

		}
		return prop;

	}

}
