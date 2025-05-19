package com.task.itida.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {

	WebDriver driver;

    By sortDropdown = By.id("a-autoid-0-announce");
    By highToLowOption = By.linkText("Price: High to Low");
    By firstResult = By.xpath("//*[@data-cel-widget='search_result_1']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortByPriceHighToLow() {
        driver.findElement(sortDropdown).click();
        driver.findElement(highToLowOption).click();
    }

    public void clickFirstResult() {
        driver.findElement(firstResult).click();
    }
}
