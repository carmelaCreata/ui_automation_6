package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _01_ProjectTest extends Base {

    /**
     * TEST CASE 1
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the heading is “Contact Us”
     * Validate the address is “2860 S River Rd Suite 350, Des Plaines IL 60018”
     * Validate the email is “info@techglobalschool.com"
     * Validate the phone number is “(773) 257-3010”
     */
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/project-1");
    }

    @Test
    public void validateContactUsInformation() {

        WebElement heading = driver.findElement(By.cssSelector("h1[class='is-size-2']"));
        Assert.assertTrue(heading.isDisplayed());
        Assert.assertEquals(heading.getText(), "Contact Us");








    }


    /**TEST CASE 2
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Full name input box is displayed
     * Validate that the Full name input box is required
     * Validate that the label of the Full name input box is “Full name”
     * Validate that the placeholder of the Full name input box is “Enter your name”
     */
    @Test
    public void validateFullNameInput(){


    }
}




