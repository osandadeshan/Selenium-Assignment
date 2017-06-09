package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Osanda on 10/6/2016.
 */
public class SelectFlight {

    WebDriver driver;

    public SelectFlight(WebDriver localDriver){
        this.driver=localDriver;
    }

    @FindBy(how=How.XPATH, using="//input[@name='reserveFlights']")
    WebElement continueButton;


    public void setDepartFlight(WebDriver driver, int option) {
        List<WebElement> tripType = driver.findElements(By.xpath("//input[@name='outFlight']"));
        if (option > 0 && option <= tripType.size()) {
            tripType.get(option - 1).click();
        } else {
            throw new NotFoundException("option " + option + " not found");
        }
    }

    public void setReturnFlight(WebDriver driver, int option) {
        List<WebElement> tripType = driver.findElements(By.xpath("//input[@name='inFlight']"));
        if (option > 0 && option <= tripType.size()) {
            tripType.get(option - 1).click();
        } else {
            throw new NotFoundException("option " + option + " not found");
        }
    }


    public void checkSelectFlightDetails(int i){
        setDepartFlight(driver,i);
        Assert.assertTrue(driver.getPageSource().contains("$281"),"$281 validation failed!");
        System.out.println("\n===============================================\n$281 validation successful!\n===============================================");

        continueButton.click();
    }
}
