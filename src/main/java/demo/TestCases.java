package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;
    boolean status;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {

        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        waits.until(ExpectedConditions.urlContains("leetcode"));
        System.out.println("The URL is correct");
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        WebElement QuestionBtn = driver.findElement(By.xpath("//a[@href='/problemset/']"));
        QuestionBtn.click();
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        waits.until(ExpectedConditions.urlContains("problemset"));
        String url = driver.getCurrentUrl();
        status = url.contains("problemset");
        if (status == true) {
            System.out.println("The Problems Set Page is Opened");
        } else {
            System.out.println("Failed To Open Problem Set Page");
        }

        List<WebElement> ProbNames = driver
                .findElements(By.xpath("//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s']"));
        for (int i = 1; i <= 5; i++) {
            WebElement name = ProbNames.get(i);
            String Names = name.getText();
            System.out.println(Names);
        }
        Thread.sleep(5000);
        System.out.println("end Test case: testCase02");
    }

    public void testCase03() {
        System.out.println("Start Test case: testCase03");
        WebElement TwoSum = driver.findElement(By.xpath("//a[@href='/problems/two-sum']"));
        TwoSum.click();
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        waits.until(ExpectedConditions.urlContains("two-sum"));
        if (status == true) {
            System.out.println("The URl opens Two-Sum");
        } else {
            System.out.println("Failed To Open Two-Sum");
        }
        System.out.println("end Test case: testCase03");
    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        WebElement SubmitBtn = driver.findElement(By.xpath("//div[@data-layout-path='/ts0/tb3']"));                                                  
        SubmitBtn.click();
        WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement RegisterBtn = driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
        waits.until(ExpectedConditions.visibilityOf(RegisterBtn));
        String RegisterText = RegisterBtn.getText();
        System.out.println(RegisterText);
        System.out.println("end Test case: testCase04");


    }

}
