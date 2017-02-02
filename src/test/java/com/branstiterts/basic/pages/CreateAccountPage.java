package com.branstiterts.basic.pages;

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

    public void setPersonalInfoForm() {
        Select dayDrop = new Select(userDOBDay);
        Select monthDrop = new Select(userDOBMonth);
        Select yearDrop = new Select(userDOBYear);

        userGenderMale.click();
        userFirstName.sendKeys("Tyler");
        userLastName.sendKeys("Branstiter");
        if(!userEmail.getText().equals("rektdingus@gmail.com")) userEmail.sendKeys("rektdingus@gmail.com");
        userPassword.sendKeys("Password1!");
        dayDrop.selectByValue("17");
        monthDrop.selectByValue("12");
        yearDrop.selectByValue("1989");
    }
}
