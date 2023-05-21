package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _03_TGLocatorsTest {


    public static WebDriver driver; //declaration

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup(); //initialization

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://techglobal-training.netlify.app/frontend/locators");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void validateKiwiProgram(){

        WebElement kiwi = driver.findElement(By.id("item_kiwi"));
        Assert.assertTrue(kiwi.isDisplayed());

    }
}
