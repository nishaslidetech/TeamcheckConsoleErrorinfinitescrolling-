package stepDefination;

import java.io.PrintStream;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import setupClass.BaseClass;

public class MostDownload extends BaseClass {
	WebElement popular_Ppts;
	static String errorLog;
	WebElement viewPerPage;
	WebElement selectDropdown;
	WebElement filterByCategory;

	@Given("^user is already on home page$")
	public void user_is_already_on_home_page() throws Throwable {
		log.info("user is already on Home page");
		BaseClass.ClearBrowserCache();
	}

	@Then("^click on Popular ppts text and check console error$")
	public void click_on_Popular_ppts_text_and_check_console_error() throws Throwable {
		// click on Popular PPTs without login
		try {
			popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Popular PPTs")));
			popular_Ppts.click();
			checkConsoleError();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on the any of one ppt and verify the console error$")
	public void click_on_the_any_of_one_ppt_and_verify_the_console_error() throws Throwable {

		try {
			Thread.sleep(2000);
			WebElement select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[4]/div[1]/ol[1]/li[1]/div[1]/a[1]/img[1]")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
			checkConsoleError();
			driver.navigate().back();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on the pagination and check the console errorfor two pages only$")
	public void click_on_the_pagination_and_check_the_console_errorfor_two_pages_only() throws Throwable {
		/*List<WebElement> sizeofPagination = driver.findElements(By.xpath("//div[3]//div[1]//div[1]//div//a"));

		System.out.println(sizeofPagination.size() + " = size");

		if (sizeofPagination.size() > 0) {
			System.out.println("pagination exists");

			// click on pagination link
			do

				if (!driver.findElements(By.xpath("//div[3]//div[1]//div[1]//div//a//img[@alt = 'Next']")).isEmpty()) {

					WebElement nextButton = driver
							.findElement(By.xpath("//div[3]//div[1]//div[1]//div//a//img[@alt = 'Next']"));
					nextButton.click();

					Thread.sleep(2000);
					// print console error
					checkConsoleError();

				} else

				{
					break;
				}

			while (true);
		} else {
			System.out.println("No pagination exists");
		}*/
		
		// implemented infinite scrolling
		
		long intialLength = (long) js.executeScript("return document.body.scrollHeight");
		while (true) {
			js.executeScript("window.scrollBy(0,10500)", "");
			checkConsoleError();
			if (!(driver.findElements(By.xpath("//em[normalize-space()='Loading - please wait...']")).isEmpty())) {
				try {
					WebElement loader = driver.findElement(By.xpath("//em[normalize-space()='Loading - please wait...']"));
					js.executeScript("arguments[0].scrollIntoView();", loader);
					Thread.sleep(5000);
					checkConsoleError();
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (!(driver.findElements(By.xpath("//button[@type='submit']")).isEmpty())) {
				try {
					WebElement loadMorePPT = driver.findElement(By.xpath("//button[@type='submit']"));
					js.executeScript("arguments[0].scrollIntoView();", loadMorePPT);
					loadMorePPT.click();
					Thread.sleep(5000);
					checkConsoleError();
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			long currentLength = (long) js.executeScript("return document.body.scrollHeight");
			//System.out.println("currentLength = " + currentLength);
			if (intialLength == currentLength) {
				//System.out.println("intialLength 1 = " + currentLength);
				//System.out.println("currentLength 1 = " + currentLength);
				break;
			}
			intialLength = currentLength;

		}
	}

	@Then("^click on the view page and check the console error$")
	public void click_on_the_view_page_and_check_the_console_error() throws Throwable {
		// driver.navigate().back();
		selectDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk1-combobox")));
		js.executeScript("arguments[0].scrollIntoView();", selectDropdown);
		selectDropdown.click();

		// check console error for the 120 pages
		viewPerPage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id = 'dk1-listbox']//li[2]")));
		js.executeScript("arguments[0].scrollIntoView();", viewPerPage);
		viewPerPage.click();
		Thread.sleep(2000);
		// print console error
		checkConsoleError();

		selectDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk1-combobox")));
		js.executeScript("arguments[0].scrollIntoView();", selectDropdown);
		selectDropdown.click();

		// check console error for the 180 pages
		viewPerPage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id = 'dk1-listbox']//li[3]")));
		js.executeScript("arguments[0].scrollIntoView();", viewPerPage);
		viewPerPage.click();
		Thread.sleep(2000);
		// print console error
		checkConsoleError();

	}

	@Then("^click on the Filter By Category and check the console error$")
	public void click_on_the_Filter_By_Category_and_check_the_console_error() throws Throwable {
		WebElement filterByCategory = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk0-combobox")));
		js.executeScript("arguments[0].scrollIntoView();", filterByCategory);
		filterByCategory.click();

		// check console error for the 120 pages
		WebElement diagrams = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[@id = 'dk0-listbox']//li[2]")));
		js.executeScript("arguments[0].scrollIntoView();", diagrams);
		diagrams.click();
		Thread.sleep(2000);
		// print console error
		checkConsoleError();

		filterByCategory = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk0-combobox")));
		js.executeScript("arguments[0].scrollIntoView();", filterByCategory);
		filterByCategory.click();

		// check console error for the 180 pages
		WebElement flatDesigns = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[@id = 'dk0-listbox']//li[3]")));
		js.executeScript("arguments[0].scrollIntoView();", flatDesigns);
		flatDesigns.click();
		Thread.sleep(2000);
		// print console error
		checkConsoleError();

		filterByCategory = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk0-combobox")));
		js.executeScript("arguments[0].scrollIntoView();", filterByCategory);
		filterByCategory.click();

		WebElement businessSlides = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[@id = 'dk0-listbox']//li[4]")));
		js.executeScript("arguments[0].scrollIntoView();", businessSlides);
		businessSlides.click();
		Thread.sleep(2000);
		// print console error
		checkConsoleError();

		filterByCategory = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk0-combobox")));
		js.executeScript("arguments[0].scrollIntoView();", filterByCategory);
		filterByCategory.click();

		WebElement completeDesk = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[@id = 'dk0-listbox']//li[5]")));
		js.executeScript("arguments[0].scrollIntoView();", completeDesk);
		completeDesk.click();
		Thread.sleep(2000);
		// print console error
		checkConsoleError();

	}
}
