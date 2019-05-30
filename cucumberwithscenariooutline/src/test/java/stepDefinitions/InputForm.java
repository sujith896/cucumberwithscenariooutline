package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import TestBase.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InputForm extends Base {
	
	
	@Given("^User is in selenium easy homepage$")
	public void user_is_in_selenium_easy_homepage() throws IOException {
		
		loadPropertiesFile();
		launchBrowser();

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
	}

	
	@When("^Title of the pageis selenium easy$")
	public void title_of_the_pageis_selenium_easy() {
		
		String title= driver.getTitle();
		System.out.println(title);
	   }

	@Then("^click on demo website$")
	public void click_on_demo_website()  {
		
		driver.findElement(By.xpath("//*[text()='Demo Website!']")).click();
		
	    
	}

	@Then("^Title of the page is best demo website$")
	public void title_of_the_page_is_best_demo_website() {
		String title= driver.getTitle();
		System.out.println(title);
		
	    
	}

	@Then("^click on input forms$")
	public void click_on_input_forms()  {
		driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")).click();
	    
	}

	@Then("^click on input form submit$")
	public void click_on_input_form_submit()  {
		driver.findElement(By.xpath("//*[text()='Input Form Submit']")).click();
	    
	}

	@Then("^user enters \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void user_enters_details_and_click_on_send(String firstname,String lastname,String email,String phone,String address
			,String city,String statename,String zipcode,String website,String comments)  {
		
		driver.findElement(By.name("first_name")).sendKeys(firstname);
		driver.findElement(By.name("last_name")).sendKeys(lastname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("address")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		
		Select s= new Select(driver.findElement(By.name("state")));
		s.selectByVisibleText(statename);
		driver.findElement(By.name("zip")).sendKeys(zipcode);
		driver.findElement(By.name("website")).sendKeys(website);
		driver.findElement(By.xpath("(//*[@name='hosting'])[1]")).click();
		driver.findElement(By.name("comment")).sendKeys(comments);
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	  
	}
	
	@Then("^close the browser$")
	public void close_the_browser()
	{
		driver.quit();
	}




}
