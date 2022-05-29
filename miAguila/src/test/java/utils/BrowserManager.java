package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BrowserManager {
    private static WebDriver driver;
    private static String browser;
    private static String binaryPath;
    private static String propertyFilePath = "./src/test/resources/Configuration.properties";
    private static WebDriverWait wait;

    private static String url;

    private BrowserManager() {
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void init() {
        if (driver == null) {
            Properties properties = new Properties();

            try {
                properties.load(new FileInputStream(propertyFilePath));
            } catch (IOException e) {
                System.out.println("No se encontró el archivo");
            }

            browser = properties.getProperty("BROWSER");

            url = properties.getProperty("URL");

            binaryPath = properties.getProperty("PATHCHROMEDRIVER");
            System.setProperty("webdriver.chrome.driver", binaryPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(20));
            driver.get(url);
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            init();
        }
        return driver;
    }

    public static WebElement findWebElementWait(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }
}