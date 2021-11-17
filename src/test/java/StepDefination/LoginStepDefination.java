package StepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import junit.framework.Assert;

public class LoginStepDefination {

	WebDriver driver;
	@Given("^User is already on login page$")
	public void login_page(){
		
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Akash Sharma\\Desktop\\selenium\\Browser Driver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://my.crmnext.com/crmnext/CRMNextObject/Home/Summary");	
				
	}
	
	@When("^login page title is CRMnext$")
	public void login_title(){
		String title = driver.getTitle();	
		System.out.println(title);
		//Assert.assertEquals("CRMnext - Smart.Easy.Complete", title);
	}
	@Then("^user enter UserName and Password$")
	public void username_passward(){
		driver.findElement(By.name("UserName")).sendKeys("akash.sharma@crmnext.in");
		String pass_txt = driver.findElement(By.xpath("//input[@placeholder='Password']")).getAttribute("placeholder");
		System.out.println(pass_txt);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Apple$123");
	}
	
	@Then("^user click on login button$")
	public void login_button(){
		driver.findElement(By.name("command")).click();
		
	}
	@And("^USER is on home page$")
	public void home_page(){
		driver.findElement(By.xpath("//a[@name='ProfileImage_header' and @class='header-profile__media min-wt-2 wt-2 ht-2 overflow-hidden']//img")).click();
		String usnm = driver.findElement(By.xpath("//span[text()='Akash Sharma']")).getAttribute("Title");
		System.out.println(usnm);
		String scope = driver.findElement(By.xpath("//span[@title='All']")).getText();
		String Roles = driver.findElement(By.xpath("//span[@title='Engr Quality Assurance']")).getText();
		System.out.println("Scope of user is: " + scope + ", " + "Assigned Roles are: " + Roles);
		
		//Assert.assertEquals("Akash Sharma", usnm);
	}  
	
	/*@Then("^CustomTabLayout Objects$")
	public void object_list(){
		
		//List<WebElement> hamobject1 = driver.findElements(By.xpath("//ul[@class='side-nav-list pa-0 ma-0 system-side-links bg-brand']/li"));
		//System.out.println(hamobject1.size());
		
		List<WebElement> hamobject2 = driver.findElements(By.xpath("//ul[@id='js-vnav' and @class='side-nav-list pa-0 ma-0 pb-10']/li"));
		System.out.println(hamobject2.size());
		for(int i=0;i<hamobject2.size();i++)
		{
			List<WebElement> obj = driver.findElements(By.xpath("//ul[@id='js-vnav' and @class='side-nav-list pa-0 ma-0 pb-10']/li/div/div//a[@class='side-nav-list__name wt-9 white truncate f13 pointer']"));
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			System.out.println(obj.get(i).getAttribute("Title"));	
			
		}
	}
	*/
	@Then("^SummaryDropDown objects$")
	public void Summary_dropdown_objects(){
		driver.findElement(By.xpath("//select[@name='APP_SEARCH_ITEMTYPE']")).click();
		List<WebElement> sumddobj = driver.findElements(By.xpath("//select[@name='APP_SEARCH_ITEMTYPE']/option"));
		System.out.println(sumddobj.size());
		for(int i=0; i<sumddobj.size(); i++)
		{
			System.out.println(sumddobj.get(i).getText());
			
		}
				
				
	}
	
	
	@Then("^CustomView Table$")
	public void Custom_View_table(){
		//Print All coloumn Header field
		
		driver.findElement(By.xpath("//a[@class='white side-nav-list__link wt50 mid f16 ht50' and @href='/crmnext/CRMNextObject/Home/Case']")).click();    // Move to case object
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//div[@Class='react-grid-HeaderRow']/div/div"));
		List<WebElement> vwhdrfld = driver.findElements(By.xpath("//div[@Class='acid-header-cell-content dragTrue'  or  @Class='acid-header-cell-content']"));
		System.out.println(vwhdrfld.size());
		for(int i=0; i<vwhdrfld.size(); i++)
		{
			System.out.println(vwhdrfld.get(i).getAttribute("Title"));
			
		}
				
		// Print all CASE ID, Subject...
		
		List<WebElement> TotalCase = driver.findElements(By.xpath("//div[@class='crm-grid-row relative']"));   //Case View Row Path
		System.out.println(TotalCase.size());
		
		String staticpath = "//a[@data-autoid='CaseID_";    //Caseid Path
		String DynamicPath  =  "']";						//Caseid Path
		
		String st_subj = "//a[@data-autoid='Subject_";	   	//Subject path	
		String dy_subj = "']";		 						//Subject path
		
		for(int i=0; i<TotalCase.size(); i++)
		{
			String Xpath = staticpath+i+DynamicPath;
			String Xpath_subject = st_subj+i+dy_subj;
			WebElement TotCaseIds = driver.findElement(By.xpath(Xpath));
			WebElement TotCaseIds_subject = driver.findElement(By.xpath(Xpath_subject));
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			System.out.println("CASE_ID: " + TotCaseIds.getAttribute("Title")+ " -> "+TotCaseIds_subject.getAttribute("Title"));
			//System.out.println(TotCaseIds_subject.getAttribute("Title"));	
		}
		
		}
	
	/*@Then("^AvailableToQA Bugs List with three filter input \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	public void dev_complte_bugs(String f1,String f2,String f3){
		
		driver.findElement(By.xpath("//a[@class='white side-nav-list__link wt50 mid f16 ht50' and @href='/crmnext/CRMNextObject/Home/Case']")).click();    // Move to case object
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Select filter1 = new Select(driver.findElement(By.xpath("//select[@name='QueryCategoryId']")));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//System.out.println(filter1);
		List<WebElement> Selectfilter1 = filter1.getOptions();
		System.out.println(Selectfilter1.size());
		filter1.selectByVisibleText(f1);
		
		//driver.findElement(By.xpath("//a[@class='white side-nav-list__link wt50 mid f16 ht50' and @href='/crmnext/CRMNextObject/Home/Case']")).click();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
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
			//System.out.println(TotCaseIds_subject.getAttribute("Title"));	
		}
		
		
		
		
		
		}	*/	
	
	
	@Then("^Invalid Staus bugs list \"([^\"]*)\" and \"([^\"]*)\"$")
	public void invalid_Staus_bugs_list_and(String qabug, String invalid){
		
		driver.findElement(By.xpath("//a[@class='white side-nav-list__link wt50 mid f16 ht50' and @href='/crmnext/CRMNextObject/Home/Case']")).click();    // Move to case object
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		
		Select filter1 = new Select(driver.findElement(By.xpath("//select[@name='QueryCategoryId']")));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		List<WebElement> Selectfilter1 = filter1.getOptions();
		System.out.println(Selectfilter1.size());
		filter1.selectByVisibleText(qabug);
		
		Select filter2 = new Select(driver.findElement(By.xpath("//select[@name='QueryViewId']")));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		List<WebElement> Selectfilter2 = filter2.getOptions();
		System.out.println(Selectfilter2.size());
		filter2.selectByVisibleText(invalid);
		
		System.out.println("PLEASE FIND Invalid Status BUGS: ");
		
		List<WebElement> TotalCase = driver.findElements(By.xpath("//div[@class='crm-grid-row relative']"));   //Case View Row Path
		System.out.println(TotalCase.size());
		
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		
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
			//System.out.println(TotCaseIds_subject.getAttribute("Title"));	
		}
		
	}

}
	
	