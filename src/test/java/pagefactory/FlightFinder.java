package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by Osanda on 10/5/2016.
 */
public class FlightFinder {

    WebDriver driver;

    public FlightFinder(WebDriver localDriver){
        this.driver=localDriver;
    }

    @FindBy(how= How.XPATH, using="//input[@name='tripType']")
    WebElement tripType;

    @FindBy(how= How.XPATH, using="//select[@name='passCount']")
    WebElement passengerCount;

    @FindBy(how= How.XPATH, using="//select[@name='fromPort']")
    WebElement fromPort;

    @FindBy(how= How.XPATH, using="//select[@name='fromMonth']")
    WebElement fromMonth;

    @FindBy(how= How.XPATH, using="//select[@name='fromDay']")
    WebElement fromDay;

    @FindBy(how= How.XPATH, using="//select[@name='toPort']")
    WebElement toPort;

    @FindBy(how= How.XPATH, using="//select[@name='toMonth']")
    WebElement toMonth;

    @FindBy(how= How.XPATH, using="//select[@name='toDay']")
    WebElement toDay;

    @FindBy(how= How.XPATH, using="//input[@name='servClass']")
    WebElement serviceClass;

    @FindBy(how= How.XPATH, using="//select[@name='airline']")
    WebElement airline;

    @FindBy(how=How.XPATH, using="//input[@name='findFlights']")
    WebElement continueButton;

    public void setTripType(WebDriver driver, int option) {
        List<WebElement> tripType = driver.findElements(By.xpath("//input[@name='tripType']"));
        if (option > 0 && option <= tripType.size()) {
            tripType.get(option - 1).click();
        } else {
            throw new NotFoundException("option " + option + " not found");
        }
    }

    public void setServiceClass(WebDriver driver, int option) {
        List<WebElement> tripType = driver.findElements(By.xpath("//input[@name='servClass']"));
        if (option > 0 && option <= tripType.size()) {
            tripType.get(option - 1).click();
        } else {
            throw new NotFoundException("option " + option + " not found");
        }
    }

    public void checkFlightFinderDetails(int tType, String passCount, String frPort, String frMonth, String frDay, String tPort,
                                   String tMonth, String tDay, int servClass, String airln){
                setTripType(driver,tType);
                passengerCount.sendKeys(passCount);
                fromPort.sendKeys(frPort);
                fromMonth.sendKeys(frMonth);
                fromDay.sendKeys(frDay);
                toPort.sendKeys(tPort);
                toMonth.sendKeys(tMonth);
                toDay.sendKeys(tDay);
                setServiceClass(driver,servClass);
                airline.sendKeys(airln);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        continueButton.click();
    }
}
