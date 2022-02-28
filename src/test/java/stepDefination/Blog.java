package stepDefination;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import setupClass.BaseClass;

public class Blog extends BaseClass {
	static String errorLog;

	@Given("^Go to the Home page$")
	public void go_to_the_Home_page() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
	}

	@Then("^check console error for Blog page$")
	public void check_console_error_for_Blog_page() throws Throwable {
		try {
			Thread.sleep(3000);
			WebElement blog = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Blog")));
			blog.click();
			Thread.sleep(3000);
			checkConsoleError();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^click on any of blog and check the console error$")
	public void click_on_any_of_blog_and_check_the_console_error() throws Throwable {

		try {
			Thread.sleep(3000);
			List<WebElement> blogDetails = driver.findElements(
					By.xpath("//div[@class='container blog-container clearfix']//ol//li//div//div//div//a//img"));
			System.out.println(blogDetails.size() + "  = size");
			blogDetails.get(1).click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^click on pagination number and check the console error for two page only$")
	public void click_on_pagination_number_and_check_the_console_error_for_two_page_only() throws Throwable {

		List<WebElement> sizeofPagination = driver
				.findElements(By.xpath("//div[@class = 'toolbar toolbar-products']//li"));

		System.out.println(sizeofPagination.size() + " = size");

		if (sizeofPagination.size() > 0) {
			System.out.println("pagination exists");

			// click on pagination link
			do

				if (!driver
						.findElements(By.xpath("//div[@class = 'toolbar toolbar-products']//li//a//img[@alt='Next']"))
						.isEmpty()) {

					WebElement nextButton = driver.findElement(
							By.xpath("//div[@class = 'toolbar toolbar-products']//li//a//img[@alt='Next']"));
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
