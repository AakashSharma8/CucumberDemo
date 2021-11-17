package StepDefination;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UseRegestrationSteps {

	@Given("^user is on registration page$")
	public void user_is_on_Regestration_page() {

		System.out.println("Registration page");

	}

	@When("^User enter following details$")
	public void User_enter_following_details(DataTable datatable) {

		List<List<String>> userList = datatable.asLists(String.class);

		for (List<String> data : userList) {

			System.out.println(data);

		}

	}

	@When("^User enter following details with columns$")
	public void user_enter_following_details_with_columns(DataTable datatable) throws Throwable {

		List<Map<String, String>> UserList = datatable.asMaps(String.class, String.class);
		
		System.out.println(UserList);
		System.out.println(UserList.get(0).get("Email"));

		for (Map<String, String> e : UserList) {

			System.out.println(e.get("First Name"));
			System.out.println(e.get("Country"));
			System.out.println(e.get("Email"));
			System.out.println(e.get("Mobile No."));
		}

	}

	@Then("^USer regestraion should be successful$")
	public void USer_regestraion_should_be_successful() {

		System.out.println("user reg. should be successfull");

	}

}
