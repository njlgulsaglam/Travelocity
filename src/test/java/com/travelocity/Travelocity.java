package com.travelocity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Travelocity {
	
	WebDriver  driver;
    
	
	String carReturn= "12/25/2018" ;
	String departure = "12/20/2018" ;
	String return1 = "06/01/2019" ;
	String adults ="3" ;
	String dYear = "Nov 2018" ;
	String dDay= "23";
	
	
	@BeforeMethod
	  public void setUp() {

	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.travelocity.com/");
		driver.manage().window().fullscreen();
	}

	@Test
	public void bookAFlight() {
		
		driver.findElement(By.xpath("//button[@id='tab-flight-tab-hp']//span[@class='tab-label']")).click();
		driver.findElement(By.xpath("//input[@id='flight-origin-hp-flight']")).sendKeys("New York City");
		driver.findElement(By.xpath("//input[@id='flight-destination-hp-flight']")).sendKeys("Los Angeles");
		
		
		driver.findElement(By.id("flight-departing-hp-flight")).sendKeys(departure);
		
		driver.findElement(By.xpath("//input[@id='flight-departing-hp-flight']")).click();
		driver.findElement(By.xpath("//input[@id='flight-returning-hp-flight']")).sendKeys(return1);
		driver.findElement(By.xpath("//input[@id='flight-returning-hp-flight']")).sendKeys(adults);
		
		driver.findElement(By.xpath("//form[@id='gcw-flights-form-hp-flight']//button[@type='submit']")).click();
		
		
		
}

	@Test
	public void rentACar() {
		
		driver.findElement(By.id("tab-car-tab-hp")).click();
		driver.findElement(By.xpath("//input[@id='car-pickup-hp-car']")).sendKeys("Los Angeles");
		driver.findElement(By.id("car-dropoff-hp-car")).sendKeys("San Diego");
		
		driver.findElement(By.cssSelector("#car-pickup-date-hp-car")).sendKeys(departure);
		driver.findElement(By.cssSelector("#car-dropoff-date-hp-car")).clear();
		driver.findElement(By.cssSelector("#car-dropoff-date-hp-car")).sendKeys(carReturn);
		
		
		//driver.findElement(By.xpath("(//button [@type='submit'])[1]")).click();
		driver.findElement(By.xpath("//form[@id='gcw-cars-form-hp-car']//button[@type='submit']")).click();
		
	}
	@Test
	public void bookHotel() {
		driver.findElement(By.xpath("(//span[@class='icon icon-hotels'])[1]")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys("Los Angeles");
		driver.findElement(By.cssSelector("#hotel-checkin-hp-hotel")).sendKeys(departure);
		
		driver.findElement(By.cssSelector("#hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.cssSelector("#hotel-checkout-hp-hotel")).sendKeys(carReturn);
		
		driver.findElement(By.xpath("//form[@id='gcw-hotel-form-hp-hotel']//button[@type='submit']")).click();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
