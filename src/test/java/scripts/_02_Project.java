package scripts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _02_Project extends Base{
    @BeforeMethod
    public void setPage(){driver.get("https://techglobal-training.com/frontend/project-2");}

    @Test(priority = 1, description = "Validate the login form")
    public void validateLoginForm() {
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement usernameLabel = driver.findElement(By.xpath("//label[@for=\"username\"]"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.xpath("//label[@for=\"password\"]"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[12]/div[2]/div[1]/form/div[3]/a"));

        Assert.assertTrue(usernameInputBox.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(usernameInputBox.getAttribute("required")));
        Assert.assertEquals(usernameLabel.getText(), "Please enter your username");

        Assert.assertTrue(passwordInputBox.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(usernameInputBox.getAttribute("required")));
        Assert.assertEquals(passwordLabel.getText(), "Please enter your password");

        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        loginButton.click();
        Assert.assertEquals(loginButton.getText(), "LOGIN");

        Assert.assertTrue(forgotPasswordLink.isDisplayed());
        Assert.assertTrue(forgotPasswordLink.isEnabled());
        forgotPasswordLink.click();
        Assert.assertEquals(forgotPasswordLink.getText(), "Forgot Password?");
    }

    @Test(priority = 2, description = "Validate the valid login")
    public void validateValidLogin(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("Test1234");
        loginButton.click();

        WebElement successMessage = driver.findElement(By.id("success_lgn"));
        WebElement logoutButton = driver.findElement(By.id("logout"));

        Assert.assertEquals(successMessage.getText(), "You are logged in");
        Assert.assertEquals(logoutButton.getText(), "LOGOUT");
    }

    @Test(priority = 3, description = "Validate the logout")
    public void validateLogout(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("Test1234");
        loginButton.click();

        WebElement logoutButton = driver.findElement(By.id("logout"));
        logoutButton.click();
        WebElement loginForm = driver.findElement(By.className("LoginForm_content__9q-YU"));
        Assert.assertTrue(loginForm.isDisplayed());
    }

    @Test(priority = 4, description = " Validate the Forgot Password? Link and Reset Password modal\n")
    public void validateForgotPasswordAndResetPassword(){
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[12]/div[2]/div[1]/form/div[3]/a"));
        forgotPasswordLink.click();

        WebElement heading = driver.findElement(By.id("sub_heading"));
        WebElement closeButton = driver.findElement(By.cssSelector("button[aria-label=\"close\"]"));
        WebElement emailInputBox = driver.findElement(By.id("email"));
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for=\"email\"]"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        Assert.assertTrue(heading.isDisplayed());
        Assert.assertTrue(closeButton.isDisplayed());
        Assert.assertTrue(emailInputBox.isDisplayed());
        Assert.assertEquals(emailLabel.getText(), "Enter your email address and we'll send you a link to reset your password.");
        Assert.assertTrue(submitButton.isEnabled());
        submitButton.click();
        Assert.assertEquals(submitButton.getText(),"SUBMIT");

    }
    @Test(priority = 5, description = "Validate the Reset Password modal close button") // failing
    public void validateResetPasswordModal(){
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        forgotPasswordLink.click();

        WebElement modal = driver.findElement(By.cssSelector(".modal-card-body"));
        Assert.assertTrue(modal.isDisplayed());

        WebElement closeButton = driver.findElement(By.cssSelector("button[aria-label=\"close\"]"));
        closeButton.click();

        WebElement loginForm = driver.findElement(By.cssSelector(".LoginForm_form__b4o6J"));
        Assert.assertTrue(loginForm.isDisplayed());
    }

    @Test(priority = 6, description = " Validate the Reset Password form submission" )
    public void validateResetPasswordForm(){
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[12]/div[2]/div[1]/form/div[3]/a"));
        forgotPasswordLink.click();

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("carmela.creata@yahoo.com");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement formMessage = driver.findElement(By.id("confirmation_message"));
        Assert.assertEquals(formMessage.getText(), "A link to reset your password has been sent to your email address.");

    }
    @Test(priority = 7, description = "Validate the invalid login with the empty credentials")
    public void validateInvalidLogin(){
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();
        WebElement failureMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(failureMessage.getText(), "Invalid Username entered!");
    }

    @Test(priority = 8, description = "Validate the invalid login with the wrong username")
    public void validateWrongUsername(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));

        usernameInputBox.sendKeys("John");
        passwordInputBox.sendKeys("Test1234");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();
        WebElement failureMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(failureMessage.getText(), "Invalid Username entered!");

    }
    @Test(priority = 9, description = "Validate the invalid login with the wrong password")
    public void validateInvalidLoginWithWrongPassword(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));

        usernameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("1234");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();
        WebElement failureMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(failureMessage.getText(), "Invalid Password entered!");
    }
    @Test(priority = 10, description = " Validate the invalid login with the wrong username and password")
    public void validateInvalidLoginWithWrongCredentials(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));

        usernameInputBox.sendKeys("John");
        passwordInputBox.sendKeys("1234");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();
        WebElement failureMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(failureMessage.getText(), "Invalid Username entered!");
    }

    }


