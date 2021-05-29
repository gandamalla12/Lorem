package com.LoremCRM.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.LoremCRM.genericLib.BaseTest;

public class DisplayCustomViewPage {
	
	@FindBy(xpath="//input[@value=\"New Campaign\"]") private WebElement newCampaignBtn;
	@FindBy(xpath="//table[@class=\"secContent\"]//tbody//tr[*]//td[@class=\"tableData\"][3]") private List<WebElement> campaignList;
	
	//Initialization
	public DisplayCustomViewPage() {
		PageFactory.initElements(BaseTest.driver, this);
		
		}

	//Actions or Utilization
	public WebElement getNewCampaignBtn() {
		return newCampaignBtn;
	}

	public void setNewCampaignBtn(WebElement newCampaignBtn) {
		this.newCampaignBtn = newCampaignBtn;
	}
	
	public void clickNewCampaignBtn() 
	{
		newCampaignBtn.click();
	}
	
	public void verifyCampaignCreation(String campaign)  {
		for(WebElement oneCampaign:campaignList) {
			 String campaignName = oneCampaign.getText();
			 if(campaignName.equals(campaign))
			 {
				 Reporter.log("Our Campign is created", true);
			 }
			 else
			 {
				 Reporter.log("Our Campaign is not Created", true);
			 }
		}
	}

}
