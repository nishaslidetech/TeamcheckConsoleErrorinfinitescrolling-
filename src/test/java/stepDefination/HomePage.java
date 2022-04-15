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

public class HomePage extends BaseClass {
	static String errorLog;

	@Given("^Go the Home page$")
	public void go_the_Home_page() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
	}

	@Then("^check console error for Home page$")
	public void check_console_error_for_Home_page() throws Throwable {
		driver.navigate().refresh();
		Thread.sleep(4000);
		checkConsoleError();
	}

	@Then("^click on Sign in button and check console errors$")
	public void click_on_Sign_in_button_and_check_console_errors() throws Throwable {
		try {
			Thread.sleep(3000);
			WebElement sign_in = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign In']")));
			sign_in.click();
			Thread.sleep(3000);
			checkConsoleError();

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on Sign up button and check console errors$")
	public void click_on_Sign_up_button_and_check_console_errors() throws Throwable {
		try {
			Thread.sleep(3000);
			WebElement sign_up = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign up")));
			sign_up.click();
			Thread.sleep(3000);
			checkConsoleError();

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^check the console error for the top navigation links$")
	public void check_the_console_error_for_the_top_navigation_links() throws Throwable {
		try {
			driver.navigate().refresh();
			Thread.sleep(3000);
			WebElement pricing = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Pricing")));
			pricing.click();
			Thread.sleep(3000);
			checkConsoleError();
			//driver.navigate().back();

			WebElement eBooks = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("eBooks")));
			eBooks.click();
			Thread.sleep(3000);
			checkConsoleError();
			//driver.navigate().back();

			WebElement templateFinder = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("Template Finder")));
			templateFinder.click();
			checkConsoleError();
			Thread.sleep(3000);
			//driver.navigate().back();

			WebElement presentationServices = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("Presentation Services")));
			presentationServices.click();
			checkConsoleError();
			Thread.sleep(3000);
			//driver.navigate().back();

			WebElement researchServices = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("Research Services")));
			researchServices.click();
			Thread.sleep(3000);
			checkConsoleError();
			//driver.navigate().back();

		} catch (NoSuchElementException e) {

		}
	}

	@Then("^check the console errors for the footer navigation links$")
	public void check_the_console_errors_for_the_footer_navigation_links() throws Throwable {

		WebElement aboutUs = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("About Us")));
		js.executeScript("arguments[0].scrollIntoView();", aboutUs);
		aboutUs.click();
		checkConsoleError();
		Thread.sleep(3000);
		//driver.navigate().back();

		WebElement contactUs = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Contact Us")));
		js.executeScript("arguments[0].scrollIntoView();", contactUs);
		contactUs.click();
		Thread.sleep(3000);
		checkConsoleError();
		//driver.navigate().back();

		WebElement resumeServices = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Resume Services")));
		js.executeScript("arguments[0].scrollIntoView();", resumeServices);
		resumeServices.click();
		Thread.sleep(3000);
		checkConsoleError();
		//driver.navigate().back();

		WebElement couponCode = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Coupon Code")));
		js.executeScript("arguments[0].scrollIntoView();", couponCode);
		couponCode.click();
		Thread.sleep(3000);
		checkConsoleError();
		//driver.navigate().back();

		WebElement customDesignServies = wait
				.until(ExpectedConditions.elementToBeClickable(By.linkText("Custom Design Services")));
		js.executeScript("arguments[0].scrollIntoView();", customDesignServies);
		customDesignServies.click();
		checkConsoleError();
		//driver.navigate().back();

	}

	@Then("^Check the console error for newly added section$")
	public void check_the_console_error_for_newly_added_section() throws Throwable {
		WebElement newlyAdded = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Newly Added")));
		js.executeScript("arguments[0].scrollIntoView();", newlyAdded);
		newlyAdded.click();
		Thread.sleep(3000);
		checkConsoleError();

	}

	@Then("^click on the pagibation and check the console error for the two pages only\\.$")
	public void click_on_the_pagibation_and_check_the_console_error_for_the_two_pages_only() throws Throwable {
		List<WebElement> sizeofPagination = driver.findElements(By.xpath("//div[3]//div[1]//div[1]//div//a"));

		System.out.println(sizeofPagination.size() + " = size");

		if (sizeofPagination.size() > 0) {
			System.out.println("pagination exists");

			// click on pagination link
			do

				if (!driver.findElements(By.xpath("//div[3]//div[1]//div[1]//div//a//img[@alt = 'Next']")).isEmpty()) {

					WebElement nextButton = driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div//a//img[@alt = 'Next']"));
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
