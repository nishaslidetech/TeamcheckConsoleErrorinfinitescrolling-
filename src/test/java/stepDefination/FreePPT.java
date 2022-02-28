package stepDefination;

import java.io.PrintStream;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import setupClass.BaseClass;

public class FreePPT extends BaseClass {
	private WebElement select_ppt;
	private WebElement free_Stuff;
	private WebElement free_ppt;

	WebElement business_ppt;
	static String errorLog;
	@Given("^user is already on Home page$")
	public void user_is_already_on_Home_page() throws Throwable {
		log.info("user is already on Home page");
		BaseClass.ClearBrowserCache();
	}

	@Then("^click on Free ppt and check console error$")
	public void click_on_Free_ppt_and_check_console_error() throws Throwable {
		try {
			free_Stuff = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//li[@class='menu-item has-sub-class']//a[@title = 'Free Stuff']")));
			Actions action = new Actions(driver);
			action.moveToElement(free_Stuff).perform();
			free_ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Free Samples']")));
			action.moveToElement(free_ppt).click().perform();
			Thread.sleep(3000);
			checkConsoleError();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on the any of one ppt and verify the console error for free user$")
	public void click_on_the_any_of_one_ppt_and_verify_the_console_error_for_free_user() throws Throwable {
		try {
			Thread.sleep(3000);
			select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//img[@title='Circular Flow Of Process 4 Stages Free PowerPoint Templates Slides']")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
			Thread.sleep(3000);
			checkConsoleError();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^check the pagination and check the console error$")
	public void check_the_pagination_and_check_the_console_error() throws Throwable {

	}

	@Then("^Click on the Free Business ppt and check the console error$")
	public void click_on_the_Free_Business_ppt_and_check_the_console_error() throws Throwable {
		// click on free Business PPts without login
		try {
			Thread.sleep(2000);
			free_Stuff = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[@class='menu-link'][normalize-space()='Free Stuff']")));
			Actions action = new Actions(driver);
			action.moveToElement(free_Stuff).perform();
			Thread.sleep(2000);
			business_ppt = BaseClass.elementToBeClickable(By.xpath("//a[@title='Free Business PPTs']"));
			Thread.sleep(1000);
			action.moveToElement(business_ppt).click().perform();
			Thread.sleep(3000);
			checkConsoleError();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on the any of one ppt and verify the console error for business ppts$")
	public void click_on_the_any_of_one_ppt_and_verify_the_console_error_for_business_ppts() throws Throwable {
		try {
			Thread.sleep(3000);
			select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//img[@title='3d Puzzle Pieces In Line Powerpoint Presentation Slides']")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
			Thread.sleep(3000);
			checkConsoleError();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^check the pagination and check the console error for business ppts$")
	public void check_the_pagination_and_check_the_console_error_for_business_ppts() throws Throwable {
		List<WebElement> sizeofPagination = driver.findElements(By.xpath("//div[3]//div[1]//div[1]//div//a"));

		System.out.println(sizeofPagination.size() + " = size");

		if (sizeofPagination.size() > 0) {
			System.out.println("pagination exists");

			// click on pagination link
			do
				if (!driver.findElements(By.xpath("//div[3]//div[1]//div[1]//div//a//img[@alt = 'Next']")).isEmpty()) {

					WebElement nextButton = driver
							.findElement(By.xpath("//div[3]//div[1]//div[1]//div//a//img[@alt = 'Next']"));
					nextButton.click();

					Thread.sleep(3000);
					// print console error
					checkConsoleError();

				} else

				{
					break;
				}

			while (true);
		} else {
			System.out.println("No pagination exists");
		}

	}

}
