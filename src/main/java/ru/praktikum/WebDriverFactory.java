package ru.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        if(driver == null){
            String browser = System.getProperty("browser");
            switch (browser){
                case "chrome":
                    return WebDriverManager.chromedriver().create();
                case "firefox":
                    return  WebDriverManager.firefoxdriver().create();
                case "yandex":
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver-24.6.0.1878-win/yandexdriver.exe");
                    return new ChromeDriver();
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
