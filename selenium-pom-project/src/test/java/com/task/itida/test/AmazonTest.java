package com.task.itida.test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.task.itida.pages.*;

public class AmazonTest {
	WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CartPage cartPage;

    String expectedName;
    String expectedPrice;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAddiPadToCart() throws InterruptedException {
        driver.get("https://www.amazon.eg/?language=en_AE");

        homePage = new HomePage(driver);
        homePage.searchFor("iPad");

        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.sortByPriceHighToLow();
        
        try { Thread.sleep(3000); } catch (InterruptedException e) {}  // wait for sorting
        searchResultsPage.clickFirstResult();

        productPage = new ProductPage(driver);
        expectedName = productPage.getProductName();
        expectedPrice = productPage.getProductPrice();
        productPage.addToCart();
        Thread.sleep(5000);
        driver.get("https://www.amazon.eg/gp/cart/view.html");

        cartPage = new CartPage(driver);
        String actualName = cartPage.getCartItemName();
        String actualPrice = cartPage.getCartItemPrice();

        Assert.assertTrue(actualName.contains(expectedName.substring(0, 5)), "Product name mismatch");
        Assert.assertEquals(actualPrice, expectedPrice, "Product price mismatch");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

}
