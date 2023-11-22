package com.amazon.testing.v1.pojos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCart {

	WebDriver driver;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchButton;

	@FindBy(xpath = "//div[@id='availability']/span")
	WebElement stockAvailability;

	@FindBy(id = "add-to-cart-button")
	WebElement addToCartButton;

	public AddtoCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchItem(String email) {
		this.searchBox.clear();
		this.searchBox.sendKeys(email);
	}

	public void clickSearchButton() {
		this.searchButton.click();
	}

	public void findItemAndClick(String itemName) {
		this.driver.findElement(By.xpath("//span[contains(text(),'" + itemName + "')]")).click();
	}

	public void clickAddToCartButton() {
		this.addToCartButton.click();
	}

	public void waitForAddToCartButtonVisible() {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
	}

	public boolean isStockAvailable() {
		return this.stockAvailability.getText().equals("In stock");
	}

}
