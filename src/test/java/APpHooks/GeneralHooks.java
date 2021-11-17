package APpHooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GeneralHooks {

	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;

	@Before(order = 0)
	public void getproperty() {
		configreader = new ConfigReader();
		prop = configreader.intit_prop();

		System.out.println("Login done successfully" + prop);

	}

	@Before(order = 1)
	public void LauchBrowser() {
		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browserName);

	}

	@After(order = 0)
	public void quitbrowser() {
		System.out.println("Tear down application ");
		driver.quit();

	}

	@After(order = 1)
	public void breakScenariotakescreenshot(Scenario scenario) {
		if(scenario.isFailed()){
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file,new File("C:/Users/Akash Sharma/Desktop/selenium/eclipse-jee-mars-2-win32-x86_64/eclipse/FreeCRMBDDFramework/target/" + scenario + ".jpg" ));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
