package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateNewContact extends BaseView{
    NavigationMenu navigationMenu;
    public CreateNewContact(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }

    public By checkIfGetCreateNewContactPageLocator = By.xpath("//a[text()='Контактные лица']");

    @FindBy (name = "crm_contact[lastName]")
    public WebElement surnameField;

    public CreateNewContact fillSurnameField(String surname) {
        surnameField.sendKeys(surname);
        return new CreateNewContact(driver);
    }

    @FindBy (name = "crm_contact[firstName]")
    public WebElement firstNameField;

    public CreateNewContact fillFirstNameField(String firstName) {
        surnameField.sendKeys(firstName);
        return new CreateNewContact(driver);
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']/..")
    public WebElement choseCompany;

    @FindBy(xpath = "//input[@Class='select2-input select2-focused']")
    public WebElement choseCompanyFocused;

    public By choseCompanySelectMatch = By.xpath("//ul[@Class='select2-results']//span[@Class='select2-match']");

    public CreateNewContact fillChoseCompanyField(String nameCompany){
        choseCompany.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(choseCompanyFocused));
        choseCompanyFocused.sendKeys(nameCompany);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(choseCompanySelectMatch));
        driver.findElement(choseCompanySelectMatch).click();
        return new CreateNewContact(driver);
    }

    @FindBy (name = "crm_contact[jobTitle]")
    public WebElement jobTitleField;

    public CreateNewContact fillJobTitleField(String jobTitle) {
        jobTitleField.sendKeys(jobTitle);
        return new CreateNewContact(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    public ContactPage submitSaveAndCloseButton(){
        saveAndCloseButton.click();
        return new ContactPage(driver);
    }


}
