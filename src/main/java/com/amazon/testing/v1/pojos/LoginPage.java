package com.amazon.testing.v1.pojos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "ap_email")
	WebElement email;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void set_email(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

}
