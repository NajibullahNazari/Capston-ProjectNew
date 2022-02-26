package utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.Base;

public class Utilities extends Base{
	
	public static void compareText(String actualText, String expectedText) {

		if (actualText.equalsIgnoreCase(expectedText)) {
			System.out.println(actualText + " = " + expectedText + "Passed");
		} else {
			System.out.println(actualText + " != " + expectedText + "Failed");
		}
	}

	// The reason we use JSExecutor
	// 1 - The web browser is implementing JavaScrip language and by using
	// JSExecutor
	// it is eary for JSExecutor to interact with element in the web browser
	// 2 - When we multi browser testing, we will be writing our locators (xpaths,
	// cssSelector, etc...)
	// but we will be collecting locator and use one browser (chrome), but when we
	// execute our test
	// in firefox, we may not be able to click or sendkeys or do some other actions,
	// that is when we need
	// JSExecutor

	// method for taking screenshots
	public static void takeScreenShot(String fileName) throws IOException {
		// we need to create a folder at project level and store the path here so that
		// when even we take screenshots, they are all saved in that specific folder
		String path = "output/screenShots2";
		// I create object of the file class
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// After taking the screenshot, take the file and store it in a location in my
		// computer
		// and also I want to provide the file_name and the extension
		FileUtils.copyFile(file, new File(path + fileName + ".png"));
	}

	// JSExecutor methods start
	// .click()
	// if the .click() does not work, then we get the help JSExecuter
	public static void clickWithJSE(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void waitAndClickElement(WebElement element) {
		boolean clicked = false;
		int attempts = 0;
		while(!clicked && attempts < 10) {
			try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			System.out.println("Successfully clicked on the WebElement: " + "=" + element.toString());
			clicked = true;
			} catch (Exception e) {
				try {
					logger.info("Failed to click the element");
				} catch (Exception e2) {
				}
				Assert.fail("Unable to click the element: " + "=" +  element.toString());
			}	
		attempts++;
		}	
	}


	// How we can give border to an element on webpage
	public static void highlightelementRedBorder(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", element);
	}

	// How we can highlight an element background
	public static void highlightelementBackground(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.background='yellow'", element);
	}
	public static void highlightelementRedBorderAndTakeScreenshot(WebElement element, String fileName) throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", element);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utilities.takeScreenShot(fileName);
	}

	// What if we want to do both/above with same method?
	// give border and highlith
	public static void highlightelementBorderAndBackground(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}

	// How we can scroll down the page with JSExecutor
	public static void scrolldownPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// how to sendkeys with JSExecutor
	public static void sendKeys(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + value + "'", element);
	}

	public static void highlightelementRedBorder11(boolean shoppingCartIsEmty) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", shoppingCartIsEmty);
		
	}


}
