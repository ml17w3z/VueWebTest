package com.LoginTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {
	private WebDriver driver ;
	@Given("^I am on the login page$")
	public void goToLogin() { 
		System.setProperty("webdriver.chrome.driver", "D://driver//chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://localhost:8080/#/auth/login");
		System.out.println("This Step open the Chrome and launch the application");
	} 
 
	@When("^I enter username as tester$")
	public void enterUsername() { 
		WebElement element=driver.findElement(By.name("login"));
		element.click();
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		element.sendKeys(Keys.DELETE);
		element.sendKeys("tester"); 
	}
 
	@And ("^I enter password as pwd$") 
	public void enterPassword() { 
		WebElement element=driver.findElement(By.name("password"));
		element.click();
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		element.sendKeys(Keys.DELETE);
		element.sendKeys("pwd");
		driver.findElement(By.cssSelector("button.v-btn.v-btn--block.theme--light.primary")).click();
		
	}
	
	@Then("^Login should succeed$")
	public void checkSucceed() {
		//wait for 5s for Chrome's response
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expectPage="http://localhost:8080/#/dashboard";
		String actualPage=driver.getCurrentUrl();
		assertEquals(expectPage,actualPage);
		try {
			Thread.sleep(5000);
			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 	}
}
