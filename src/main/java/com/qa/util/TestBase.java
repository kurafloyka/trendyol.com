package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    @Before
    public static void initialization() {

        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") +"/src/main/java/com/qa/config/config.properties");

            prop.load(fis);

        } catch (IOException e) {
            e.getMessage();
        }

        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/src/main/java/com/qa/config/resources/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        // driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException, IOException {

        try {
            if (scenario.isFailed()) {

                final File screenshotss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFileToDirectory(screenshotss, new File(System.getProperty("user.dir") + "/src/main/java/com/qa/config/screenShot"));
            }
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        } finally {
            driver.close();

        }

        System.out.println("closed the browser");
        driver.quit();

    }

    @AfterClass()
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
    }

}
