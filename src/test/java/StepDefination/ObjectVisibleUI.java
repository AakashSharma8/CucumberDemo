package StepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;

public class ObjectVisibleUI {

	WebDriver driver;

@Then("^CustomTabLayout Objects$")
public void object_list(){
	
	List<WebElement> hamobject2 = driver.findElements(By.xpath("//ul[@id='js-vnav' and @class='side-nav-list pa-0 ma-0 pb-10']/li"));
	System.out.println(hamobject2.size());
	for(int i=0;i<hamobject2.size();i++)
	{
		List<WebElement> obj = driver.findElements(By.xpath("//ul[@id='js-vnav' and @class='side-nav-list pa-0 ma-0 pb-10']/li/div/div//a[@class='side-nav-list__name wt-9 white truncate f13 pointer']"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		System.out.println(obj.get(i).getAttribute("Title"));	
		
	}
						}
}