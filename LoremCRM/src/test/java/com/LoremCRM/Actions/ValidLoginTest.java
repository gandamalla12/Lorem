package com.LoremCRM.Actions;

import org.testng.annotations.Listeners;
import com.LoremCRM.genericLib.BaseTest;
import com.LoremCRM.genericLib.FileLib;
import com.LoremCRM.genericLib.WebDriverCommonLib;
import com.LoremCRM.pages.LoginPage;

@Listeners(com.LoremCRM.genericLib.MyListeners.class)
public class ValidLoginTest extends BaseTest{


	public void loginToApp() throws Throwable {
		LoginPage lp=new LoginPage();
	    FileLib fl=new FileLib();
		lp.login(fl.readPropData(PROP_PATH, "username"), fl.readPropData(PROP_PATH, "password"));
	    WebDriverCommonLib wlib = new WebDriverCommonLib();
	    wlib.verify(wlib.getPageTitle(), fl.readPropData(PROP_PATH,"homeTitle"), "Home page");
	
	}
}