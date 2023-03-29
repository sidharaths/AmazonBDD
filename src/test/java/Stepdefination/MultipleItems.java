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
public class MultipleItems {
WebDriver driver;

	@Given("User Must Be signed in")
	public void user_must_be_signed_in() throws InterruptedException {System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
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

	@Given("User Must be on Shopping Cart Page {string}")
	public void user_must_be_on_shopping_cart_page(String string) throws InterruptedException {
	  driver.get(string);
		driver.get("https://www.amazon.ca/gp/product/B07YF1D2SX/ref=ewc_pr_img_1?smid=A3DWYIK6Y9EEQB&psc=1");
		Thread.sleep(1000);
		  driver.findElement(By.id("add-to-cart-button")).click();
		  driver.findElement(By.cssSelector("#sw-gtc > span:nth-child(1) > a:nth-child(1)")).click();
	  WebElement element=driver.findElement(By.cssSelector("#sc-subtotal-amount-activecart > span:nth-child(1)"));
	  String Price=element.getText();
	  System.out.println(Price);
	}

	@When("USer Should add same Item to cart")
	public void u_ser_should_add_same_item_to_cart() throws InterruptedException {
		driver.get("https://www.amazon.ca/gp/product/B07YF1D2SX/ref=ewc_pr_img_1?smid=A3DWYIK6Y9EEQB&psc=1");
		Thread.sleep(1000);
		  driver.findElement(By.id("add-to-cart-button")).click();
		  driver.findElement(By.cssSelector("#sw-gtc > span:nth-child(1) > a:nth-child(1)")).click();
		
	}

	@Then("Card should Upadate Quantity of Item")
	public void card_should_upadate_quantity_of_item() throws InterruptedException {
		WebElement element=driver.findElement(By.cssSelector("#sc-subtotal-amount-activecart > span:nth-child(1)"));
	  String A= element.getText();
	   System.out.println(A);
	   Thread.sleep(1000);
	  driver.findElement(By.cssSelector("span.a-size-small:nth-child(3) > span:nth-child(1) > input:nth-child(1)")).click();
	driver.quit();
	}
}
