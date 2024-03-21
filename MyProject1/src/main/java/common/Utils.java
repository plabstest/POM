package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	public static String getPropertyValue(String path,String key) {
		Properties prop = new Properties();
		try {
			prop.load( new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = prop.getProperty(key);
		return value;	
}

}
