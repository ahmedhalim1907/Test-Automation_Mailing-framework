package mailpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver Homedriver;
	WebDriverWait wait;

	// locators
	By ComposeLocator = By.xpath("//div[@class='z0']//div[@role='button']");
	By SendToLocator = By.id(":9n");// textarea[@id =':9n']
	By SubjectLocator = By.id(":95");// input[@id =':95']
	By AttachmentLocator = By.id(":ao");// div[@id =':ao']
	By SendButtonLocator= By.id(":8v");//div[@id=':8v']
	

	// constructor
	public HomePage(WebDriver driver) {
		Homedriver = driver;

	}

	public void ClickCompose() {
		
		wait =  new WebDriverWait(Homedriver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ComposeLocator));
		Homedriver.findElement(ComposeLocator).click();
	}

	public void RecipientsMail(String Recipient) {
		Homedriver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
		//Homedriver.findElement(RecipientLocator).click();
		Homedriver.findElement(SendToLocator).sendKeys(Recipient);
	}

	public void Subject(String FullTitle) {
		
		Homedriver.findElement(SubjectLocator).sendKeys(FullTitle);
	}

	public void Attachment() {
		
		Homedriver.findElement(AttachmentLocator).click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Homedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		
		
	}

	public void ClickSend() {
		Homedriver.findElement(SendButtonLocator).click();
	}

}
