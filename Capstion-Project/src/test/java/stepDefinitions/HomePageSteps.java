package stepDefinitions;

import org.junit.Assert;
import core.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObj;
import utilities.Utilities;

public class HomePageSteps extends Base {
	HomePageObj home = new HomePageObj();

	@When("User click on Currency")
	public void user_click_on_currency() {
		home.clickOnCurrency();
		logger.info("User clicked on currency successfuly! ");
	}

	@When("User Chose Euro from dropdown")
	public void user_chose_euro_from_dropdown() {
		home.selectCurrencyFromDropdown();
		logger.info("Currency was selected successfully");
	}

	@Then("currency value should change to Euro")
	public void currency_value_should_change_to_euro() throws Exception {
		home.getTextchangeCurrency();
		logger.info("Currency value changed successfuly!");
		Utilities.takeScreenShot("currency");
	}

	@When("User click on shopping cart")
	public void user_click_on_shopping_cart() throws InterruptedException {
		home.clickShoppingCart();
		logger.info("User clicked on shopping cart successfuly!");
	}

	@Then("“Your shopping cart is empty!” message should display")
	public void your_shopping_cart_is_empty_message_should_display() throws Exception {
		Assert.assertTrue(home.shoppingCartIsEmty());
		logger.info("Cart is emty!");
		Utilities.takeScreenShot("Emty cart");

	}

}
