package TestCases;

import Base.BaseClass;
import PageObjectModel.curaHome.CuraHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_TestCaseHome extends BaseClass {
    CuraHomePage curaHome;
    @Test(priority = 1)
    public void title() throws InterruptedException {

curaHome =new CuraHomePage(driver);
curaHome.verifyTitle();

    }

}
