package PageObjectModel.curaHome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CuraHomePage {
    WebDriver driver;
    @FindBy(xpath = "//h1[normalize-space()='CURA Healthcare Service']")
    WebElement titleXpath;



        public CuraHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
public void verifyTitle(){
    String expectedTitle="CURA Healthcare Service";
    String title=titleXpath.getText();
    if (expectedTitle.equals(title)){
        System.out.println("Title is verified");
    }
}
}
