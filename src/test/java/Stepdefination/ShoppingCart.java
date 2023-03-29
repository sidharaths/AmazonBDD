package Stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCart {
	WebDriver driver;
	@Given("User is signed {string}")
	public void user_is_signed(String string) throws InterruptedException {
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

	@Given("User searches for a product")
	public void user_searches_for_a_product() throws InterruptedException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("red tshirt");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".left-pane-results-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")).click();
	}

	@Given("on the product page")
	public void on_the_product_page() {
		driver.findElement(By.cssSelector(".widgetId\\=search-results_1 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > h2:nth-child(3) > a:nth-child(1) > span:nth-child(1)")).click();
		
	}

	@When("User clicks on Add to Cart button")
	public void user_clicks_on_add_to_cart_button() {
	   driver.findElement(By.id("add-to-cart-button")).click();
	}

	@Then("Shopping Cart should display the product")
	public void shopping_cart_should_display_the_product() throws InterruptedException {
	    driver.findElement(By.cssSelector("#sw-gtc > span:nth-child(1) > a:nth-child(1)")).click();
	    Thread.sleep(1000);
	    WebElement element=driver.findElement(By.cssSelector("div.sc-item-content-group:nth-child(3) > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1) > a:nth-child(1) > span:nth-child(1) > span:nth-child(1) > span:nth-child(2)"));
	   String text=element.getText();
	    System.out.println(text);
	   System.out.println("Product added in cart");
	    
}}
