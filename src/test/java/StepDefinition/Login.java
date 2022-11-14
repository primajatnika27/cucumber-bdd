package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	WebDriver driver;

	@Given("^I navigate to application URL$")
	public void I_navigate_to_application_URL() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://admin-demo.nopcommerce.com/");
	}
	
	@When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\" into the field$")
	public void I_enter_Username_as_someusername_and_Password_as_somepassword_into_the_field(String username, String password) {

		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(username);
		
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password);
	}
	
	@And("^I click on Login button$")
	public void I_click_on_Login_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
	}
	
	@Then("User should be able to login based on \"([^\"]*)\" login status")
	public void User_should_be_able_to_login_based_on_expected_login_status(String expectedResult) {
		
//		Alert alert = driver.switchTo().alert();
		String title = driver.getTitle();
		System.out.println(title);
		String actualResult = null;
		
		if (title.contains("Your store. Login")) {
			actualResult = "success";
		} else {
			actualResult = "failure";
		}
		
		Assert.assertEquals(expectedResult, actualResult);
		driver.quit();
		
	}
}
