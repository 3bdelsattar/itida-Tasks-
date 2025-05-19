package com.task.itida.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ProductPage {
	 WebDriver driver;

	    By productTitle = By.id("productTitle");
	    By price = By.xpath("//*[@id='corePriceDisplay_desktop_feature_div']"); 
	    By addToCart = By.id("add-to-cart-button");
	    By noToWaranty = By.xpath("//*[@id='attachSiNoCoverage']");
	    
	    public ProductPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public String getProductName() {
	        return driver.findElement(productTitle).getText().trim();
	    }

	    public String getProductPrice() {
	        return driver.findElement(price).getText().replace("\n", "").replace(".", "").trim();
	        
	        
	    }

	    public void addToCart() throws InterruptedException {
	        driver.findElement(addToCart).click();
	        Thread.sleep(5000);
	        driver.findElement(noToWaranty).click();
	        
	    }
}
