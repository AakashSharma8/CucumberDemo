package StepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Then;

public class BugsWithStatusCode {
	
	WebDriver driver;
	@Then("^AvailableToQA Bugs List with three filter input \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	public void dev_complte_bugs(String f1,String f2,String f3){
		
		driver.findElement(By.xpath("//a[@class='white side-nav-list__link wt50 mid f16 ht50' and @href='/crmnext/CRMNextObject/Home/Case']")).click();    // Move to case object
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Select filter1 = new Select(driver.findElement(By.xpath("//select[@name='QueryCategoryId']")));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		List<WebElement> Selectfilter1 = filter1.getOptions();
		System.out.println(Selectfilter1.size());
		filter1.selectByVisibleText(f1);
		
		
		Select filter2 = new Select(driver.findElement(By.xpath("//select[@name='QueryViewId']")));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//System.out.println(filter2);
		List<WebElement> Selectfilter2 = filter2.getOptions();
		System.out.println(Selectfilter2.size());
		filter2.selectByVisibleText(f2);
		System.out.println("*****************************");
		
		
		Select filter3 = new Select(driver.findElement(By.xpath("//select[@name='QueryFilterId']")));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		List<WebElement> Selectfilter3 = filter3.getOptions();
		System.out.println(Selectfilter3.size());
		filter3.selectByVisibleText(f3);
		System.out.println("<><><><><><><><><><><><><><><><>");
		
		
		List<WebElement> TotalCase = driver.findElements(By.xpath("//div[@class='crm-grid-row relative']"));   //Case View Row Path
		System.out.println(TotalCase.size());
		
		System.out.println("//////////////////////////////");
		
		String staticpath = "//a[@data-autoid='CaseID_";    //Caseid Path
		String DynamicPath  =  "']";						//Caseid Path
		
		String st_subj = "//a[@data-autoid='Subject_";	   	//Subject path	
		String dy_subj = "']";		 						//Subject path
		
		for(int i=0; i<TotalCase.size(); i++)
		{
			String Xpath = staticpath+i+DynamicPath;
			String Xpath_subject = st_subj+i+dy_subj;
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			WebElement TotCaseIds = driver.findElement(By.xpath(Xpath));
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			WebElement TotCaseIds_subject = driver.findElement(By.xpath(Xpath_subject));
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			System.out.println("CASE_ID: " + TotCaseIds.getAttribute("Title")+ " -> "+TotCaseIds_subject.getAttribute("Title"));	
		}
		
		
		
		
		
		}		





}
