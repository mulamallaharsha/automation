package com.amazon.testing.v1.pojos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "ap_email")
	WebElement email;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(id = "ap_password")
	WebElement password;
	
	@FindBy(id = "signInSubmit")
	WebElement submitBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void set_email(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void clickContinue() {
		this.continueBtn.click();
	}
	
	
	public void set_password(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void submitButton() {
		this.submitBtn.click();
	}

}
