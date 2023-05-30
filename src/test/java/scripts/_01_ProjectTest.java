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

    /** TEST CASE 1
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

    @Test(priority = 1)
    public void validateContactUsInfo() {

        WebElement header = driver.findElement(By.cssSelector(".is-size-2"));
        Assert.assertTrue(header.isDisplayed());
        Assert.assertEquals(header.getText(), "Contact Us");

        List<WebElement> headers = driver.findElements(By.cssSelector("div[class='mb-5'] p"));

        String[] expectedTexts ={"2860 S River Rd Suite 350, Des Plaines IL 60018", "info@techglobalschool.com","(773) 257-3010"};

        for (int i = 0; i < headers.size(); i++) {
            Assert.assertTrue(headers.get(i).isDisplayed());
            Assert.assertEquals(headers.get(i).getText(),expectedTexts[i]);
        }
    }

    /** TEST CASE 2
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Full name input box is displayed
     * Validate that the Full name input box is required
     * Validate that the label of the Full name input box is “Full name”
     * Validate that the placeholder of the Full name input box is “Enter your name”
     */

    @Test(priority = 2)
    public void validateFullNameInput(){
        WebElement fullNameInputBox = driver.findElement(By.xpath("//input[@placeholder=\"Enter your full name\"]"));
        WebElement fullNameLabel = driver.findElement(By.cssSelector("label[for='name']"));

        Assert.assertTrue(fullNameInputBox.isDisplayed());
        Assert.assertEquals(fullNameInputBox.getAttribute("required"), "true");
        Assert.assertEquals(fullNameLabel.getText(), "Full name *");
        Assert.assertEquals(fullNameInputBox.getAttribute("placeholder"), "Enter your full name");
    }

    /** TEST CASE 3
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the label is “Gender”
     * Validate that the Gender is required
     * Validate the options are “Female”, “Male” and “Prefer not to disclose”
     * Validate the options are clickable and not selected
     * Click on the “Male” option and validate it is selected while the others are not selected
     * Click on the “Female” option and validate it is selected while the others are not selected
     */

    @Test(priority = 3)
    public void validateGenderInput() {
        WebElement genderLabel = driver.findElement(By.cssSelector("div:nth-of-type(2)>div>label:first-of-type")); //???
        List<WebElement> genderOptions = driver.findElements(By.cssSelector("div[class='field'] label.radio"));
        List<WebElement> genderInput = driver.findElements(By.cssSelector(".mr-1"));

        Assert.assertEquals(genderLabel.getText(), "Gender *");
        Assert.assertTrue(Boolean.parseBoolean(genderLabel.getAttribute("required")));

        String[] expectedText = {"Male", "Female", "Prefer not to disclose"};

        for (int i = 0; i < genderOptions.size(); i++) {
            Assert.assertEquals(genderOptions.get(i).getText(), expectedText[i]);
            Assert.assertTrue(genderOptions.get(i).isDisplayed());
            Assert.assertTrue(genderInput.get(i).isEnabled());
            Assert.assertFalse(genderInput.get(i).isSelected());
        }

        for (int i = 0; i < genderInput.size(); i++) {
            if (i == 0) continue;
            Assert.assertFalse(genderInput.get(i).isSelected());
        }

        for (int i = 0; i < genderInput.size(); i++) {
            if (i == 1) continue;
            Assert.assertFalse(genderInput.get(i).isSelected());
        }
    }
        /** TEST CASE 4
         * Navigate to https://techglobal-training.com/frontend/project-1
         * Validate that the Address input box is displayed
         * Validate that the Address input box is not required
         * Validate that the label of the Address input box is “Address”
         * Validate that the placeholder of the Address input box is “Enter your address*”
         */

        @Test(priority = 4)
        public void validateAddressInputBox(){
            WebElement addressInputBox = driver.findElement(By.xpath("//input[contains(@placeholder,'Enter your address')]"));
            WebElement addressInputLabel = driver.findElement(By.xpath("//div[@class='field'][3]//label"));

            Assert.assertTrue(addressInputBox.isDisplayed());
            Assert.assertFalse(Boolean.parseBoolean(addressInputBox.getAttribute("required")));
            Assert.assertEquals(addressInputLabel.getText(), "Address");
            Assert.assertEquals(addressInputBox.getAttribute("placeholder"), "Enter your address");
        }

    /** TEST CASE 5
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Email input box is displayed
     * Validate that the Email input box is required
     * Validate that the label of the Email input box is “Email”
     * Validate that the placeholder of the Email input box is “Enter your email”
     */

    @Test(priority = 5)
    public void validateEmailInputBox(){
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@placeholder='Enter your email']"));
        WebElement emailLabel = driver.findElement(By.xpath("//div[@class='field'][4]//label"));

        Assert.assertTrue(emailInputBox.isDisplayed());
        Assert.assertTrue(Boolean.parseBoolean(emailInputBox.getAttribute("required")));
        Assert.assertEquals(emailLabel.getText(), "Email *");
        Assert.assertEquals(emailInputBox.getAttribute("placeholder"), "Enter your email");
    }

    /** TEST CASE 6
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Phone input box is displayed
     * Validate that the Phone input box is not required
     * Validate that the label of the Phone input box is “Phone”
     * Validate that the placeholder of the Address input box is “Enter your phone number”
     */

    @Test(priority = 6)
    public void validatePhoneInputBox(){
        WebElement phoneInputBox = driver.findElement(By.cssSelector("input[type*='phone']"));
        WebElement phoneLabel = driver.findElement(By.xpath("//div[@class='field'][5]//label"));

        Assert.assertTrue(phoneInputBox.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(phoneInputBox.getAttribute("required")));
        Assert.assertEquals(phoneLabel.getText(), "Phone");
        Assert.assertEquals(phoneInputBox.getAttribute("placeholder"), "Enter your phone number");
    }

    /** TEST CASE 7
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Message text area is displayed
     * Validate that the Message text area is not required
     * Validate that the label of the Message text area is “Message”
     * Validate that the placeholder of the Message text area is “Type your message here…”
     */

    @Test(priority = 7)
    public void validateMessageTextArea(){
        WebElement textArea = driver.findElement(By.cssSelector(".textarea"));
        WebElement textAreaLabel = driver.findElement(By.xpath("//div[@class='field'][6]//label"));

        Assert.assertTrue(textArea.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(textArea.getAttribute("required")));
        Assert.assertEquals(textAreaLabel.getText(), "Message");
        Assert.assertEquals(textArea.getAttribute("placeholder"), "Type your message here...");
    }

    /** TEST CASE 8
     *  Navigate to https://techglobal-training.com/frontend/project-1
     *  Validate the label is “I give my consent to be contacted.”
     *  Validate that the Consent checkbox is required
     *  Validate that the Consent checkbox is clickable
     *  Click on the “I give my consent to be contacted.” checkbox and validate it is selected
     *  Click on the “I give my consent to be contacted.” checkbox again and validate it is not selected
     *
     */

    @Test(priority = 8)
    public void validateConsentCheckbox(){
        WebElement consentLabel = driver.findElement(By.xpath("//div[@class='field'][7]//label"));
        WebElement consentCheckbox = driver.findElement(By.cssSelector("input[type=\"checkbox\"]"));

        Assert.assertEquals(consentLabel.getText(), "I give my consent to be contacted.");
        Assert.assertTrue(Boolean.parseBoolean(consentCheckbox.getAttribute("required")));

        Assert.assertTrue(consentCheckbox.isEnabled());
        consentCheckbox.click();
        Assert.assertTrue(consentCheckbox.isSelected());
        consentCheckbox.click();
        Assert.assertFalse(consentCheckbox.isSelected());

    }
    /** TEST CASE 9
     * Navigate to https://techglobal-training.com/frontend/project-1
     *     Validate the “SUBMIT” button is displayed
     *     Validate the “SUBMIT” button is clickable
     *     Validate that the button text is “SUBMIT”
     */

    @Test
    public void validateSubmitButton(){
        WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));

        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(), "SUBMIT");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Enter a first name
     * Select a gender
     * Enter an address
     * Enter an email
     * Enter a phone number
     * Enter a message
     * Select the “I give my consent to be contacted.” checkbox
     * Click on the “SUBMIT” button
     * Validate the form message “Thanks for submitting!” is displayed under the “SUBMIT” button
     */

    @Test
    public void validateFormSubmission(){
        WebElement fullNameInputBox = driver.findElement(By.xpath("//input[@placeholder=\"Enter your full name\"]"));
        List<WebElement> genderInput = driver.findElements(By.cssSelector(".mr-1"));
        WebElement addressInputBox = driver.findElement(By.xpath("//input[contains(@placeholder,'Enter your address')]"));
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@placeholder='Enter your email']"));
        WebElement phoneInputBox = driver.findElement(By.cssSelector("input[type*='phone']"));
        WebElement textArea = driver.findElement(By.cssSelector(".textarea"));
        WebElement consentCheckbox = driver.findElement(By.cssSelector("input[type=\"checkbox\"]"));
        WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));

        fullNameInputBox.sendKeys("Carmela Creata");
        genderInput.get(1).click();
        addressInputBox.sendKeys("123 Chicago Ave");
        emailInputBox.sendKeys("creata.carmela@yahoo.com");
        phoneInputBox.sendKeys("8723018435");
        textArea.sendKeys("sup");
        consentCheckbox.click();
        submitButton.submit();

        WebElement formMessage = driver.findElement(By.cssSelector(".mt-5"));

        Assert.assertTrue(formMessage.isDisplayed());
        Assert.assertEquals(formMessage.getText(), "Thanks for submitting!");



    }






}




