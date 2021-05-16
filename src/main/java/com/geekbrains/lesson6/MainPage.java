package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseView{
    public NavigationMenu navigationMenu;
    public MainPage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }
    @FindBy(xpath = "//a[@title='Geekbrains']")
    public WebElement geekBrainsHomeButton;

    public By geekBrainsHomeButtonLocator = By.xpath("//a[@title='Geekbrains']");

    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement allContacts;

    public ContactPage getContactPage (){
        allContacts.click();
         webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new ContactPage(driver).allContactButtonLocator));
         return new ContactPage(driver);
    }

    @FindBy(xpath = "//span[text()='Проекты']/ancestor::a")
    public WebElement projects;

    @FindBy(xpath = "//span[contains(text(),'Все проекты')]")
    public WebElement allProjects;

    public AllProjectsPage getAllProjectsPage(){
        allProjects.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new AllProjectsPage(driver).createNewProjectButtonLocator));
        return new AllProjectsPage(driver);
    }



}
