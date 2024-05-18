package KPX_WEB;

import com.utility.ExtentReporter;
import org.openqa.selenium.NoSuchElementException;

public class Login_Steps extends Base_Steps {

    public void signInGoogle(String role) throws Exception {
        try{
            utilities.click(google_PageObjects.googleContainer(), "Google Sign in Container");
            utilities.switchToNextTab();
            utilities.typeEnter(google_PageObjects.emailField(), "Email Field", reader.getEmailByRole(role));
            utilities.typeEnter(google_PageObjects.passwordField(), "Password Field", reader.getPasswordByRole(role));
//            click(google_PageObjects.anotherWayButton(), "Another way");
            utilities.click(google_PageObjects.selectGoogleAuthenticator(), "Google Auth Option");
            utilities.typeEnter(google_PageObjects.codeField(), "Auth Key Field", TOTPGenerator.getTwoFactorCode());
            utilities.switchToPreviousTab();
        }catch (Exception e){
            utilities.click(google_PageObjects.selectGoogleAuthenticator(), "Google Auth Option");
            utilities.typeEnter(google_PageObjects.codeField(), "Auth Key Field", TOTPGenerator.getTwoFactorCode());
            utilities.switchToPreviousTab();
        }
    }

    public void signInGoogleV2()throws Exception{
        // logging in google via clicking the email, this only happens when browser is not closed
        try{
            utilities.click(google_PageObjects.googleContainer(), "Google Sign in Container");
            utilities.switchToNextTab();
            utilities.click(google_PageObjects.chooseCurrentAccount(), utilities.getText(google_PageObjects.chooseCurrentAccount()));
            utilities.switchToPreviousTab();
        }catch (Exception e){
            utilities.click(google_PageObjects.googleContainer2(), "Google Sign in Container");
            utilities.switchToNextTab();
            utilities.click(google_PageObjects.chooseCurrentAccount(), utilities.getText(google_PageObjects.chooseCurrentAccount()));
            utilities.switchToPreviousTab();
        }
    }
    public void loginKpx(String role)throws Exception{
        utilities.waitSleep(5000);
        try{
            utilities.type(loginPageObjects.userNameField(),"kpx username field", reader.getKpxUsername(role));
            utilities.type(loginPageObjects.passwordField(), "kpx password field", reader.getKpxPassword(role));
            utilities.click(loginPageObjects.loginButton(), "Login button");

        }catch (Exception e){
            ExtentReporter.extentLoggerPass("loginKpx, ","error "+ e);
        }
    }
    public void isInvalidAccount() throws Exception {
        if(utilities.isVisible(loginPageObjects.invalidCredText(), utilities.getText(loginPageObjects.invalidCredText()))){
            ExtentReporter.extentLoggerPass("isInvalidAccount ","Successfully Validated Invalid Account");
        }else{
            ExtentReporter.extentLoggerFail("isInvalidAccount ","Failed to Validate");
        }

    }
}
