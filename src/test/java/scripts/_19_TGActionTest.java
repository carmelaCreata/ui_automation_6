package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _19_TGActionTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-15")).click();
        actions = new Actions(driver);
    }

    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
     * Perform a click action on the first web element labeled "Click on me"
     * Verify that a message appears next to the element stating, "You clicked on a button!"
     * Perform a right-click action on the second web element labeled "Right-Click on me"
     * Verify that the message appears next to the element stating, "You right-clicked on a button!"
     * Perform a double-click action on the third web element labeled "Double-Click on me"
     * Verify that the message appears next to the element stating, "You double-clicked on a button!"
     */
    @Test
    public void mouseActions(){
        WebElement clickOnMeButton = driver.findElement(By.id("click"));
        WebElement rightClickOnMe = driver.findElement(By.id("right-click"));
        WebElement doubleClickOnMe = driver.findElement(By.id("double-click"));

        actions.moveToElement(clickOnMeButton).click().perform();
        WebElement clickResult = driver.findElement(By.id("click_result"));
        Assert.assertEquals(clickResult.getText(), "You clicked on a button!");

        actions.moveToElement(rightClickOnMe).contextClick().perform();
        WebElement rightClickResult = driver.findElement(By.id("right_click_result"));
        Assert.assertEquals(rightClickResult.getText(), "You right-clicked on a button!");

        actions.moveToElement(doubleClickOnMe).doubleClick().perform();
        WebElement doubleClickResult = driver.findElement(By.id("double_click_result"));
        Assert.assertEquals(doubleClickResult.getText(), "You double-clicked on a button!");


    }
    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the web element stating, "An element dropped here!"
     */
    @Test
    public void dragAndDrop(){
        WebElement dragElement = driver.findElement(By.id("drag_element"));
        WebElement dropElement = driver.findElement(By.id("drop_element"));

        Assert.assertEquals(dragElement.getText(), "Drag Me");
        Assert.assertEquals(dropElement.getText(), "Drop Here");

        actions.dragAndDrop(dragElement, dropElement).perform();

        WebElement dragAndDropResult = driver.findElement(By.id("drag_and_drop_result"));

        Waiter.waitForVisibilityOfElement(dragAndDropResult, 30);
        Assert.assertEquals(dragAndDropResult.getText(), "An element dropped here!");
    }

}
