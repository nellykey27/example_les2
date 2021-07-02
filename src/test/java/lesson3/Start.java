package lesson3;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class homework3 {

    private static WebDriver driver;
    private static String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";


    public static void main(String[] args) throws InterruptedException {

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  createProject();

    driver.quit();

    }
    private static void createContactPerson() throws InterruptedException {
        login();
        driver.get("https://crm.geekbrains.space/contact/");
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("SurnameTest");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("NameTest");

        Thread.sleep(5000);
        Select contactCompany = new Select(driver.findElement(By.name("crm_contact[company]")));
        contactCompany.selectByVisibleText("1234");

        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Tester");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Контактное " +
                "лицо сохранено']")));

    }
    private static void createProject() throws InterruptedException {
        login();
        Actions actions = new Actions(driver);
        WebElement projectMenuItem = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
        actions.moveToElement(projectMenuItem).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_project_my']/a")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();

        driver.findElement(By.xpath("//input[@class='select2-input" +
                " select2-focused']")).sendKeys("Test_from_GB");

        driver.findElement(By.xpath("//input[@class='select2-input " +
                "select2-focused']")).sendKeys(Keys.ENTER);

        //crm_project[contactMain]
        //Select selectContact = new Select(driver.findElement(By.name("crm_project[contactMain]")));
        //selectContact.selectByVisibleText("Ivanov Ivan");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@id,'s2id_crm_project_contactMain')]/a")).click();
        driver.findElement(By.xpath("//select[@name=\"crm_project[contactMain]\"]/option[3]")).click();

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
        WebDriverWait webDriverWait1 = new WebDriverWait(driver, 5);
        webDriverWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));


        Thread.sleep(5000);

    }
    private static void login(){
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

    }
}
