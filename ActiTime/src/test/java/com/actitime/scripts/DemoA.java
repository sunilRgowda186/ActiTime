package com.actitime.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoA {
	static
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driver/chromedriver.exe");
	}
     public static WebDriver driver;
	@Test
	public void testBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}
	@Test
	public void test_EnterValue()
	{
		driver.findElement(By.name("q")).sendKeys("Seleniumhq.org",Keys.ENTER);
		driver.findElement(By.xpath("//h3[text()='Downloads - Selenium']")).click();
				
	}

}
