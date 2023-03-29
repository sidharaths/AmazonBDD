package Stepdefination;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MoreInfoPage {
	WebDriver driver;
	@Given("User Muct Be Signed in")
	public void user_muct_be_signed_in() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.findElement(By.cssSelector("#ap_email")).sendKeys("sidharath.sharma2@ymail.com");
		Thread.sleep(100);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(100);
		driver.findElement(By.cssSelector("#ap_password")).sendKeys("9815968898");
		driver.findElement(By.cssSelector(".a-checkbox > label:nth-child(1) > input:nth-child(1)")).click();
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(1000);
	    
	}

	@Given("Must have one Product in Cart")
	public void must_have_one_product_in_cart() throws InterruptedException {
		 Thread.sleep(1000);
		  driver.findElement(By.id("twotabsearchtextbox")).clear();
		  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("AirTag");
	 Thread.sleep(1000);
	  driver.findElement(By.cssSelector(".left-pane-results-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")).click();
	  //Select product 
	  driver.findElement(By.cssSelector(".widgetId\\=search-results_1 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > h2:nth-child(2) > a:nth-child(1) > span:nth-child(1)")).click();
	  Thread.sleep(1000);
	   //add to cart
	  Thread.sleep(1000);	  
	  driver.findElement(By.id("add-to-cart-button")).click();
	  //go to cart
	  Thread.sleep(1000);
	 
	  driver.findElement(By.cssSelector("#sw-gtc > span:nth-child(1) > a:nth-child(1)")).click();
	  Thread.sleep(1000);
	// Wait for the new window to open and switch to it
	 
	
	}
	@When("Click on Product")
	public void click_on_product() throws InterruptedException {
		 String mainWindowHandle = driver.getWindowHandle();
		 
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[3]/ul/li[1]/span/a/span[1]/span/span[2]")).click();
		 for(String handle : driver.getWindowHandles()) {
		      if(!handle.equals(mainWindowHandle)) {
		          driver.switchTo().window(handle);
		          break;
		      }  }
		
		 Thread.sleep(1000);
		 WebElement element=driver.findElement(By.cssSelector(".a-size-base-plus"));
		String a= element.getText();
		System.out.println(a);
		
		driver.switchTo().window(mainWindowHandle);
	}

	@Then("Must Take to Product Page")
	public void must_take_to_product_page() throws InterruptedException {
		String mainWindowHandle = driver.getWindowHandle();
		 Thread.sleep(1000);
		 //Print information for the product
		 WebElement element=driver.findElement(By.cssSelector(".a-size-base-plus"));
		String a= element.getText();
		System.out.println(a);
		//Back to Main WIndow 
		driver.switchTo().window(mainWindowHandle);
	    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[3]/div[1]/span[2]/span/input")).click();
		  Thread.sleep(1000);
	}
}
