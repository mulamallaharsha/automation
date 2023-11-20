package com.amazon.testing.v1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
		driver.get("https://www.amazon.in/ap/register?showRememberMe=true&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&prevRID=X9GXWBN6Q4KET7SGRQBM&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=inflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
//		driver.findElement(By.linkText("Start here.")).click();

		driver.findElement(By.id("ap_customer_name")).sendKeys("AutomationUserFirstName AutomationUserLastName");
		driver.findElement(By.id("ap_phone_number")).sendKeys("9876543210");
		driver.findElement(By.id("ap_email")).sendKeys("automationuser@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("automation@123");

	}

	@Test
	public void test_signin() {
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

//		driver.findElement(By.className("nav-action-signin-button")).click();

		driver.findElement(By.id("ap_email")).sendKeys("automationuser@gmail.com");
	}

	@Test
	public void test_search_item_and_add_to_cart() throws InterruptedException {
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("alexa");
		WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
		searchBtn.click();

		WebElement item = driver.findElement(By.xpath("//span[contains(text(),'Echo Dot (4th Gen, 2020 release) with clock')]"));
		String winHandleBefore = driver.getWindowHandle();
		item.click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		WebElement stockAvailability = driver.findElement(By.xpath("//div[@id=\"availability\"]/span"));
		if (stockAvailability.getText().equals("In stock")) {

			// Explicit wait until add to cart button is visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
			WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-button"));
			addToCartBtn.click();
		}

		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

	@AfterTest
	public void closeDriver() {

		driver.close();
	}
}
