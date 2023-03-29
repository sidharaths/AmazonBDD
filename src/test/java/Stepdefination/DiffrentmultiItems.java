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
public class DiffrentmultiItems {
	WebDriver driver ;
	@Given("User Must be Signed in")
	public void user_must_be_signed_in() throws InterruptedException {
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

	@When("One Type of Item to be added")
	public void one_type_of_item_to_be_added() throws InterruptedException {
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
	
	}

	@When("Second type of Item to be added")
	public void second_type_of_item_to_be_added() throws InterruptedException {
	  driver.get("https://www.amazon.ca/s?k=red+tshirt&crid=32HYVK2KESLUA&sprefix=red+tshirt%2Caps%2C152&ref=nb_sb_ss_ts-doa-p_1_10");
	  //search product
	  Thread.sleep(1000);
	  driver.findElement(By.id("twotabsearchtextbox")).clear();
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("AirTag");
	  Thread.sleep(1000);//.left-pane-results-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)
	  driver.findElement(By.cssSelector(".left-pane-results-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")).click();
	  //Select product 
	  driver.findElement(By.cssSelector(".widgetId\\=search-results_1 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > h2:nth-child(2) > a:nth-child(1) > span:nth-child(1)")).click();
	  Thread.sleep(1000);
	   //add to cart
	  Thread.sleep(1000);	  
	  driver.findElement(By.id("add-to-cart-button")).click();
	  //go to cart
	  Thread.sleep(1000);	 //#sw-gtc > span:nth-child(1) > a:nth-child(1)
	  driver.findElement(By.cssSelector("#sw-gtc > span:nth-child(1) > a:nth-child(1)")).click();
	  Thread.sleep(1000);  
	}

	@Then("Cart Should display corresponding Items")
	public void cart_should_display_corresponding_items() throws InterruptedException {
		
		//Product1
		  Thread.sleep(1000); //
		  WebElement elementone=driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[3]/ul/li[1]/span/a/span[1]/span/span[2]"));
		  String product1=elementone.getText();	
		  Thread.sleep(1000);
		  WebElement elementtwo=driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[4]/div[4]/div/div[3]/ul/li[1]/span/a/span[1]/span/span[2]"));
		  String product2=elementtwo.getText();
		  Thread.sleep(1000);  

	  System.out.println(product1); System.out.println(product2);
	  Thread.sleep(1000); 
	  //Empty Cart
	  driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[3]/div[1]/span[2]/span/input")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[2]/div[4]/div/div[3]/div[1]/span[2]/span/input")).click();
	  System.out.println("Cart Is Empty all product removed");
	  driver.quit();	}}
