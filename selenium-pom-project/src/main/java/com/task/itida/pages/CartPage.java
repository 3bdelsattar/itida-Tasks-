package com.task.itida.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {

	 WebDriver driver;
	 WebDriverWait wait;

	    By cartName = By.cssSelector(".sc-list-item-content .sc-product-title");
	    By cartPrice = By.cssSelector(".sc-product-price");

	    public CartPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    public String getCartItemName() {
	    	WebElement nameEl = wait.until(ExpectedConditions.visibilityOfElementLocated(cartName));
	        return nameEl.getText().trim();	    
	    }

	    public String getCartItemPrice() {
	    	 WebElement priceEl = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPrice));
	         return priceEl.getText().replace("\n", "").replace(".", "").trim();
	         
	    }
}
