package testcases;

import helper.BrowserFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pagefactory.*;

/**
 * Created by Osanda on 10/5/2016.
 */
public class VerifyValidBooking {

    WebDriver driver = BrowserFactory.startBrowser("chrome",
            "http://newtours.demoaut.com");


//    @After
//    public void TearDown()
//    {
//        if (driver != null) {
//            driver.close();
//        }
//    }

    @Test
    public void checkValidBooking(){
        LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        login.login("gem","gem");

        FlightFinder flightFinder = PageFactory.initElements(driver, FlightFinder.class);
        flightFinder.checkFlightFinderDetails(2,"1","New York","November","26","London","December","25",3,"Unified Airlines");

        SelectFlight selectFlight = PageFactory.initElements(driver, SelectFlight.class);
        selectFlight.checkSelectFlightDetails(4);

        BookFlight bookFlight = PageFactory.initElements(driver, BookFlight.class);
        bookFlight.checkBookFlightDetails("Gemunu", "Priyadarshana", "Kosher", "0123456789");

        BookingDetails bookingDetails = PageFactory.initElements(driver, BookingDetails.class);
        bookingDetails.checkBookingDetails();
    }

}
