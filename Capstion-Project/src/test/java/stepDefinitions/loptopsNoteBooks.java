package stepDefinitions;

import java.io.IOException;

import core.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LaptopsNoteBooksPageObj;
import utilities.Utilities;

public class loptopsNoteBooks extends Base {
	LaptopsNoteBooksPageObj labNote = new LaptopsNoteBooksPageObj();

	@Given("User is on Retail website this")
	public void user_is_on_retail_website_this() {
		labNote.textTestEnvoironment();
		logger.info("User can see Retail website this");

	}

	@When("User click on Laptop & NoteBook tab")
	public void user_click_on_laptop_note_book_tab() {
		labNote.clickOnLoptopsAndNB();
		logger.info("User clicked on Laptop & NoteBook tab");
	}

	@When("User click on Show all Laptop &NoteBook option")
	public void user_click_on_show_all_laptop_note_book_option() {
		labNote.clickOnshowAllLaptopsAndNB();
		logger.info("User clicked on Show all Laptop &NoteBook option");
	}

	@When("User click on MacBook  item")
	public void user_click_on_mac_book_item() {
		labNote.clickOnItemMacBook();
		logger.info("User clicked on MacBook  item");
	}

	@When("User click add to Cart button this")
	public void user_click_add_to_cart_button_this() {
		labNote.clickOnaddToCartbuttonMacBook();
		logger.info("User clicked add to Cart button this");
	}

	@Then("User should see a message {string}")
	public void user_should_see_a_message(String string) throws IOException {
		System.out.println("string from stepDefinition method: " + string);
		Utilities.takeScreenShot("Success MacBook added to cart");
		logger.info("User can see a message ‘Success: You have added MacBook to your shopping cart!’");

	}

	@Then("User should see {string} showed to the cart")
	public void user_should_see_showed_to_the_cart(String string) throws Exception {
		labNote.getTextcartTotalMacBook(string);
		logger.info("User should see '1 item(s) - $602.00' showed to the cart");
	}

	@Then("User click on cart option")
	public void user_click_on_cart_option() throws InterruptedException {
		labNote.ClickOnCartTotal();
		logger.info("User clicked on cart option");
	}

	@Then("user click on red X button to remove the item from cart")
	public void user_click_on_red_x_button_to_remove_the_item_from_cart() {
		labNote.ClickOnCartRemoveButton();
		logger.info("user clicked on red X button to remove the item from cart");
	}

	@Then("item should be removed and cart should show {string}")
	public void item_should_be_removed_and_cart_should_show(String string) throws Exception {
		Utilities.takeScreenShot("cartEmpty");
		logger.info("item removed");
		labNote.TextEmptyShoppingCart(string);
	}

//----------
	@When("User click on product comparison icon on ‘MacBook’")
	public void user_click_on_product_comparison_icon_on_mac_book() {
		labNote.clickOncompareProductButtonMacBook();
		logger.info("User clicked on product comparison icon on ‘MacBook’");
	}

	@When("User click on product comparison icon on ‘MacBook Air")
	public void user_click_on_product_comparison_icon_on_mac_book_air() {
		labNote.clickOncompareProductButtonMacBooAir();
		logger.info("User clicked on product comparison icon on ‘MacBook Air");
	}

	@Then("User should see a message3 {string}")
	public void user_should_see_a_message3(String string) throws IOException, InterruptedException {
		labNote.successMessageMacBookAirButtonMacBooAir(string);
		Utilities.takeScreenShot("MacBookAir");
		logger.info("User can see a message ‘Success: You have added MacBook Air to your product comparison!’");

	}

	@Then("User click on Product comparison link")
	public void user_click_on_product_comparison_link() throws InterruptedException {
		labNote.clickOnproductComparisonLinkMacBookAir();
		logger.info("User clicked on Product comparison link");
	}

	@Then("User should see Product Comparison Chart")
	public void user_should_see_product_comparison_chart() throws IOException {
		labNote.allListOfItemsProductComparison();
		Utilities.takeScreenShot("All products");
		logger.info("User can see Product Comparison Chart");

	}

//-------------------	
	@When("User click on heart icon to add ‘Sony VaIO’ laptop to wish list")
	public void user_click_on_heart_icon_to_add_sony_va_io_laptop_to_wish_list() {
		labNote.clickOnHeartSonyVAIO();
		logger.info("User clicked on heart icon to add ‘Sony VaIO’ laptop to wish list");
	}

	@Then("User should get a message4 {string}")
	public void user_should_get_a_message4(String string) throws Exception {
		labNote.textSuccessTextSonyVAIO(string);
		Utilities.takeScreenShot("SonyVAIO");
		logger.info(
				"User can get a message ‘You must login or create an account to save Sony VAIO to your wish list!’");

	}

//---------------------------
	@When("User click on ‘MacBook Pro’ item")
	public void user_click_on_mac_book_pro_item() {
		labNote.clickOnMacBookPro();
		logger.info("User clicked on ‘MacBook Pro’ item");
	}

	@Then("User should see 'dolarSign two thousands' price tag is present on UI")
	public void user_should_see_$_price_tag_is_present_on_ui() throws Exception {
		labNote.textPriceMacBookPro();
		try {

			Utilities.takeScreenShot("$2000 price");
		} catch (Exception e) {

			e.printStackTrace();
		}

		logger.info("User should see 'dolarSign two thousands' price tag is present on UI");

	}

}
