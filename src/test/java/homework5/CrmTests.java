package homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CrmTests {
    WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://crm.geekbrains.space/";

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 7);
        driver.get(BASE_URL);
        login();
    }
        @Test
        @DisplayName("Создание контакта")
        public void createContactPerson() throws InterruptedException {
        Actions actions = new Actions(driver);
            driver.get("https://crm.geekbrains.space/contact/");

            driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_contact[firstName]")));

            driver.findElement(By.name("crm_contact[lastName]")).sendKeys("SurnameTest");
            driver.findElement(By.name("crm_contact[firstName]")).sendKeys("NameTest");

        //    driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
        //   webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='select2-input select2-focused']")));
        //    driver.findElement(By.xpath("//input[@class='select2-input" +
        //            " select2-focused']")).sendKeys("1234");
        //    driver.findElement(By.xpath("//input[@class='select2-input select2-active']")).sendKeys(Keys.ENTER);

            actions.click(driver.findElement(By.xpath("//a[@class='select2-choice select2-default']")))
//                    .sendKeys(driver.findElement(By.xpath("//input[@class='select2-input']")), "1234")
                    .click(driver.findElement(By.xpath("//*[@id='select2-drop']/ul[2]/li[1]")))
                    .build()
                    .perform();

            Thread.sleep(5000);
         //   webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='select2-input select2-focused']")));

         //   webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='select2-input']")));
         //   driver.findElement(By.xpath("//div[@class='select2-search']")).sendKeys();
         //   webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='select2-input select2-focused']")));
        //  Assumptions.assumeTrue("//span[@class='select2-chosen']".contains("Укажите организацию"));
         //   driver.findElement(By.xpath("//ul[@class='select2-results']/li[3]/div")).click();

            driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Tester");
            webDriverWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.name("crm_contact[jobTitle]")), "Tester"));

            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Сохранить и закрыть') and @type='submit']")));
            driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

            webDriverWait.until(driver -> driver.findElement(By.xpath("//*[text()='Контактное " +
                    "лицо сохранено']" +
                    "")));
        }

        @Test
        @DisplayName("Создание проекта")
        public void createProject() throws InterruptedException {
            driver.get(BASE_URL);
            Actions actions = new Actions(driver);
            WebElement projectMenuItem = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
            actions.moveToElement(projectMenuItem).perform();

            driver.findElement(By.xpath("//li[@data-route='crm_project_my']/a")).click();

           webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Создать проект']")));

            driver.findElement(By.xpath("//a[@title='Создать проект']")).click();

            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Создать проект')]")));

           driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
           driver.findElement(By.xpath("//input[@class='select2-input']")).click();
           driver.findElement(By.xpath("//input[@class='select2-input']")).sendKeys("Test_from_GB");
           webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='select2-results']//span[@class='select2-match']")));
           driver.findElement(By.xpath("//ul[@class='select2-results']//span[@class='select2-match']")).click();
            webDriverWait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@class='select2-input select2-focused']")));
            driver.findElement(By.xpath("//div[contains(@id,'s2id_crm_project_contactMain')]/a")).click();
            driver.findElement(By.xpath("//select[@name='crm_project[contactMain]']/option[3]")).click();

            driver.findElement(By.xpath("//input[@name='crm_project[type]' and contains(@data-name, " +
                    "'field__1')]")).click();

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'planning')]")));
            driver.findElement(By.xpath("//body")).sendKeys("test");

            driver.switchTo().defaultContent();

            driver.findElement(By.name("crm_project[name]")).sendKeys("test");

            Select selectPriority = new Select(driver.findElement(By.name("crm_project[priority]")));
            selectPriority.getFirstSelectedOption();

            Select selectFinanceSource = new Select(driver.findElement(By.name("crm_project[financeSource]")));
            selectFinanceSource.getFirstSelectedOption();

            Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
            selectBusinessUnit.getFirstSelectedOption();

            Select selectProjectCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
            selectProjectCurator.getFirstSelectedOption();

            Select selectProjectManager = new Select(driver.findElement(By.name("crm_project[rp]")));
            selectProjectManager.getFirstSelectedOption();

            Select selectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
            selectManager.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

            driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain')]/a")).click();
            driver.findElement(By.xpath("//select[@data-name='field__contacts']/option[5]")).click();

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, " +
                    "'crm_project_requirementsManagement')]")));
            driver.findElement(By.xpath("//body")).sendKeys("test_requirements");
            driver.switchTo().defaultContent();

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, " +
                    "'crm_project_development')]")));
            driver.findElement(By.xpath("//body")).sendKeys("test_development");
            driver.switchTo().defaultContent();

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, " +
                    "'crm_project_testing')]")));
            driver.findElement(By.xpath("//body")).sendKeys("test_testing");
            driver.switchTo().defaultContent();

            driver.findElement(By.name("crm_project" +
                    "[configManagement]")).sendKeys("Config_testing");

            driver.findElement(By.name("crm_project[name]")).sendKeys("testing_homework3");

            driver.findElement(By.xpath("//button[contains(@data-action," +
                    " '\"route\":\"crm_project_index\"')]")).click();

            //Проверка
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));


            Thread.sleep(5000);
        }

        @AfterEach
        void closeBrowser () {
            driver.quit();
        }


        private void login () {
    //   Cookie cookie = new Cookie("BAPID", "c911e591cf50caf71482cf2152ae0182");
    //   driver.manage().addCookie(cookie);
    //  driver.navigate().refresh();

        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
        }



}
