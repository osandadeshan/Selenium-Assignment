package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Osanda on 10/5/2016.
 */
public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver localDriver){
        this.driver=localDriver;
    }

    @FindBy(how= How.XPATH, using="//input[@name='userName']")
    WebElement userName;

    @FindBy(how= How.XPATH, using="//input[@name='password']")
    WebElement password;

    @FindBy(how=How.XPATH, using="//input[@name='login']")
    WebElement signinButton;

    public void login(String uname, String pw){
        userName.sendKeys(uname);
        password.sendKeys(pw);
        signinButton.click();
    }

}
