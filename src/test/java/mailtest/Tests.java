package mailtest;

import org.testng.annotations.Test;

import com.paypal.selion.platform.dataprovider.DataProviderFactory;
import com.paypal.selion.platform.dataprovider.DataResource;
import com.paypal.selion.platform.dataprovider.SeLionDataProvider;
import com.paypal.selion.platform.dataprovider.impl.InputStreamResource;

import mailpages.HomePage;
import mailpages.LoginPage;
import mailpages.MailData;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Tests {
	
	WebDriver driver;
	Date date = new Date(); 
	String FullTitle = "Task" + " , " + date.toString() ;
	
	@BeforeClass 
	  public void beforeClass() {
		  
			 System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
			 driver =new ChromeDriver();
			 driver.navigate().to("https://mail.google.com//");
			 driver.manage().window().maximize();

			 
	  }
	
  @Test (dataProvider = "DataProvider")
  public void Test_Login(MailData data ) {
	  LoginPage login= new LoginPage(driver);
	  
	  
	  login.EnterMail(data.getSenderMail());
	  login.PressNext();
	  login.EnterPassword(data.getSenderPassword());
	  login.PressNext();
	  
	  
  }
  
  @Test (dataProvider = "DataProvider")
  public void Test_SendMail(MailData data) {
	  
	  
	  HomePage Home = new HomePage(driver);
	  
	  Home.ClickCompose();
	  Home.RecipientsMail(data.getReceiverMail());
	  Home.Subject(FullTitle);
	  Home.Attachment();
	  Home.ClickSend();
	  
	  try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  @DataProvider(name  = "DataProvider")
  public Object[][] getJsonDataProvider() throws IOException {
	  DataResource resource = 
	    new InputStreamResource(new FileInputStream(".\\DataDriven_Task.json"),
	                                                MailData.class, "json");
	  SeLionDataProvider dataProvider =
	    DataProviderFactory.getDataProvider(resource);
	  Object[][] data = dataProvider.getAllData();
	  return data;
	}
  
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }
  
}
