package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	static WebDriver webDriver;
	
	public static WebDriver getDriver() {
		return webDriver;
	}
	
	public static void setDriver(WebDriver driver) {
		webDriver = driver;
	}
}
