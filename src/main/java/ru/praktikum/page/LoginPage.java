package ru.praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class LoginPage {
    private final WebDriver driver;

    private final By registerLocator = By.xpath(".//*[@id='root']/div/main/div/div/p[1]/a");
    private final By buttonInLocator = By.xpath(".//*[@id='root']/div/main/div/form/button");
    private final By emailLocator = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    private final By passwordLocator = By.xpath(".//*/input[@name='Пароль']");
    private final By recoveryLocator = By.xpath(".//*[text()='Восстановить пароль']");
    private final By logoutLocator = By.xpath(".//*[text()='Выход']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на ссылку Зарегистрировать")
    public void clickRegister(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(registerLocator));
        WebElement register = driver.findElement(registerLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(register));
        register.click();
    }

    @Step("Заполнение полей входа email, password")
    public void inputLogin(String email, String password){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
        WebElement emailLogin = driver.findElement(emailLocator);
        emailLogin.sendKeys(email);

        WebElement passwordLogin = driver.findElement(passwordLocator);
        passwordLogin.sendKeys(password);
    }

    @Step("Нажать кнопку Войти")
    public void clickLogin(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(buttonInLocator));
        WebElement buttonIn = driver.findElement(buttonInLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(buttonIn));
        buttonIn.click();
    }

    @Step("Нажать ссылку Восстановить пароль")
    public void clickRecovery(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(recoveryLocator));
        WebElement recovery = driver.findElement(recoveryLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(recovery));
        recovery.click();
    }

    @Step("Нажать кнопку Выйти")
    public void clickLogout(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(logoutLocator));
        WebElement logout = driver.findElement(logoutLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(logout));
        logout.click();
    }

    public boolean inDoneDesplayedTextIn(){
        new WebDriverWait(driver, ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(buttonInLocator));
        return driver.findElement(buttonInLocator).isDisplayed();
    }
}
