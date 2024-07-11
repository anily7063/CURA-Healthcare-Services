package TestCases;

import Base.BaseClass;
import PageObjectModel.Login.Login;
import Utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static Base.BaseClass.driver;

public class TC_Login extends BaseClass {
    Login login;
    ReadConfig readConfig;
@Test(priority = 1)
    public void loginErrorMessageValidation(){
   // String expectedErrorMessage="Login failed! Please ensure the username and password are valid.";
    login= new Login(driver);
    readConfig =new ReadConfig();
    String username= readConfig.getUserName();
    String password=readConfig.getPassword();
login.clickMakeAppointment();
login.enterUsername(username);
login.enterPassword(password);
login.clickLogin();
//login.verifyErrorMessage(expectedErrorMessage);
    }
}
