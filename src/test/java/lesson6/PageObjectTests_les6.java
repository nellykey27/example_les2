package lesson6;

import com.geekbrains.lesson6.ContactPage;
import com.geekbrains.lesson6.CreateNewContact;
import com.geekbrains.lesson6.CreateNewProjectPage;
import com.geekbrains.lesson6.MainPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;



public class PageObjectTests_les6 extends BaseTests {

    ContactPage contactPage = new ContactPage(driver);
    MainPage mainPage = new MainPage(driver);
    CreateNewProjectPage createNewProjectPage = new CreateNewProjectPage(driver);
    private static final String BASE_URL = "https://crm.geekbrains.space/";

    @BeforeEach
    public void goToPage() {

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
                .fillJobTitleField("Tester")
                .submitSaveAndCloseButton();
        Assertions.assertTrue(driver.findElement(new ContactPage(driver).newContactIsSavedLocator).isDisplayed());
    }

    @Test
    public void createNewProject(){
    mainPage.getAllProjectsPage();
    createNewProjectPage.fillProjectNameField("testing_homework3")
            .fillChoseCompanyFieldProject("Test_from_GB")
            .selectPriorityField();
    createNewProjectPage.selectFinanceSourceField();
    createNewProjectPage.selectBusinessUnitField();
    createNewProjectPage.selectCuratorField();
    createNewProjectPage.selectRpField();
    createNewProjectPage.selectManagerProjectField("Applanatest1 Applanatest1 Applanatest1");
    createNewProjectPage.selectMainContactProjectField("Lazareva Testname (Tester)");
    createNewProjectPage.fillIFramePlanningField("test");
    createNewProjectPage.fillIFrameRequirementsManagementField("test_requirements");
    createNewProjectPage.fillIFrameDevelopmentField("test_development");
    createNewProjectPage.fillIFrameTestingField("test_testing");
    createNewProjectPage.fillConfigField("config_test")
            .pushSaveAndCloseButton();
    }

}
