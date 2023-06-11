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
    public WebElement radioButtonsInput;

    @FindBy(css = ".field:nth-child(2)")
    public WebElement cabinClassLabel;

    @FindBy(css = ".field:nth-child(2) option")
    public WebElement cabinClassDropdown;

    @FindBy(css = ".field:nth-child(3)")
    public WebElement fromLabel;

    @FindBy(css = ".field:nth-child(3) option")
    public WebElement fromDropdown;

    @FindBy(css = ".field:nth-child(4)")
    public WebElement toLabel;

    @FindBy(css = ".field:nth-child(4) option")
    public WebElement toDropdown;

    @FindBy(css = ".field:nth-child(5)")
    public WebElement departLabel;

    @FindBy(css = ".field:nth-child(5) .control" )
    public WebElement departDatePicker;

    @FindBy(css = ".field:nth-child(6)")
    public WebElement returnLabel;

    @FindBy(css = ".field:nth-child(6) .control")
    public WebElement returnDatePicker;

    @FindBy(css = ".field:nth-child(7)")
    public WebElement nrOfPassengersLabel;

    @FindBy(css = ".field:nth-child(7) option")
    public WebElement getNrOfPassengersDropdown;

    @FindBy(css = ".field:nth-child(8)")
    public WebElement passengerLabel;

    @FindBy(css = ".field:nth-child(8) option")
    public WebElement passengerDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;
}
