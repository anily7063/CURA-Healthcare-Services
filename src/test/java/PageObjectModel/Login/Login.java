package PageObjectModel.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {
    WebDriver driver;
    @FindBy(xpath = "//a[@id='btn-make-appointment']")
    WebElement makeMyAppointment;
    @FindBy(xpath = "//input[@id='txt-username']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='txt-password']")
    WebElement password;
    @FindBy(xpath = "//button[@id='btn-login']")
    WebElement loginBtn;
@FindBy(xpath = "//p[@class='lead text-danger']")
WebElement errorMessageForInvalidUserNameOrPassword;
    public Login(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
public void clickMakeAppointment(){

        makeMyAppointment.click();
}
public void enterUsername(String username){

        userName.sendKeys(username);
}
public void enterPassword(String strPassword){

        password.sendKeys(strPassword);
}
public void clickLogin(){

        loginBtn.click();
}
public void verifyErrorMessage(String expectedMsg){
        String actualErrorMessageInvalidLogin=errorMessageForInvalidUserNameOrPassword.getText();
    Assert.assertEquals(expectedMsg,actualErrorMessageInvalidLogin);
}
}
