package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Utils;

public class stepDef {
	Scenario scenario;
	
	@Given("User navigates to {string}")
	public void user_navigates_to(String url) throws IOException {
		Utils.openUrl(url);
		Utils.maximizeBrowserWindow();
	}

	@When("User enters text {string} in {string}")
	public void user_enters_text_in(String searchText, String element) throws IOException {
		Utils.findElementByXpathAndSendKeys(searchText, element);
	   
	}

	@When("Clicks on {string}")
	public void clicks_on(String element) throws IOException {
		Utils.findElementByXpathAndClick(element);
	}

	@Then("Extract title of {string} and check if it contains {string}")
	public void extract_title_of_and_check_if_it_contains(String element, String expectedText) throws IOException {
		String extractedUrl = Utils.findElementByXpathAndExtractAttributeValue(element, "title");
		assertTrue(extractedUrl.contains(expectedText));
		scenario.log("Expected Title : " + expectedText);
		scenario.log("Extracted Title : " + extractedUrl);
	    
	}
	
	@Then("Extract number of namespace added should be {int}")
	public void extract_number_of_namespace_added(int count) throws IOException {
		assertEquals(count,Utils.findElementByXpathAndExtractNumberOfElements("NameSpace"));
		scenario.log("Expected count : " + count);
		scenario.log("Extracted count : " + Utils.findElementByXpathAndExtractNumberOfElements("NameSpace"));
	}
	
	@Then("Validate text displayed is {string} at location {string}")
	public void validate_text_displayed_is_at_location(String text, String element) throws IOException {
		scenario.log("Expected text : " + text);
		scenario.log("Extracted text : " + Utils.findElementByXpathAndExtractData(element));
		assertTrue(Utils.findElementByXpathAndExtractData(element).contains(text));
	}
	
	@Then("Take the screenshot of search result")
	public void take_the_screenshot_of_search_result() throws IOException {
		Utils.takeScreenShot(scenario);
	}
}
