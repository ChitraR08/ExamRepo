package com.test;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
 
public class TestPage {
    private WebDriver driver;
     
    @BeforeClass
    public void printBrowserUsed() {
    	System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
    	driver = new ChromeDriver();
        System.out.println("Driver used is: " + driver);
        
    }
 
    @Test
    public void searchTestNGInGoogle() {
        final String searchKey = "TestNG";
        System.out.println("Search " + searchKey + " in google");
        driver.navigate().to("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        System.out.println("Enter " + searchKey);
        element.sendKeys(searchKey);
        System.out.println("submit");
        element.submit();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase()
                        .startsWith(searchKey.toLowerCase());
            }

			@Override
			public @Nullable Object apply(@Nullable Object arg0) {
				// TODO Auto-generated method stub
				return null;
			}
        });
        System.out.println("Got " + searchKey + " results");
    }
 
    @AfterSuite
    public void quitDriver() throws Exception {
        driver.quit();
    }
}
