package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import org.junit.Assert;
import utilities.Utilities;

public class LaptopsNoteBooksPageObj extends Base {

	public LaptopsNoteBooksPageObj() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='TEST ENVIRONMENT']")
	private WebElement textTESTENVIRONMENT;
	@FindBy(xpath = "//a[text()='Laptops & Notebooks']")
	private WebElement loptopsAndNB;
	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	private WebElement showAllLaptopsAndNB;
	@FindBy(linkText = "MacBook")
	private WebElement itemMacBook;
	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement addToCartbuttonMacBook;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAddedToCartMacBook;
	@FindBy(xpath = "//span[@id='cart-total']")
	private WebElement cartTotalMacBook;
	@FindBy(xpath = "//span[@id='cart-total']")
	private WebElement cartTotal;
	@FindBy(xpath = "//i[@class='fa fa-times']")
	private WebElement cartRemoveButton;
	@FindBy(xpath = "//span[@id='cart-total']")
	private WebElement textEmptyShoppingCart;
	@FindBy(xpath = "//button[contains(@onclick,'43')][3]")
	private WebElement compareProductButtonMacBook;
	@FindBy(xpath = "//button[contains(@onclick,'44')][3]")
	private WebElement compareProductButtonMacBookAir;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessageMacBookAir;
	@FindBy(linkText = "product comparison")
	private WebElement productComparisonLinkMacBookAir;
	@FindBy(xpath = "//h1[text()='Product Comparison']")
	private WebElement productComparisonText;
	@FindBy(xpath = "//div[@id='content']//a/strong")
	private List<WebElement> listOfItemsProductComparison;
	@FindBy(xpath = "//button[contains(@onclick,'46')][2]")
	private WebElement heartSonyVAIO;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement textSuccessTexttSonyVAIO;
	@FindBy(linkText = "MacBook Pro")
	private WebElement macBookPro;
	@FindBy(xpath = "//ul[@class='list-unstyled']//h2")
	private WebElement priceMacBookPro;

	@FindBy(xpath = "//a[text()='Macs (0)']")
	private WebElement loptopsAndNBMacs;
	@FindBy(xpath = "//h2[text()='Macs']")
	private WebElement textMAcsLoptopsAndNB;
	@FindBy(xpath = "//p[text()='There are no products to list in this category.']")
	private WebElement textThereAreNoProductLoptopsAndNBMacs;
	@FindBy(xpath = "//a[text()='Windows (0)']")
	private WebElement windowsLoptopsAndNBMacs;
	@FindBy(xpath = "//h2[text()='Windows']")
	private WebElement textWindowsLoptopsAndNBMacs;
	@FindBy(xpath = "//img[@class='img-responsive']")
	private WebElement imgLoptopsAndNB;

	public void textTestEnvoironment() {
		WebElement text = textTESTENVIRONMENT;
		System.out.println(text.getText());
	}

	public void clickOnLoptopsAndNB() {
		Utilities.waitAndClickElement(loptopsAndNB);
	}

	public void clickOnshowAllLaptopsAndNB() {
		Utilities.waitAndClickElement(showAllLaptopsAndNB);
	}

	public void clickOnItemMacBook() {
		Utilities.waitAndClickElement(itemMacBook);
	}

	public void clickOnaddToCartbuttonMacBook() {
		Utilities.waitAndClickElement(addToCartbuttonMacBook);
	}

	public void textSuccessAddedToCartMacBook(String strSuccessMessage) {
		String actualSuccessMsg = successAddedToCartMacBook.getText();
		String strString = actualSuccessMsg.substring(0, 54);
		Assert.assertEquals(strSuccessMessage, strString);

	}

	public void getTextcartTotalMacBook(String strCartTotal) throws InterruptedException {
		String actualCartTotal = cartTotalMacBook.getText();
		Thread.sleep(3000);
		Assert.assertEquals(strCartTotal, actualCartTotal);
	}

	public void ClickOnCartTotal() throws InterruptedException {
		Utilities.waitAndClickElement(cartTotal);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickOnCartRemoveButton() {
		Utilities.waitAndClickElement(cartRemoveButton);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void TextEmptyShoppingCart(String strCartTotalAfterRemove) throws Exception {
		String actualCartTotal = textEmptyShoppingCart.getText();
		System.out.println("actual cart total after removing: ======= " + actualCartTotal);
		Assert.assertEquals(strCartTotalAfterRemove, actualCartTotal);
		System.out.println(actualCartTotal);
	}

	public void clickOncompareProductButtonMacBook() {
		compareProductButtonMacBook.click();
	}

	public void clickOncompareProductButtonMacBooAir() {
		compareProductButtonMacBookAir.click();
	}

	public void successMessageMacBookAirButtonMacBooAir(String strSuccessMsg) throws InterruptedException {
		Thread.sleep(2000);
		String actual = successMessageMacBookAir.getText();
		String strString = actual.substring(0, 55);
		try {
			Assert.assertEquals(strSuccessMsg, strString);
		} catch (Exception e) {

		}
	}

	public void clickOnproductComparisonLinkMacBookAir() throws InterruptedException {
		Thread.sleep(2000);
		productComparisonLinkMacBookAir.click();
	}

	public void getTextproductComparisonText() {
		productComparisonText.getText();
	}

	public void allListOfItemsProductComparison() {
		List<WebElement> list = listOfItemsProductComparison;
		System.out.println(list.size() + " size of element prsent in UI:");
		for (int i = 0; i < list.size(); i++) {
			Assert.assertTrue(list.size() != 0);
		}

	}

	public void clickOnHeartSonyVAIO() {
		heartSonyVAIO.click();
	}

	public void textSuccessTextSonyVAIO(String succsessMsg) throws Exception {
		String actual = textSuccessTexttSonyVAIO.getText();
		String expected = "You must login or create an account to save Sony VAIO to your wish list!";
		if (actual.contains(expected)) {
			logger.info("Text verified!");
		} else {
			throw new Exception("Txt does not match");
		}
	}

	public void clickOnMacBookPro() {
		macBookPro.click();

	}

	public void textPriceMacBookPro() throws Exception {
		String price = priceMacBookPro.getText();
		System.out.println(price);
		if (price.equalsIgnoreCase("$2,000.00")) {
			logger.info("Price verified!");

		} else {
			throw new Exception("Price does not match!");
		}

	}

}
