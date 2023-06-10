package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class DatePicker extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.netlify.app/frontend");
        driver.findElement(By.id("card-20"));
        actions = new Actions(driver);
    }



    @Test
    public void validateDateExample(){
        WebElement month = driver.findElement(By.name("month"));
        WebElement day = driver.findElement(By.name("day"));
        WebElement year = driver.findElement(By.name("year"));

        month.sendKeys("10");
        day.sendKeys("22");
        year.sendKeys("2026");

        year.sendKeys(Keys.ESCAPE);

        Waiter.pause(3);
    }
}
