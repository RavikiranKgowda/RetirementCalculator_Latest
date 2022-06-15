package retirementCalculator;

import org.testng.annotations.Test;

import excelUtils.Excel;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class calculator extends Excel{
	WebDriver driver;
	Excel ex = new Excel();
	Pagerepo webElement ;
	
	//Initializing WebDriver and launching the Retirement calculator application
	@BeforeTest
	public void setUp() {
	
		System.setProperty("webdriver.chrome.driver", "C:/Users/RAVI KIRAN/Desktop/Selenium Workspace/Demo/Drivers/chromedriver.exe");
		//Initializing the WebDriver
		driver = new ChromeDriver();
		//Launching the URL
		driver.get("https://www.securian.com/insights-tools/retirement-calculator.html");
		//Maximizing the window
		driver.manage().window().maximize();
		webElement = new Pagerepo(driver);
		//Adding implicit wait for 3 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
	}
	
	
	//This method is written to check the retirement calculator by filling only mandatory fields
	@Test
	public void testToCheckOnlyOnRequiredFields() throws Exception {		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);

		webElement.txt_Age.sendKeys(ex.getCellData("Age"));
		webElement.txt_RetirementAge.sendKeys(ex.getCellData("SpouseAge"));
		
		//Using Java Script Executer to send some values inside textBox when normal sendKeys doesn't work 
	
		js.executeScript("arguments[0].value='"+ex.getCellData("CurrentIncome")+"'",webElement.currentIncome);
		js.executeScript("arguments[0].value='"+ex.getCellData("SpouseIncome")+"'",webElement.spouseIncome);
		js.executeScript("arguments[0].value='"+ex.getCellData("SavingsBalance")+"'",webElement.savingsBalance);

		webElement.txt_percentageAnnualSavings.sendKeys(ex.getCellData("percentageAnnualSavings"));
		webElement.txt_PercentageIncreaseRate.sendKeys(ex.getCellData("PercentageIncreaseRate"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		//used actions class to operate on radio button
		action.moveToElement(webElement.radio_yes).click().build().perform();

		//Thread  should not be used more often unless on some testing purpose
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(webElement.radio_maritalStatus).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		webElement.btn_calculate.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String actual  = webElement.txt_result.getAttribute("innerText");
		String Expecetd = "Results";

		//Asserting the actual and expected values and printing the successful message
		Assert.assertEquals(actual,Expecetd);
		System.out.println("Successfully submitted the form by filling all mandatory fields only");

	}
	
	
	//This method is written to check the retirement calculator by filling all mandatory fields along with Non-Mandatory fields
	@Test
	public void testToCheckByFillingAllFields() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);		
		webElement.txt_Age.sendKeys(ex.getCellData("Age"));
		webElement.txt_RetirementAge.sendKeys(ex.getCellData("SpouseAge"));
		
		//Using Java Script Executer to send some values inside textBox when normal sendKeys doesn't work 
	
		js.executeScript("arguments[0].value='"+ex.getCellData("CurrentIncome")+"'",webElement.currentIncome);
		js.executeScript("arguments[0].value='"+ex.getCellData("SpouseIncome")+"'",webElement.spouseIncome);
		js.executeScript("arguments[0].value='"+ex.getCellData("SavingsBalance")+"'",webElement.savingsBalance);

		webElement.txt_percentageAnnualSavings.sendKeys(ex.getCellData("percentageAnnualSavings"));
		webElement.txt_PercentageIncreaseRate.sendKeys(ex.getCellData("PercentageIncreaseRate"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		//used actions class to operate on radio button
		action.moveToElement(webElement.radio_yes).click().build().perform();

		//Thread  should not be used more often unless on some testing purpose 
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(webElement.radio_maritalStatus).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		js.executeScript("arguments[0].value='"+ex.getCellData("SpouseIncome")+"'",webElement.txt_spouseIncome);
		webElement.btn_retirementForm.click();
		Thread.sleep(3000);

		js.executeScript("arguments[0].value='"+ex.getCellData("AdditionalIncome")+"'",webElement.txt_additionalIncome);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		webElement.txt_retirementDuration.sendKeys(ex.getCellData("RetirementDuration"));
		action.moveToElement(webElement.radio_inflation).click().build().perform();
		Thread.sleep(3000);
		webElement.inflationRate.sendKeys(ex.getCellData("InflationRate"));
		Thread.sleep(3000);
		webElement.annIncome.sendKeys(ex.getCellData("AnnualIncome"));
		Thread.sleep(3000);
		webElement.preretirement.sendKeys(ex.getCellData("preRetirement"));
		Thread.sleep(3000);
		webElement.postretirement.sendKeys(ex.getCellData("PostRetirement"));
		Thread.sleep(3000);
		webElement.btn_savechanges.click();
		Thread.sleep(3000);
		webElement.btn_calculate.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String actual  = webElement.txt_result.getAttribute("innerText");
		String Expecetd = "Results";

		//Asserting the actual and expected values and printing the successful message
		Assert.assertEquals(actual,Expecetd);
		
		//Asserting the actual and expected values and printing the successful message
		Assert.assertEquals(actual,Expecetd);
		System.out.println("Successfully submitted the form by filling all mandatory and Non-Mandatory fileds fields");
		
		
		
		
	}
	
	
	//Closing the WebDriver
	@AfterTest
	public void tearDown() {
		
		driver.close();
		driver.quit();
		
	}
	

}

