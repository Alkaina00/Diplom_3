package ru.praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private final WebDriver driver;

    private final By nameRegisterLocator = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    private final By emailRegisterLocator = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    private final By passwordRegisterLocator = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input");
    private final By registerButtonLocator = By.xpath(".//*[text()='Зарегистрироваться']");
    private final By errorPasswordLocator = By.xpath(".//*[text()='Некорректный пароль']");
    private final By loginLocator = By.xpath(".//*[text()='Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнить поля для регистрации name, email, password")
    public void inputRegister(String name, String email, String password) {
        // Заполнить поле Имя
        WebElement nameRegister = driver.findElement(nameRegisterLocator);
        nameRegister.sendKeys(name);

        // Заполнить поле Email
        WebElement emailRegister = driver.findElement(emailRegisterLocator);
        emailRegister.sendKeys(email);

        // Заполнить поле Пароль
        WebElement passwordRegister = driver.findElement(passwordRegisterLocator);
        passwordRegister.sendKeys(password);
    }

    @Step("Нажать кнопку Зарегистрировать")
    public void clickButtonRegister() {
        WebElement buttonRegister = driver.findElement(registerButtonLocator);
        buttonRegister.click();
    }

    @Step("Нажать ссылку Войти")
    public void clickLogin() {
        WebElement login = driver.findElement(loginLocator);
        login.click();
    }

    @Step("Отображается текст об ошибке Некорректный пароль")
    public boolean inDoneDesplayedErrorPass() {
        return driver.findElement(errorPasswordLocator).isDisplayed();
    }
}
