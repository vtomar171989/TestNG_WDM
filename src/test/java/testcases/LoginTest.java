package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	
	@Test
	public void LoginFailiureTest() {
		
		LoginPage login = new LoginPage(GetDriver());
		login.LoginFunction("abc@xyz.com","Anc@1234");
		
		WebElement errorMessage = GetDriver().findElement(By.className("error_msg"));
		System.out.println("The error message is " + errorMessage.getText());
		
		String actMsg = errorMessage.getText();
		String expMsg = "The email or password you have entered is invalid.";
		Assert.assertEquals(actMsg,expMsg);
		
		
	}
	
	@Test
	public void LoginSuccessTest() {
		
		LoginPage login = new LoginPage(GetDriver());
		login.LoginFunction("real@abc.com","RealPwd@1234");
		
		
	}
	
	@Test
	public void LoginSuccessTest2() {
		
		LoginPage login = new LoginPage(GetDriver());
		login.LoginFunction("real@abc.com","RealPwd@1234");
		
		
	}
	
	
	

}
