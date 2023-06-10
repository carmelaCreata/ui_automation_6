package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DropdownHandler;

import java.util.List;

public class Project03 extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-3");
    }
    /** TEST CASE 1
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Validate that the “One way” radio button is displayed enabled and selected by default
     * Validate that the “Round trip” radio button is displayed enabled and not selected by default
     * Validate that the “Cabin Class” label and dropdown are displayed
     * Validate that the “From” label and dropdown are displayed
     * Validate that the “To” label and dropdown are displayed
     * Validate that the “Depart” label and date picker is displayed
     * Validate that the “Return” label and date picker is displayed and disabled
     * Validate that the “Number of passengers” label and dropdown are displayed and 1 is the default
     * Validate that the “Passenger 1” category label and dropdown are displayed and “Adult (16-64)” is the default
     * Validate that the “BOOK” button is displayed and enabled
     */
    @Test
    public void validateBookTripForm(){
       List <WebElement> radioButtonsInput = driver.findElements(By.className("mr-1"));

        radioButtonsInput.forEach(rb->{
            Assert.assertTrue(rb.isDisplayed());
            Assert.assertTrue(rb.isEnabled());

        });

        Assert.assertTrue(radioButtonsInput.get(0).isSelected());
        Assert.assertFalse(radioButtonsInput.get(1).isSelected());

       WebElement cabinClassLabel = driver.findElement(By.cssSelector(".field:nth-child(2)"));
       WebElement cabinClassDropdown = driver.findElement(By.cssSelector(".field:nth-child(2) option"));
       Assert.assertTrue(cabinClassLabel.isDisplayed());
       Assert.assertTrue(cabinClassDropdown.isDisplayed());

       WebElement fromLabel = driver.findElement(By.cssSelector(".field:nth-child(3)"));
       WebElement fromLabelDropdown = driver.findElement(By.cssSelector(".field:nth-child(3) option"));
       Assert.assertTrue(fromLabel.isDisplayed());
       Assert.assertTrue(fromLabelDropdown.isDisplayed());

       WebElement toLabel = driver.findElement(By.cssSelector(".field:nth-child(4)"));
       WebElement toDropdown = driver.findElement(By.cssSelector(".field:nth-child(4) option"));
       Assert.assertTrue(toLabel.isDisplayed());
       Assert.assertTrue(toDropdown.isDisplayed());

       WebElement departLabel = driver.findElement(By.cssSelector(".field:nth-child(5)"));
       WebElement datePicker1 = driver.findElement(By.cssSelector(".field:nth-child(5) .control"));
       Assert.assertTrue(departLabel.isDisplayed());
       Assert.assertTrue(datePicker1.isDisplayed());

       WebElement returnLabel = driver.findElement(By.cssSelector(".field:nth-child(6)"));
       WebElement datePicker2 = driver.findElement(By.cssSelector(".field:nth-child(6) .control"));
        Assert.assertTrue(returnLabel.isDisplayed());
        Assert.assertTrue(datePicker2.isDisplayed());
        Assert.assertTrue(datePicker2.isEnabled());


       WebElement nrOfPassengersLabel = driver.findElement(By.cssSelector(".field:nth-child(7)"));
       WebElement nrOfPassengersDropdown = driver.findElement(By.cssSelector(".field:nth-child(7) option"));
       Assert.assertTrue(nrOfPassengersLabel.isDisplayed());
       Assert.assertTrue(nrOfPassengersDropdown.isDisplayed());
       Assert.assertEquals(nrOfPassengersDropdown.getAttribute("value"), "1");

       WebElement passengerLabel = driver.findElement(By.cssSelector(".field:nth-child(8)"));
       WebElement passengerDropdown = driver.findElement(By.cssSelector(".field:nth-child(8) option"));
       Assert.assertTrue(passengerLabel.isDisplayed());
       Assert.assertTrue(passengerDropdown.isDisplayed());
       Assert.assertEquals(passengerDropdown.getText(), "Adult (16-64)");

       WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
       Assert.assertTrue(submitButton.isDisplayed());
       Assert.assertTrue(submitButton.isEnabled());

    }
    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Click on the “Round trip” radio button and validate it is selected
     * Validate that the “One way” radio button is not selected
     * Validate that the “Cabin Class” label and dropdown are displayed
     * Validate that the “From” label and dropdown are displayed
     * Validate that the “To” label and dropdown are displayed
     * Validate that the “Depart” label and date picker is displayed
     * Validate that the “Return” label and date picker is displayed
     * Validate that the “Number of passengers” label and dropdown are displayed and 1 is the default
     * Validate that the “Passenger 1” label and dropdown are displayed and “Adult (16-64)” is the default
     * Validate that the “BOOK” button is displayed and enabled
     */
    @Test
    public void validateRoundTripForm(){
        List <WebElement> radioButtonsInput = driver.findElements(By.className("mr-1"));

        radioButtonsInput.forEach(rb->{
            Assert.assertTrue(rb.isDisplayed());
            Assert.assertTrue(rb.isEnabled());

        });
        radioButtonsInput.get(1).click();
        Assert.assertTrue(radioButtonsInput.get(1).isSelected());
        Assert.assertFalse(radioButtonsInput.get(0).isSelected());

        WebElement cabinClassLabel = driver.findElement(By.cssSelector(".field:nth-child(2)"));
        WebElement cabinClassDropdown = driver.findElement(By.cssSelector(".field:nth-child(2) option"));
        Assert.assertTrue(cabinClassLabel.isDisplayed());
        Assert.assertTrue(cabinClassDropdown.isDisplayed());

        WebElement fromLabel = driver.findElement(By.cssSelector(".field:nth-child(3)"));
        WebElement fromLabelDropdown = driver.findElement(By.cssSelector(".field:nth-child(3) option"));
        Assert.assertTrue(fromLabel.isDisplayed());
        Assert.assertTrue(fromLabelDropdown.isDisplayed());

        WebElement toLabel = driver.findElement(By.cssSelector(".field:nth-child(4)"));
        WebElement toDropdown = driver.findElement(By.cssSelector(".field:nth-child(4) option"));
        Assert.assertTrue(toLabel.isDisplayed());
        Assert.assertTrue(toDropdown.isDisplayed());

        WebElement departLabel = driver.findElement(By.cssSelector(".field:nth-child(5)"));
        WebElement datePicker1 = driver.findElement(By.cssSelector(".field:nth-child(5) .control"));
        Assert.assertTrue(departLabel.isDisplayed());
        Assert.assertTrue(datePicker1.isDisplayed());

        WebElement returnLabel = driver.findElement(By.cssSelector(".field:nth-child(6)"));
        WebElement datePicker2 = driver.findElement(By.cssSelector(".field:nth-child(6) .control"));
        Assert.assertTrue(returnLabel.isDisplayed());
        Assert.assertTrue(datePicker2.isDisplayed());



        WebElement nrOfPassengersLabel = driver.findElement(By.cssSelector(".field:nth-child(7)"));
        WebElement nrOfPassengersDropdown = driver.findElement(By.cssSelector(".field:nth-child(7) option"));
        Assert.assertTrue(nrOfPassengersLabel.isDisplayed());
        Assert.assertTrue(nrOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(nrOfPassengersDropdown.getAttribute("value"), "1");

        WebElement passengerLabel = driver.findElement(By.cssSelector(".field:nth-child(8)"));
        WebElement passengerDropdown = driver.findElement(By.cssSelector(".field:nth-child(8) option"));
        Assert.assertTrue(passengerLabel.isDisplayed());
        Assert.assertTrue(passengerDropdown.isDisplayed());
        Assert.assertEquals(passengerDropdown.getText(), "Adult (16-64)");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
    }
    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Select the “One way” radio button
     * Select “Business” for the “Cabin Class” dropdown
     * Select “Illinois” for the “From” dropdown
     * Select “Florida” for the “To” dropdown
     * Select the next week for the ”Depart”
     * Select “1” for the “Number of passengers” dropdown
     * Select “Senior (65+)” for the Passenger 1 dropdown
     * Click on the “BOOK” button
     * Validate the booking information displayed below
     * DEPART
     * IL to FL
     * {dynamic date}
     * Number of passengers: 1
     * Passenger 1: Senior (65+)
     * Cabin Class: Business
     */
    @Test
    public void validateOneWayTrip(){
        WebElement radioButton = driver.findElement(By.cssSelector(".mr-1:nth-child(1)"));
        radioButton.click();

        WebElement cabinClassDropdown = driver.findElement(By.cssSelector(".field:nth-child(2) option"));
        List <WebElement> dropdownClassOptions = driver.findElements(By.cssSelector(".field:nth-child(2) option "));
        DropdownHandler.clickDropdownOption(cabinClassDropdown, dropdownClassOptions, "Business");

        WebElement fromLabelDropdown = driver.findElement(By.cssSelector(".field:nth-child(3) option"));
        List<WebElement> fromLabelOptions = driver.findElements(By.cssSelector(".field:nth-child(3) option"));
        DropdownHandler.clickDropdownOption(fromLabelDropdown, fromLabelOptions, "Illinois");

        WebElement toDropdown = driver.findElement(By.cssSelector(".field:nth-child(4) option"));
        List<WebElement> toOptions = driver.findElements(By.cssSelector(".field:nth-child(4) option"));
        DropdownHandler.clickDropdownOption(toDropdown, toOptions, "Florida");

        WebElement datePicker1 = driver.findElement(By.cssSelector(".field:nth-child(5) .control"));
        datePicker1.click();
        WebElement month = driver.findElement(By.name(".field:nth-child(5) .control input[name=month]"));
        WebElement day = driver.findElement(By.name(".field:nth-child(5) .control input[name=day]"));
        WebElement year = driver.findElement(By.name(".field:nth-child(5) .control input[name=year]"));

        month.sendKeys("6");
        day.sendKeys("15");
        year.sendKeys("2023");

        year.sendKeys(Keys.ESCAPE);

        WebElement nrOfPassengersDropdown = driver.findElement(By.cssSelector(".field:nth-child(7) option"));
        DropdownHandler.selectByIndex(nrOfPassengersDropdown, 0);

        WebElement passengerDropdown = driver.findElement(By.cssSelector(".field:nth-child(8) option"));
        DropdownHandler.selectByVisibleText(passengerDropdown, "Senior (65+)");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();


        WebElement bookingInfo = driver.findElement(By.className(".ml-3"));
        Assert.assertTrue(bookingInfo.isDisplayed());
    }
}
