package com.branstiterts.basic.pages;

import com.branstiterts.basic.objects.UserAccount;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by tbranstiter on 2/2/2017.
 */
public class CreateAccountPage extends BasePage {
    final static Logger logger = Logger.getLogger(CreateAccountPage.class);

    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Personal Information
    @FindBy(id = "id_gender1")
    private WebElement userGenderMale;

    @FindBy(id = "customer_firstname")
    private WebElement userFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement userLastName;

    @FindBy(id = "email")
    private WebElement userEmail;

    @FindBy(id = "passwd")
    private WebElement userPassword;

    @FindBy(id = "days")
    private WebElement userDOBDay;

    @FindBy(id = "months")
    private WebElement userDOBMonth;

    @FindBy(id = "years")
    private WebElement userDOBYear;

    // Address Information
    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postCode;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneNum;

    // Submit Button
    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;

    public AccountPage setPersonalInfoForm(UserAccount userAccount) {
        // Selects - Drop Downs
        Select dayDrop = new Select(userDOBDay);
        Select monthDrop = new Select(userDOBMonth);
        Select yearDrop = new Select(userDOBYear);
        Select stateDrop = new Select(state);

        // Personal Information
        logger.debug("Selecting gender");
        userGenderMale.click();
        logger.debug("Entering " + userAccount.getFirstName() + " as the users first name");
        userFirstName.sendKeys(userAccount.getFirstName());
        logger.debug("Entering " + userAccount.getLastName() + " as the users last name");
        userLastName.sendKeys(userAccount.getLastName());
        logger.debug("Entering " + userAccount.getEmail() + " as the users email address if it is NOT already there");
        if(!userEmail.getAttribute("value").equals(userAccount.getEmail())) userEmail.sendKeys(userAccount.getEmail());
        logger.debug("Entering the users password");
        userPassword.sendKeys(userAccount.getPassword());
        logger.debug("Setting the users birthday: " + userAccount.getDobMonth() + "/" + userAccount.getDobDay() + "/" + userAccount.getDobYear());
        dayDrop.selectByValue(userAccount.getDobDay());
        monthDrop.selectByValue(userAccount.getDobMonth());
        yearDrop.selectByValue(userAccount.getDobYear());

        // Address Information
        logger.debug("Entering " + userAccount.getFirstName() + " as the users first name for the address information");
        firstName.clear();
        firstName.sendKeys(userAccount.getFirstName());
        logger.debug("Entering " + userAccount.getLastName() + " as the users last name for the address information");
        lastName.clear();
        lastName.sendKeys(userAccount.getLastName());
        logger.debug("Entering " + userAccount.getAddress() + " as the users address");
        address1.sendKeys(userAccount.getAddress());
        logger.debug("Entering " + userAccount.getCity() + " as the users city");
        city.sendKeys(userAccount.getCity());
        logger.debug("Selecting " + userAccount.getState() + " as the users state");
        stateDrop.selectByVisibleText(userAccount.getState());
        logger.debug("Entering " + userAccount.getZipCode() + " as the users zip code");
        postCode.sendKeys(userAccount.getZipCode());
        logger.debug("Entering " + userAccount.getPhoneNumber() + " as the users mobile phone number");
        mobilePhoneNum.sendKeys(userAccount.getPhoneNumber());

        // Submit
        submitAccountButton.click();

        return PageFactory.initElements(driver, AccountPage.class);
    }
}
