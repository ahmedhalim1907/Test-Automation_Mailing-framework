package mailpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage {
	WebDriver Logindriver; 
	WebDriverWait wait;
	
	By loginLocator = By.xpath ("//input[@id='identifierId']");
	By NextLocatorEnglich = By.xpath ("//span[contains(text(),'Next')]");
	By NextLocatorArabic = By.xpath ("//span[contains(text(),'التالي')]");//next in arabic
	By PasswordLocator = By.xpath ("//input[@name='password']");
	
	public LoginPage(WebDriver driver){
		Logindriver = driver;
	}
	
	  public void EnterMail(String mail){
		  Logindriver.findElement(loginLocator).sendKeys(mail);
		 
	  }
	  public void PressNext(){
		  try {Logindriver.findElement(NextLocatorEnglich).click();
			  
		  }catch(Exception e) {
			  Logindriver.findElement(NextLocatorArabic).click();
		  }
		  
		   
	  }
	  public void EnterPassword(String password){
		  wait =  new WebDriverWait(Logindriver,15);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordLocator));
		  
		  Logindriver.findElement(PasswordLocator).sendKeys(password);
		  
	  }

			
			
}
