package com.amazon.testing.v1.pojos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	@FindBy(id = "ap_customer_name")
	WebElement customer_name;
	
	@FindBy(id = "ap_phone_number")
	WebElement phone_number;
	
	@FindBy(id = "ap_email")
	WebElement email;
	
	@FindBy(id = "ap_password")
	WebElement password;

	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void set_customer_name(String email) {
		this.customer_name.clear();
		this.customer_name.sendKeys(email);
	}
	
	public void set_phone_number(String phone_number) {
		this.phone_number.clear();
		this.phone_number.sendKeys(phone_number);
	}
	
	
	public void set_email(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	
	public void set_password(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	
	

}
