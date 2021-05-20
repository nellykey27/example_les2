package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//span[text()='Контрагенты']")
    public WebElement allCompanies;

    public By allCompaniesLocator = By.xpath("//span[text()='Контрагенты']/..");

    public ContactPage getContactPage (){
        allCompanies.click();
        allContacts.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new ContactPage(driver).allContactButtonLocator));
        return new ContactPage(driver);
    }

    @FindBy(xpath = "//span[text()='Проекты']/ancestor::a")
    public WebElement projects;

    @FindBy(xpath = "//span[contains(text(),'Все проекты')]/ancestor::a")
    public WebElement allProjects;

    public AllProjectsPage getAllProjectsPage() {
        new Actions(driver).moveToElement(projects).click(allProjects).build().perform();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new AllProjectsPage(driver).createNewProjectButtonLocator));
        return new AllProjectsPage(driver);
    }



}
