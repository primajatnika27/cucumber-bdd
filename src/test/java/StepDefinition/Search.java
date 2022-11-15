package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Search {
	
	WebDriver driver;
	
	@Given("")
	public void I_navigate_to_application_URL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://blossomzones.com/");
	}
	
	@When("")
	public void When_I_input_some_product_on_search_text_field(String keyword) {
		driver.findElement(By.cssSelector("#wc_ps_search_keyword_2")).clear();
		driver.findElement(By.cssSelector("#wc_ps_search_keyword_2")).sendKeys(keyword);
	}
	
	@When("")
	public void I_click_on_search_button() {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")).click();
	}
	
	@And("")
	public void I_click_add_to_chart_this_product() {
		driver.findElement(By.linkText("Add to cart")).click();
	}
	
	@And("")
	public void I_click_view_chart() {
		driver.findElement(By.linkText("View cart")).click();
	}
	
	@And("")
	public void I_click_process_to_checkout() {
		driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
	}
	
	@Then("")
	public void User_process_to_payment() {
		
	}

}
