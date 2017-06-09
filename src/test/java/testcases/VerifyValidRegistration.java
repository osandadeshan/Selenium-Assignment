package testcases;

import helper.BrowserFactory;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pagefactory.RegisterPage;
/**
 * Created by Osanda on 10/5/2016.
 */
public class VerifyValidRegistration {

    WebDriver  driver = BrowserFactory.startBrowser("chrome",
            "http://newtours.demoaut.com");


    @After
    public void TearDown()
    {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public void checkValidRegistraion(){

        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);

        registerPage.register("FirstName3","LastName3","715522089","osanda.deshan3@gmail.com","Address31","Address32","City3","State3",
                "80301","ALGERIA","gem","gem","gem");

      //  Assert.assertTrue(driver.findElement(By.xpath("//font/b[contains(text(),'UserName3')]")).getText().equals("UserName3"),"Username validation failed");


    }

}
