package scripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _05_FacebookTest extends Base{

     /*
        Go to https://www.facebook.com/
        Validate the title of the page is "Facebook - log in or sign up"
        Validate the URL of the page is "https://www.facebook.com/"
        Validate "facebook" logo is displayed
        Validate heading2 "Connect with friends and the world around you on Facebook." is displayed
        Validate "Email or phone number" input box is displayed
        Validate "Password" input box is displayed
        Validate "Log In" button is displayed and enabled
        Validate "Forgot password?" link is displayed
        Validate "Create new account" button is displayed
         */


    @BeforeMethod
    public void setPage(){
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void validateFacebookLoginForm(){

    }
}
