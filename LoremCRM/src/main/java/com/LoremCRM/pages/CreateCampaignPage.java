package com.LoremCRM.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LoremCRM.genericLib.BaseTest;



public class CreateCampaignPage {

	@FindBy(xpath = "//input[@name='property(Campaign Name)']")
	private WebElement campaignNameBtn;
	@FindBy(xpath = "//div[@class=\"bodyText mandatory\"]/following-sibling::table[2]//input[@value=\"Save\"]")
	private WebElement saveBtn;

	public CreateCampaignPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}

	public WebElement getCampaignNameBtn() {
		return campaignNameBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void enterCapaignName(String campaignName) {
		campaignNameBtn.sendKeys(campaignName);
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
}
