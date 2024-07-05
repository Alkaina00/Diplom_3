package ru.praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class RegisterPage {
    private final WebDriver driver;

    private final By nameRegisterLocator = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    private final By emailRegisterLocator = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    private final By passwordRegisterLocator = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input");
    private final By registerButtonLocator = By.xpath(".//*[text()='Зарегистрироваться']");
    private final By errorPasswordLocator = By.xpath(".//*[text()='Некорректный пароль']");
    private final By loginLocator = By.xpath(".//*[text()='Войти']");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Заполнить поля для регистрации name, email, password")
    public void inputRegister(String name, String email, String password){
        // Заполнить поле Имя
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(nameRegisterLocator));
        WebElement nameRegister = driver.findElement(nameRegisterLocator);
        nameRegister.sendKeys(name);

        // Заполнить поле Email
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(emailRegisterLocator));
        WebElement emailRegister = driver.findElement(emailRegisterLocator);
        emailRegister.sendKeys(email);

        // Заполнить поле Пароль
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(passwordRegisterLocator));
        WebElement passwordRegister = driver.findElement(passwordRegisterLocator);
        passwordRegister.sendKeys(password);
    }

    @Step("Нажать кнопку Зарегистрировать")
    public void clickButtonRegister() {
        //кнопка Зарегистрировать
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(registerButtonLocator));
        WebElement buttonRegister = driver.findElement(registerButtonLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(buttonRegister));
        buttonRegister.click();
    }

    @Step("Нажать ссылку Войти")
    public void clickLogin(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(loginLocator));
        WebElement login = driver.findElement(loginLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(login));
        login.click();
    }

    public boolean inDoneDesplayedErrorPass(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(errorPasswordLocator));
        return driver.findElement(errorPasswordLocator).isDisplayed();
    }
}
