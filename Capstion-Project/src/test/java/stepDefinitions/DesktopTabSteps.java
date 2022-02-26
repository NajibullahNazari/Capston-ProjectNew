package stepDefinitions;

import java.io.IOException;
import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DesktopPageObj;
import utilities.Utilities;

public class DesktopTabSteps extends Base {
	DesktopPageObj desktop = new DesktopPageObj();

	@Given("User is on Retail website")
	public void user_is_on_retail_website() throws IOException {
		desktop.textTestEnvoironment();
		Utilities.takeScreenShot("HomePage");
		logger.info("Home validated successfully");

	}

	@When("User click on Desktops tab")
	public void user_click_on_desktops_tab() {
		desktop.clickOnDesktops();
		logger.info("Clicked on desktop successfuly!");
	}

	@And("User click on Show all desktops")
	public void user_click_on_show_all_desktops() {
		desktop.clickOnShowAllDesktop();
		logger.info("clicked on Show All Desktop successfuly!");

	}

	@Then("User should see all items are present in Desktop page")
	public void user_should_see_all_items_are_present_in_desktop_page() throws IOException, InterruptedException {
		desktop.getListOfAllListOfItemsOnDesktop();
		logger.info("User can see size of items successfuly!");

	}

//2-HPLP3065--------------------------------------------------------------------
	@And("User click  ADD TO CART option on ‘HP LP3065’ item")
	public void user_click_add_to_cart_option_on_hp_lp3065_item() {
		desktop.clickOnAddToCartHPLP();
		logger.info("Enterd to HPLP by cliking add to cart button successfully!");

	}

	@And("User select quantity {int}")
	public void user_select_quantity(Integer int1) {
		desktop.clearHPLPQty();
		desktop.sendKeyHPLPQty();
		logger.info("User selected quantity successfuly!");
	}

	@And("User click add to Cart button")
	public void user_click_add_to_cart_button() {
		desktop.clickOnAddToCArtButtonHPLP();
		logger.info("Clicked on add to cart Button2 successfuly!");
	}

	@Then("User should see a message1 {string}")
	public void user_should_see_a_message1(String string) throws IOException, InterruptedException {
		Thread.sleep(2000);
		Utilities.takeScreenShot("HPLP3065");
		desktop.textMessageSuccessAddedToCartHPLP(string);
		logger.info("Success message showing and taken screenshot successfully!");
	}

//3-Cannon---------------------------------------------------------------------	
	@When("User click  ADD TO CART option on ‘Canon EOS 5D’ item")
	public void user_click_add_to_cart_option_on_canon_eos_5d_item() {
		desktop.clickOnAddToCartCanonEOS5D();
		logger.info("User clicked  ADD TO CART option on ‘Canon EOS 5D’ item successfuly! ");
	}

	@When("User select color from dropdown ‘Red’")
	public void user_select_color_from_dropdown_red() throws InterruptedException {
		Thread.sleep(3000);
		desktop.clickOncanonEOSSelect();
		Thread.sleep(3000);
		logger.info("User select color from dropdown Red successfuly! ");
	}

	@When("User select quantity {int} here")
	public void user_select_quantity_here(Integer int1) {
		desktop.canonSelectQtyClear();
		desktop.canonSelectQty();
		logger.info("User selected quantity successfuly!");
	}

	@When("User click add to Cart buttonn")
	public void user_click_add_to_cart_buttonn() {
		desktop.ClickOnCanonAddToCartQty();
		logger.info("User click added to Cart buttonn successfuly!");
	}

	@Then("User should see a message2 {string}")
	public void user_should_see_a_message(String string) throws IOException, InterruptedException {
		desktop.SuccessTextCanonAddToCart(string);
	//	Thread.sleep(3000);
		Utilities.takeScreenShot("Cannon EOS 5D");
		logger.info("User can see a message ‘Success: You have added Canon EOS 5D to your shopping cart! successfuly!");
		
	}

//4---------------------------------------------------------

	@When("User click on Canon EOS 5D item")
	public void user_click_on_canon_eos_5d_item() throws InterruptedException {
		desktop.clickOnCanonEOSPrintName();
		logger.info("User clicked on Canon EOS 5D item successfuly!");
	}

	@When("User click on write a review link")
	public void user_click_on_write_a_review_link() {
		desktop.clickOnwriteReviewCanonEOS();
		logger.info("User clicked on write a review link successfuly!");
	}

	@When("user fill the review information with below information")
	public void user_fill_the_review_information_with_below_information(io.cucumber.datatable.DataTable dataTable) {
		desktop.sendKeyInputNameReviewCanonEOS();
		desktop.sendKeyTextAreaReviewCanonEOS();
		desktop.clickOnradioButtonCanonEOS5();
		logger.info("User filled the review information with below information successfuly!");
	}

	@When("User click on Continue Button")
	public void user_click_on_continue_button() {
		desktop.clickOnContinueButtonCanonEOS();
		logger.info("User clicked on Continue Button successfuly!");

	}

	@Then("User should see a message with {string}")
	public void user_should_see_a_message_with(String string) throws InterruptedException, IOException {
		Thread.sleep(3000);
		Utilities.takeScreenShot("Thank you for review!");
		logger.info(
				"User can see a message with ‘Thank you for your review. It has been submitted to the webmaster for approval. Succesfuly!");
		desktop.textThankYouMessageCanonEOS(string);
	}
}