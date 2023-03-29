package Stepdefination;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Additems {
	WebDriver driver;
	@Given("User is signed in to {string}")
	public void user_is_signed_in_to(String string) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get(string);
		driver.findElement(By.cssSelector("#ap_email")).sendKeys("sidharath.sharma2@ymail.com");
		Thread.sleep(100);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(100);
		driver.findElement(By.cssSelector("#ap_password")).sendKeys("9815968898");
		driver.findElement(By.cssSelector(".a-checkbox > label:nth-child(1) > input:nth-child(1)")).click();
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(1000);
		
	}
	    
		@Given("User has one item in the cart")
	public void user_has_one_item_in_the_cart() throws InterruptedException {
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("red tshirt");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".left-pane-results-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")).click();
			//On Product Page
			  Thread.sleep(1000);	
			driver.findElement(By.cssSelector(".widgetId\\=search-results_1 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > h2:nth-child(3) > a:nth-child(1) > span:nth-child(1)")).click();
			//Add to Cart
			  Thread.sleep(1000);	
			driver.findElement(By.id("add-to-cart-button")).click();
			Thread.sleep(1000);
			
	    driver.get("https://www.amazon.ca/gp/cart/view.html?ref_=sw_gtc");
	}

	@When("User clicks on Quantity dropdown and selects {int}")
	public void user_clicks_on_quantity_dropdown_and_selects(Integer int1) throws InterruptedException {
		Thread.sleep(1000);
	   driver.findElement(By.cssSelector("span.a-button:nth-child(3) > span:nth-child(1)")).click();
	   
	   Thread.sleep(100);
	   driver.findElement(By.id("quantity_2")).click();
	}

	
	@Then("Subtotal should increase")
	public void subtotal_should_increase() throws InterruptedException {
		 Thread.sleep(100);
	  WebElement element=driver.findElement(By.cssSelector("div.a-spacing-mini:nth-child(7)"));
	  String number=element.getText();
		System.out.println(number);	 
		driver.findElement(By.cssSelector("span.a-size-small:nth-child(3) > span:nth-child(1) > input:nth-child(1)")).click();
		driver.quit();
		
	}
}
