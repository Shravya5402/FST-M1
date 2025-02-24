package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity1 {
	@Given("User is on Google Home Page")
	public void user_is_on_google_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("test1");

	}

	@When("User types in Cheese and hits ENTER")
	public void user_types_in_cheese_and_hits_enter() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("test1");
	   
	}

	@Then("Show how many search results were shown")
	public void show_how_many_search_results_were_shown() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("test1");
	    
	}

	@Then("Close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("test1");
	
	}
}
