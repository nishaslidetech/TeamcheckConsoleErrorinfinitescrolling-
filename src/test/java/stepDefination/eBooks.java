package stepDefination;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import setupClass.BaseClass;

public class eBooks extends BaseClass {
	WebElement dropDown;
	WebElement selecteBook;

	@Given("^user is the on home page$")
	public void user_is_the_on_home_page() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
	}

	@Then("^click on eBooks text and check console error$")
	public void click_on_eBooks_text_and_check_console_error() throws Throwable {
		WebElement eBooks = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("eBooks")));
		eBooks.click();
		Thread.sleep(3000);
		checkConsoleError();

		// go to the eBooks details page and check the console error

		WebElement selecteBook = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//ul[1]/li[1]/div[1]/i[1]/a[1]/img[1]")));
		selecteBook.click();
		Thread.sleep(3000);
		checkConsoleError();
		driver.navigate().back();
	}

	@Then("^select option from sort By and check the console error$")
	public void select_option_from_sort_By_and_check_the_console_error() throws Throwable {

		try {
			Thread.sleep(3000);
			dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk0-combobox")));
			dropDown.click();
			Thread.sleep(3000);
			checkConsoleError();

			WebElement newAndPopular = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='dk0-1']")));
			newAndPopular.click();
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error
			selecteBook = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div//ul[1]/li[1]/div[1]/i[1]/a[1]/img[1]")));
			selecteBook.click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

			Thread.sleep(3000);
			dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk0-combobox")));
			dropDown.click();
			Thread.sleep(3000);

			WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='dk0-2']")));
			name.click();
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error
			selecteBook = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div//ul[1]/li[1]/div[1]/i[1]/a[1]/img[1]")));
			selecteBook.click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

			WebElement buyNow = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[5]/ul[1]/li[1]/div[1]/form[1]/div[1]/input[1]")));
			buyNow.click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

		} catch (FileNotFoundException e) {
		}

	}

	@Given("^Go to the home page$")
	public void go_to_the_home_page() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");

	}

	@Then("^Enter paid valid credentials$")
	public void enter_paid_valid_credentials() throws Throwable {
		try {
			Thread.sleep(3000);
			WebElement sign_in = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign In']")));
			sign_in.click();
		} catch (NoSuchElementException e) {

		}
		try {

			Thread.sleep(3000);
			WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
			email.sendKeys("nisha.dhiman@slidetech.in");

			WebElement password_field = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")));
			password_field.sendKeys("123456");
			WebElement login_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Login']")));
			login_btn.click();
			Thread.sleep(2000);
			
			if (!driver.findElements(By.xpath("//div[@class='login-attempt-popup']")).isEmpty()) {
				WebElement approve = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirm-approve']")));
				approve.click();
			}
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on eBooks on the top navigation bar$")
	public void click_on_eBooks_on_the_top_navigation_bar() throws Throwable {
		Thread.sleep(3000);
		WebElement eBooks = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("eBooks")));
		eBooks.click();
		Thread.sleep(3000);
		checkConsoleError();

		// go to the eBooks details page and check the console error

		WebElement selecteBook = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//ul[1]/li[1]/div[1]/i[1]/a[1]/img[1]")));
		selecteBook.click();
		Thread.sleep(3000);
		checkConsoleError();
		driver.navigate().back();
	}

	@Then("^Select option from sort By and check the console error$")
	public void Select_option_from_sort_By_and_check_the_console_error() throws Throwable {
		try {
			Thread.sleep(3000);
			dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk0-combobox")));
			dropDown.click();
			Thread.sleep(3000);
			checkConsoleError();

			WebElement newAndPopular = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='dk0-1']")));
			newAndPopular.click();
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error
			selecteBook = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div//ul[1]/li[1]/div[1]/i[1]/a[1]/img[1]")));
			selecteBook.click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

			Thread.sleep(3000);
			dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk0-combobox")));
			dropDown.click();
			Thread.sleep(3000);

			WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='dk0-2']")));
			name.click();
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error
			selecteBook = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div//ul[1]/li[1]/div[1]/i[1]/a[1]/img[1]")));
			selecteBook.click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

		} catch (FileNotFoundException e) {
		}

	}

	@Then("^Logout from the application and verify the page$")
	public void logout_from_the_application_and_verify_the_page() throws Throwable {
		// sign out from the application
		try {
			Thread.sleep(2000);
			WebElement sign_Out = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out")));
			sign_Out.click();
		} catch (NoSuchElementException e) {

		}

		// verify the message after signout
		String verifySignOutMessage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@class='base']"))).getText();

		Assert.assertTrue("user is not logout from the application",
				verifySignOutMessage.contains("YOU ARE NOW LOGGED OUT"));

	}
}
