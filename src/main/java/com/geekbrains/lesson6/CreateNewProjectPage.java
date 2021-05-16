package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CreateNewProjectPage extends BaseView {
    public CreateNewProjectPage(WebDriver driver) {
        super(driver);
    }

    public By youAreAtCreateNewProjectPageLocator = By.xpath("//h1[contains(text(),'Создать проект')]");

    @FindBy(name = "crm_project[name]")
    public WebElement projectNameField;
    public CreateNewProjectPage fillProjectNameField(String nameField){
        projectNameField.sendKeys(nameField);
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(projectNameField, nameField));
        return new CreateNewProjectPage(driver);
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']/..")
    public WebElement choseCompanyProject;

    @FindBy(xpath = "//input[@Class='select2-input select2-focused']")
    public WebElement choseCompanyFocusedProject;

    public By choseCompanySelectMatchProject = By.xpath("//ul[@Class='select2-results']//span[@Class='select2-match']");

    public CreateNewProjectPage fillChoseCompanyFieldProject(String nameCompany){
        choseCompanyProject.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(choseCompanyFocusedProject));
        choseCompanyFocusedProject.sendKeys(nameCompany);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(choseCompanySelectMatchProject));
        driver.findElement(choseCompanySelectMatchProject).click();
        return new CreateNewProjectPage(driver);
    }

    @FindBy(name = "crm_project[priority]")
    public WebElement priorityField;
    public void selectPriorityField(){
        new Select(priorityField).getFirstSelectedOption();
        webDriverWait.until(ExpectedConditions.elementToBeSelected(priorityField));
    }
    @FindBy(name = "crm_project[financeSource]")
    public WebElement financeSourceField;
    public void selectFinanceSourceField(){
        new Select(financeSourceField).getFirstSelectedOption();
        webDriverWait.until(ExpectedConditions.elementToBeSelected(financeSourceField));
    }
    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitField;
    public void selectBusinessUnitField(){
        new Select(businessUnitField).getFirstSelectedOption();
        webDriverWait.until(ExpectedConditions.elementToBeSelected(businessUnitField));
    }
    @FindBy(name = "crm_project[curator]")
    public WebElement curatorField;
    public void selectCuratorField(){
        new Select(curatorField).getFirstSelectedOption();
        webDriverWait.until(ExpectedConditions.elementToBeSelected(curatorField));
    }
    @FindBy(name = "crm_project[rp]")
    public WebElement rpField;
    public void selectRpField(){
        new Select(rpField).getFirstSelectedOption();
        webDriverWait.until(ExpectedConditions.elementToBeSelected(rpField));
    }
    @FindBy(name = "crm_project[manager]")
    public WebElement managerProjectField;
    public void selectManagerProjectField(String managerName){
        new Select(managerProjectField).selectByVisibleText(managerName);
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(managerProjectField, managerName));
    }

    @FindBy(xpath = "//div[contains(@id, 's2id_crm_project_contactMain')]/a")
    public WebElement mainContactProjectField;
    @FindBy(xpath = "//input[@Class='select2-input select2-focused']")
    public WebElement mainContactProjectFieldFocused;
    public By choseMainContactProjectFieldLocator = By.xpath("//ul[@Class='select2-results']//span[@class='select2-match']");

    public CreateNewProjectPage selectMainContactProjectField(String mainContactProjectName){
        mainContactProjectField.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(mainContactProjectFieldFocused));
        mainContactProjectFieldFocused.sendKeys(mainContactProjectName);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(choseMainContactProjectFieldLocator));
        driver.findElement(choseMainContactProjectFieldLocator).click();
        return new CreateNewProjectPage(driver);
    }

    @FindBy(xpath = "//iframe[contains(@id, 'planning')]")
    public WebElement iFramePlanningField;

    public By bodyLocator = By.xpath("//body");

    public void fillIFramePlanningField(String descriptionPlanning){
        driver.switchTo().frame(iFramePlanningField).findElement(bodyLocator).sendKeys(descriptionPlanning);
        driver.switchTo().defaultContent();
    }

    @FindBy(xpath = "//iframe[contains(@id, 'crm_project_requirementsManagement')]")
    public WebElement iFrameRequirementsManagementField;

    public void fillIFrameRequirementsManagementField(String descriptionRequirements){
        driver.switchTo().frame(iFrameRequirementsManagementField).findElement(bodyLocator).sendKeys(descriptionRequirements);
        driver.switchTo().defaultContent();
    }

    @FindBy(xpath = "//iframe[contains(@id,'crm_project_development')]")
    public WebElement iFrameDevelopmentField;

    public void fillIFrameDevelopmentField(String descriptionDevelopment){
        driver.switchTo().frame(iFrameDevelopmentField).findElement(bodyLocator).sendKeys(descriptionDevelopment);
        driver.switchTo().defaultContent();
    }
    @FindBy(xpath = "//iframe[contains(@id, 'crm_project_testing')]")
    public WebElement iFrameTestingField;

    public void fillIFrameTestingField(String descriptionTesting){
        driver.switchTo().frame(iFrameTestingField).findElement(bodyLocator).sendKeys(descriptionTesting);
        driver.switchTo().defaultContent();
    }

    @FindBy(name = "crm_project[configManagement]")
    public WebElement configField;
    public CreateNewProjectPage fillConfigField(String descriptionConfigField){
        configField.sendKeys(descriptionConfigField);
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(configField, descriptionConfigField));
        return new CreateNewProjectPage(driver);
    }
    @FindBy(xpath = "//button[contains(@data-action,'{\"route\":\"crm_project_index\"}')]")
    public WebElement saveAndCloseButton;


    public AllProjectsPage pushSaveAndCloseButton(){
        saveAndCloseButton.click();
        assertThat(driver.findElement(By.xpath("//[text()='Проект сохранен']")).isDisplayed(), equalTo(true));
        return new AllProjectsPage(driver);
    }
}
