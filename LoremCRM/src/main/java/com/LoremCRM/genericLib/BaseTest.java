package com.LoremCRM.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest implements IAutoConsts{
	public static WebDriver driver;
	@BeforeClass
	public void openBrowser() throws Throwable {
		FileLib flib=new FileLib();
		String browser=flib.readPropData(PROP_PATH,"browser");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		String appUrl=flib.readPropData(PROP_PATH,"url");
		Thread.sleep(1000);
		driver.get(appUrl);
		
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		wlib.verify(wlib.getPageTitle(),flib.readPropData(PROP_PATH,"loginTitle"),"LoginPage");
	}
	@AfterClass(enabled=false)
	public void closeBrowser() {
		driver.quit();
	}


}

