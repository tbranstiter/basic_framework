package com.branstiterts.basic.pages;

import com.branstiterts.basic.objects.UserAccount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by tbranstiter on 2/2/2017.
 */
public class CreateAccountPage {
    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public AccountPage setPersonalInfoForm(UserAccount userAccount) throws Exception {
        // Selects - Drop Downs
        Select dayDrop = new Select(userDOBDay);
        Select monthDrop = new Select(userDOBMonth);
        Select yearDrop = new Select(userDOBYear);
        Select stateDrop = new Select(state);

        // Personal Information
        userGenderMale.click();
        userFirstName.sendKeys(userAccount.getFirstName());
        userLastName.sendKeys(userAccount.getLastName());
        if(!userEmail.getAttribute("value").equals(userAccount.getEmail())) userEmail.sendKeys(userAccount.getEmail());
        userPassword.sendKeys(userAccount.getPassword());
        dayDrop.selectByValue(userAccount.getDobDay());
        monthDrop.selectByValue(userAccount.getDobMonth());
        yearDrop.selectByValue(userAccount.getDobYear());

        // Address Information
        firstName.clear();
        firstName.sendKeys(userAccount.getFirstName());
        lastName.clear();
        lastName.sendKeys(userAccount.getLastName());
        address1.sendKeys(userAccount.getAddress());
        city.sendKeys(userAccount.getCity());
        stateDrop.selectByVisibleText(userAccount.getState());
        postCode.sendKeys(userAccount.getZipCode());
        mobilePhoneNum.sendKeys(userAccount.getPhoneNumber());

        // Submit
        submitAccountButton.click();

        return PageFactory.initElements(driver, AccountPage.class);
    }
}
