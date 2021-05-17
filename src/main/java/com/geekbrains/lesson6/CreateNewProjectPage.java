package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateNewProjectPage extends BaseView {
    public CreateNewProjectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public By youAreAtCreateNewProjectPageLocator = By.xpath("//button[@class='btn btn-success action-button']");

    @FindBy(xpath = "//input[@data-ftid='crm_project_name']")
    public WebElement projectNameField;
    public By projectNameFieldLocator = By.xpath("//input[@data-ftid='crm_project_name']");
    public CreateNewProjectPage fillProjectNameField(String nameField){
        projectNameField.sendKeys(nameField);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                new CreateNewProjectPage(driver).projectNameFieldLocator));
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
    public By priorityFieldLocator = By.name("crm_project[priority]");
    @FindBy(xpath = "//select[@data-ftid='crm_project_priority']/option[@value='1']")
    public WebElement priorityFieldSelected;
    public void selectPriorityField(){
        priorityField.click();
        priorityFieldSelected.click();
    }

    @FindBy(name = "crm_project[financeSource]")
    public WebElement financeSourceField;
    public By financeSourceFieldLocator = By.name("crm_project[financeSource]");
    @FindBy(xpath = "//select[@data-ftid='crm_project_financeSource'] /option[@value='1']")
    public WebElement financeSourceFieldSelected;
    public void selectFinanceSourceField(){
        financeSourceField.click();
        financeSourceFieldSelected.click();
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitField;
    public By businessUnitFieldLocator = By.name("crm_project[businessUnit]");
    @FindBy(xpath = "//select[@data-ftid='crm_project_businessUnit'] /option[@value='1']")
    public WebElement businessUnitFieldSelected;
    public void selectBusinessUnitField(){
        businessUnitField.click();
        businessUnitFieldSelected.click();
    }
    @FindBy(name = "crm_project[curator]")
    public WebElement curatorField;
    public By curatorFieldLocator = By.name("crm_project[curator]");
    @FindBy(xpath = "//select[@data-ftid='crm_project_curator'] /option[@value='116']")
    public WebElement curatorFieldSelected;
    public void selectCuratorField(){
        curatorField.click();
        curatorFieldSelected.click();
    }
    @FindBy(name = "crm_project[rp]")
    public WebElement rpField;
    public By rpFieldLocator = By.name("crm_project[rp]");
    @FindBy(xpath = "//select[@data-ftid='crm_project_rp'] /option[@value='116']")
    public WebElement rpFieldSelected;
    public void selectRpField(){
        rpField.click();
        rpFieldSelected.click();
    }
    @FindBy(name = "crm_project[manager]")
    public WebElement managerProjectField;
    public By managerProjectFieldLocator = By.name("crm_project[manager]");
    @FindBy(xpath = "//select[@data-ftid='crm_project_manager'] /option[@value='116']")
    public WebElement managerProjectFieldSelected;
    public void selectManagerProjectField(String managerName){
        managerProjectField.click();
        managerProjectFieldSelected.click();
    }

    @FindBy(xpath = "//div[contains(@id, 's2id_crm_project_contactMain')]/a")
    public WebElement mainContactProjectField;
    @FindBy(xpath = "//input[@Class='select2-input select2-focused']")
    public WebElement mainContactProjectFieldFocused;
    public By mainContactProjectFieldFocusedLocator = By.xpath("//input[@Class='select2-input select2-focused']");
    public By choseMainContactProjectFieldLocator = By.xpath("//ul[@Class='select2-results']//span[@class='select2-match']");

    public CreateNewProjectPage selectMainContactProjectField(String mainContactProjectName){
        mainContactProjectField.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(mainContactProjectFieldFocusedLocator));
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
        return new CreateNewProjectPage(driver);
    }
    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveAndCloseButton;


    public AllProjectsPage pushSaveAndCloseButton(){
        saveAndCloseButton.click();
        return new AllProjectsPage(driver);
    }
}
