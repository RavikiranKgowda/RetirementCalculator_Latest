package retirementCalculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Pagerepo {

	WebDriver driver;

	@FindBy(xpath="//*[@id=\"current-age\"]")
	public WebElement txt_Age;
	@FindBy(xpath="//*[@id=\"retirement-age\"]")
	public WebElement txt_RetirementAge;
	@FindBy(xpath="//*[@id=\"current-income\"]")
	public WebElement currentIncome;
	@FindBy(xpath="//*[@id=\"spouse-income\"]")
	public WebElement spouseIncome;
	@FindBy(xpath="//*[@id=\"current-total-savings\"]")
	public WebElement savingsBalance;
	@FindBy(xpath="//*[@id=\"current-annual-savings\"]")
	public WebElement txt_percentageAnnualSavings;
	@FindBy(xpath="//*[@id=\"savings-increase-rate\"]")
	public WebElement txt_PercentageIncreaseRate;
	@FindBy(xpath="//*[@id=\"include-social-container\"]/ul/li[1]/label")
	public WebElement radio_yes;
	@FindBy(xpath="//*[@id=\"marital-status-ul\"]/li[2]/label")
	public WebElement radio_maritalStatus;
	@FindBy(xpath="//button[contains(text(),'Calculate')]")
	public WebElement btn_calculate;
	@FindBy(xpath="//*[@id=\"calculator-results-container\"]/h3")
	public WebElement txt_result;
	
	@FindBy(xpath="//*[@id=\"spouse-income\"]")
	public WebElement txt_spouseIncome;
	@FindBy(xpath="//*[@id=\"retirement-form\"]/div[4]/div[1]/div/div/div/ul/li[2]/a")
	public WebElement btn_retirementForm;
	@FindBy(xpath="//*[@id=\"additional-income\"]")
	public WebElement txt_additionalIncome;
	@FindBy(xpath="//*[@id=\"retirement-duration\"]")
	public WebElement txt_retirementDuration;
	@FindBy(xpath="//*[@id=\"include-inflation-container\"]/ul/li[1]/label")
	public WebElement radio_inflation;
	
	@FindBy(xpath="//*[@id=\"expected-inflation-rate\"]")
	public WebElement inflationRate;
	@FindBy(xpath="//*[@id=\"retirement-annual-income\"]")
	public WebElement annIncome;
	@FindBy(xpath="//*[@id=\"pre-retirement-roi\"]")
	public WebElement preretirement;
	@FindBy(xpath="//*[@id=\"post-retirement-roi\"]")
	public WebElement postretirement;
	@FindBy(xpath="//*[@id=\"default-values-form\"]/div[2]/div/div[1]/button")
	public WebElement btn_savechanges;
	
	


	public Pagerepo(WebDriver driver) {
		this.driver=driver;

		PageFactory.initElements(driver,this);
	}

}

//  @Test
//  public void pageobejects() {
//	  
//	  
//  }
//}
