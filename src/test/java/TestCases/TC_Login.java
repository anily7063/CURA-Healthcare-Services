package TestCases;

import Base.BaseClass;
import PageObjectModel.Login.Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static Base.BaseClass.driver;

public class TC_Login extends BaseClass {
    Login login;
@Test(priority = 1)
    public void loginErrorMessageValidation(){
    String expectedErrorMessage="Login failed! Please ensure the username and password are valid.";
    login= new Login(driver);
login.clickMakeAppointment();
login.enterUsername("abc");
login.enterPassword("abc");
login.clickLogin();
login.verifyErrorMessage(expectedErrorMessage);
    }
}
