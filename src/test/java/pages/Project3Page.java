package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Project3Page {

    public Project3Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[value='One way']")
    public WebElement radioButtonOneWay;

    @FindBy(css = "input[value='Round trip']")
    public WebElement radioButtonRoundTrip;

    @FindBy(className = "mr-1")
    WebElement radioButtonsInput;

    @FindBy(css = ".field:nth-child(2)")
    WebElement cabinClassLabel;

    @FindBy(css = ".field:nth-child(2) option")
    WebElement cabinClassDropdown;

    @FindBy(css = ".field:nth-child(3)")
    WebElement fromLabel;

    @FindBy(css = ".field:nth-child(3) option")
    WebElement fromDropdown;

    @FindBy(css = ".field:nth-child(4)")
    WebElement toLabel;

    @FindBy(css = ".field:nth-child(4) option")
    WebElement toDropdown;

    @FindBy(css = ".field:nth-child(5)")
    WebElement departLabel;

    @FindBy(css = ".field:nth-child(5) .control" )
    WebElement departDatePicker;

    @FindBy(css = ".field:nth-child(6)")
    WebElement returnLabel;

    @FindBy(css = ".field:nth-child(6) .control")
    WebElement returnDatePicker;

    @FindBy(css = ".field:nth-child(7)")
    WebElement nrOfPassengersLabel;

    @FindBy(css = ".field:nth-child(7) option")
    WebElement getNrOfPassengersDropdown;

    @FindBy(css = ".field:nth-child(8)")
    WebElement passengerLabel;

    @FindBy(css = ".field:nth-child(8) option")
    WebElement passengerDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;
}
