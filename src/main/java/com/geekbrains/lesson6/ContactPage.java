package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends  BaseView{

    public By allContactButtonLocator = By.xpath("//h1[@class='oro-subtitle']");
    public By newContactIsSavedLocator = By.xpath("//[text()='Контактное лицо сохранено']");

    @FindBy (xpath = "//a[@title='Создать контактное лицо']")
    public WebElement createNewContactButton;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public CreateNewContact getCreateNewContact() {
        createNewContactButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                new CreateNewContact(driver).checkIfGetCreateNewContactPageLocator));
        return new CreateNewContact(driver);
    }
}
