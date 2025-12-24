package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Assert.*;
import utils.DriverManager;

public class StepDef {

	
	WebDriver driver = DriverManager.getDriver();
	
	@Given("user access essence application")
	public void user_access_essence_application() {
		driver.get("http://localhost:80/ecomm");
	}
	@When("user selects one popular product")
	public void user_selects_one_popular_product() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement product = driver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div/div/div[1]/div/div[7]/div/div[2]/a/h6"));
			    product.click();
		//assertEquals(driver.getCurrentUrl(), "http://localhost/ecomm/single-product-details.html");    
			    Assert.assertTrue(driver.getCurrentUrl().contains("/single-product-details.html"));

			    
	}
	
	@And("user adds product to cart")
	public void user_adds_product_to_cart() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement addToCart = driver.findElement(By.name("addtocart"));
	    addToCart.click();
	}
	
	@And("user proceeds to checkout")
	public void user_proceeds_to_checkout() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement viewCart = driver.findElement(By.xpath("//*[@id=\"essenceCartBtn\"]/img"));
	    viewCart.click();
	   Thread.sleep(2000);
	   WebElement heading  = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/h2"));
	   String headingText = heading.getText();
	   
	  Assert.assertEquals(headingText, "Summary");
	  WebElement checkOutButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/a")); 
	  checkOutButton.click();
	  
	  Assert.assertTrue(driver.getCurrentUrl().contains("/checkout.html"));
	}
	
	@And("user enter all address details")
	public void user_enter_all_address_details() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement firstName = driver.findElement(By.id("first_name"));
		firstName.sendKeys("Miran");
		
		WebElement lastName = driver.findElement(By.id("last_name"));
		lastName.sendKeys("Kandil");
		
		WebElement company = driver.findElement(By.id("company"));
		company.sendKeys("ABC Corp");
		
		// Open dropdown
		driver.findElement(By.cssSelector("div.nice-select")).click();

		// Click the required country
		driver.findElement(
		    By.xpath("//li[@class='option' and normalize-space()='Germany']")
		).click();
		
		WebElement address1 = driver.findElement(By.id("street_address"));
		address1.sendKeys("123 Main St");
		
		WebElement address2 = driver.findElement(By.id("street_address2"));
		address2.sendKeys("Suite 400");
		
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("New York");
		
		WebElement state = driver.findElement(By.id("state"));
		state.sendKeys("NY");
		
		WebElement postcode = driver.findElement(By.id("postcode"));
		postcode.sendKeys("10001");
		
		WebElement phone = driver.findElement(By.id("phone_number"));
		phone.sendKeys("1234567890");
		
		WebElement email = driver.findElement(By.id("email_address"));
		email.sendKeys("miran@gmail.com");
		
		WebElement label = driver.findElement(By.cssSelector("label[for='customCheck1']"));
		new Actions(driver).moveToElement(label).click().perform();
		
		
}
	
	@And("user click places the order")
	public void user_click_places_the_order() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement placeOrder = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/a"));
		placeOrder.click();
	}
}
