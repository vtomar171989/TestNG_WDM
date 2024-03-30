package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	
	//=================================== Locators =============================
	
	@FindBy(className="login")
	WebElement loginLink;
	
	@FindBy(name="user_login")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="remember-me")
	WebElement rememberMe;
	
	@FindBy(name="btn_login")
	WebElement LoginBtn;
	
	
	// ================================== Functions ==============================
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public void LoginFunction(String UserNameVal,String PwdVal) {
		
		// click on the login link
		loginLink.click();
		UserName.sendKeys(UserNameVal);
		Password.sendKeys(PwdVal);
		rememberMe.click();
		LoginBtn.click();
	}

}
