package lesson6;

import com.geekbrains.lesson6.*;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class PageObjectTests_les6 extends BaseTests {
    public final String BASE_URL = "https://crm.geekbrains.space/";
    ContactPage contactPage;
    MainPage mainPage;
    CreateNewProjectPage createNewProjectPage;
    AllProjectsPage allProjectsPage;

    @BeforeEach
    void initAndGoToPages() {
        contactPage = new ContactPage(driver);
        mainPage = new MainPage(driver);
        createNewProjectPage = new CreateNewProjectPage(driver);
        allProjectsPage = new AllProjectsPage(driver);
        driver.get(BASE_URL);
        loginPage.login("Applanatest1", "Student2020!");
    }

    @Test
    public void createNewContactTest() {
       mainPage.getContactPage();
        contactPage.getCreateNewContact();
        new CreateNewContact(driver)
                .fillSurnameField("SurnameTest")
                .fillFirstNameField("NameTest")
                .fillChoseCompanyField("Test_from_GB")
                .fillJobTitleField("Tester");
        createNewProjectPage.pushSaveAndCloseButton();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']")).isDisplayed());

    }

    @Test
    public void createNewProjectTest(){
    mainPage.getAllProjectsPage();
    allProjectsPage.getCreateNewProjectPage();
    createNewProjectPage.fillProjectNameField("testing_homework3")
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
    createNewProjectPage.fillConfigField("config_test")
            .pushSaveAndCloseButton();
        MatcherAssert.assertThat(driver.findElement(By.xpath("//[text()='Проект сохранен']")).isDisplayed(), equalTo(true));
    }

}
