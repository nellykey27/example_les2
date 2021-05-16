package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllProjectsPage extends BaseView{
    public AllProjectsPage(WebDriver driver) {
        super(driver);
    }
    public By createNewProjectButtonLocator = By.xpath("//a[@title='Создать проект']");
    public By ifProjectIsSavedLocator = By.xpath("//*[text()='Проект сохранен']");

    public CreateNewProjectPage getCreateNewProjectPage(){
        driver.findElement(createNewProjectButtonLocator).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                new CreateNewProjectPage(driver).youAreAtCreateNewProjectPageLocator));
        return new CreateNewProjectPage(driver);
    }

}
