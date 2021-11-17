package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;

public class Userdetails {
	
	WebDriver driver;
	
	@And("^user is on home page$")
	public void home_page(){
		driver.findElement(By.xpath("//a[@name='ProfileImage_header' and @class='header-profile__media min-wt-2 wt-2 ht-2 overflow-hidden']//img")).click();
		String usnm = driver.findElement(By.xpath("//span[text()='Akash Sharma']")).getAttribute("Title");
		System.out.println(usnm);
		String scope = driver.findElement(By.xpath("//span[@title='All']")).getText();
		String Roles = driver.findElement(By.xpath("//span[@title='Engr Quality Assurance']")).getText();
		System.out.println("Scope of user is: " + scope + ", " + "Assigned Roles are: " + Roles);
		
	}
	
	

}
