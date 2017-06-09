package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Osanda on 10/6/2016.
 */
public class BookFlight {

    WebDriver driver;

    public BookFlight(WebDriver localDriver){
        this.driver=localDriver;
    }

    @FindBy(how= How.XPATH, using="//input[@name='passFirst0']")
    WebElement firstName;

    @FindBy(how= How.XPATH, using="//input[@name='passLast0']")
    WebElement lastName;

    @FindBy(how= How.XPATH, using="//select[@name='pass.0.meal']")
    WebElement meal;

    @FindBy(how= How.XPATH, using="//input[@name='creditnumber']")
    WebElement creditCardNo;

    @FindBy(how= How.XPATH, using="//input[@name='buyFlights']")
    WebElement securePurchaseButton;

    public void checkBookFlightDetails(String fname, String lname, String food, String creditCard){
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        meal.sendKeys(food);
        creditCardNo.sendKeys(creditCard);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        securePurchaseButton.click();
    }






}
