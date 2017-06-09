package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

/**
 * Created by Osanda on 10/6/2016.
 */
public class BookingDetails {

    WebDriver driver;

    public BookingDetails(WebDriver localDriver){
        this.driver=localDriver;
    }

    @FindBy(how= How.XPATH, using="//td/a[@href='mercurysignoff.php']")
    WebElement logOutButton;

    public void checkBookingDetails(){
        Assert.assertTrue(driver.getPageSource().contains("Unified Airlines 363"), "Departing information is not matched!");
        System.out.println("\n===============================================\nDeparting information is matched!\n===============================================");

        Assert.assertTrue(driver.getPageSource().contains("Blue Skies Airlines 630"), "Returning information is not matched!");
        System.out.println("\n===============================================\nReturning information is matched!\n===============================================");

        Assert.assertTrue(driver.getPageSource().contains("1 passenger"), "Passenger count is not matched!");
        System.out.println("\n===============================================\nPassenger count is matched!\n===============================================");

        Assert.assertTrue(driver.getPageSource().contains("$596 USD"), "Total price is not matched!");
        System.out.println("\n===============================================\nTotal price is matched!\n===============================================");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logOutButton.click();
    }
}
