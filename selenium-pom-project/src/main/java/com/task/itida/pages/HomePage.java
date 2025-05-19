package com.task.itida.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
	WebDriver driver;
    By searchBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String item) {
        driver.findElement(searchBox).sendKeys(item);
        driver.findElement(searchButton).click();
    }
}
