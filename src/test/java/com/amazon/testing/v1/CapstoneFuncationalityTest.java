package com.amazon.testing.v1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.testing.v1.pojos.AddtoCart;
import com.amazon.testing.v1.pojos.LoginPage;
import com.amazon.testing.v1.pojos.RegistrationPage;

/**
 * Automation
 */
public class CapstoneFuncationalityTest

{

	WebDriver driver;

	@BeforeTest
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Gaming-PC\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
	}

	@Test
	public void test_signup() {
		driver.get(
				"https://www.amazon.in/ap/register?showRememberMe=true&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&prevRID=X9GXWBN6Q4KET7SGRQBM&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=inflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

		RegistrationPage registration = new RegistrationPage(driver);
		registration.set_customer_name("AutomationUserFirstName AutomationUserLastName");
		registration.set_phone_number("9876543210");
		registration.set_email("automationuser@gmail.com");
		registration.set_password("automation@123");

	}

	@Test
	public void test_signin() {
		driver.get(
				"https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

		LoginPage login = new LoginPage(driver);
		login.set_email("automationuser@gmail.com");

	}

	@Test
	public void test_search_item_and_add_to_cart() throws InterruptedException {
		driver.get("https://www.amazon.in");

		AddtoCart sut = new AddtoCart(driver);
		sut.searchItem("alexa");
		sut.clickSearchButton();

		sut.findItemAndClick("Echo Dot (4th Gen, 2020 release) with clock");
		String winHandleBefore = driver.getWindowHandle();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		if (sut.isStockAvailable()) {
			sut.waitForAddToCartButtonVisible();
			sut.clickAddToCartButton();
		}

		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

	@AfterTest
	public void closeDriver() {

		driver.close();
	}
}
