package com.LoremCRM.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LoremCRM.genericLib.BaseTest;


public class HomePage {
	
	// We are storing the element's address of Home page here
	  //Declaration
	
	//@FindBy(locatorName="locatorValue") accessSpecifier ReturnType elementName;
		@FindBy(xpath="//a[text()='Campaigns']") private WebElement campTab;
	
		//Initialization
	public HomePage() {
		PageFactory.initElements(BaseTest.driver, this);
		
	}

	//Utilization
	public WebElement getCampaignTab() {
		return campTab;
	}
	
	public void clickCampaignTab() {
		campTab.click();
	}

}