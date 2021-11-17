package MyTestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:/Users/Akash Sharma/Desktop/selenium/eclipse-jee-mars-2-win32-x86_64/eclipse/FreeCRMBDDFramework/src/main/java/Features"
		,glue = {"StepDefination"}
		)	


public class RunnerBugStatus {

}
