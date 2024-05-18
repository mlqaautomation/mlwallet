package KPX_WEB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.utility.Utilities.*;

import com.driverInstance.DriverManager;
public class Google_PageObjects {
    public WebElement googleContainer (){
        return DriverManager.getDriver().findElement(By.cssSelector("[role='button']"));
    }

    public WebElement emailField(){
        return DriverManager.getDriver().findElement(By.cssSelector("[id='identifierId']"));
    }

    public WebElement emailNextButton(){
        return DriverManager.getDriver().findElement(By.cssSelector("[id='identifierNext']"));
    }

    public WebElement passwordField(){
        return DriverManager.getDriver().findElement(By.name("Passwd"));
    }

    public WebElement passNextButton(){
        return DriverManager.getDriver().findElement(By.cssSelector("[id='passwordNext']"));
    }

    public WebElement anotherWayButton(){
        return DriverManager.getDriver().findElement(By.cssSelector("[jsname='eBSUOb']"));
    }

    public WebElement selectGoogleAuthenticator(){
        return DriverManager.getDriver().findElement(By.xpath("//*[contains(text(), 'Google Authenticator')]"));
    }

    public WebElement codeField(){
        return DriverManager.getDriver().findElement(By.cssSelector("[type='tel']"));
    }
    public WebElement totpNextButton(){
        return DriverManager.getDriver().findElement(By.cssSelector("[id='totpNext']"));
    }
    public WebElement chooseCurrentAccount(){
        return DriverManager.getDriver().findElement(By.cssSelector("[aria-labelledby='picker-item-label-0']"));
    }
    public WebElement useOtherAccount(){
        return DriverManager.getDriver().findElement(By.cssSelector("[id='use-other']"));
    }

    public WebElement googleContainer2 (){
        return DriverManager.getDriver().findElement(By.cssSelector("[class='haAclf']"));
    }

}
