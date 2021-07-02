package lesson6;

import com.geekbrains.lesson6.*;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class PageObjectTests_les6 extends lesson6.BaseTests {
    public final String BASE_URL = "https://crm.geekbrains.space/";
    com.geekbrains.lesson6.ContactPage contactPage;
    com.geekbrains.lesson6.MainPage mainPage;
    com.geekbrains.lesson6.CreateNewProjectPage createNewProjectPage;
    com.geekbrains.lesson6.AllProjectsPage allProjectsPage;
    com.geekbrains.lesson6.CreateNewContact createNewContact;

    @BeforeEach
    void initAndGoToPages() {
        contactPage = new com.geekbrains.lesson6.ContactPage(driver);
        mainPage = new com.geekbrains.lesson6.MainPage(driver);
        createNewProjectPage = new com.geekbrains.lesson6.CreateNewProjectPage(driver);
        allProjectsPage = new com.geekbrains.lesson6.AllProjectsPage(driver);
        createNewContact = new com.geekbrains.lesson6.CreateNewContact(driver);
        driver.get(BASE_URL);
        loginPage.login("Applanatest1", "Student2020!");
    }

    @Test
    public void createNewContactTest() throws InterruptedException {
       mainPage.getContactPage();
        contactPage.getCreateNewContact();
        new com.geekbrains.lesson6.CreateNewContact(driver)
                .fillSurnameField("SurnameTest")
                .fillFirstNameField("NameTest")
                .fillChoseCompanyField("Test_from_GB")
                .fillJobTitleField("Tester");
        createNewContact.submitSaveAndCloseButton();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']")).isDisplayed());

    }

    @Test
    public void createNewProjectTest(){
    mainPage.getAllProjectsPage();
    allProjectsPage.getCreateNewProjectPage();
    createNewProjectPage.fillProjectNameField("testing_homework3_1")
            .fillChoseCompanyFieldProject("Test_from_GB")
            .selectPriorityField();
    createNewProjectPage.selectFinanceSourceField();
    createNewProjectPage.selectBusinessUnitField();
    createNewProjectPage.selectCuratorField();
    createNewProjectPage.selectRpField();
    createNewProjectPage.selectManagerProjectField("Applanatest1 Applanatest1 Applanatest1");
//    createNewProjectPage.selectMainContactProjectField("Lazareva Testname (Tester)");
    createNewProjectPage.fillIFramePlanningField("test");
    createNewProjectPage.fillIFrameRequirementsManagementField("test_requirements");
    createNewProjectPage.fillIFrameDevelopmentField("test_development");
    createNewProjectPage.fillIFrameTestingField("test_testing");
    createNewProjectPage.fillConfigField("config_test");
    createNewProjectPage.pushSaveAndCloseButton();
        MatcherAssert.assertThat(driver.findElement(
                By.xpath("//*[text()='Проект сохранен']")).isDisplayed(),equalTo(true) );
    }

}
