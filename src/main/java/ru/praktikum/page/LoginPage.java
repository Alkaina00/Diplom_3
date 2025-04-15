package ru.praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    public void clickRegister() {
        WebElement register = driver.findElement(registerLocator);
        register.click();
    }

    @Step("Заполнение полей входа email, password")
    public void inputLogin(String email, String password) {
        WebElement emailLogin = driver.findElement(emailLocator);
        emailLogin.sendKeys(email);

        WebElement passwordLogin = driver.findElement(passwordLocator);
        passwordLogin.sendKeys(password);
    }

    @Step("Нажать кнопку Войти")
    public void clickLogin() {
        WebElement buttonIn = driver.findElement(buttonInLocator);
        buttonIn.click();
    }

    @Step("Нажать ссылку Восстановить пароль")
    public void clickRecovery() {
        WebElement recovery = driver.findElement(recoveryLocator);
        recovery.click();
    }

    @Step("Нажать кнопку Выйти")
    public void clickLogout() {
        WebElement logout = driver.findElement(logoutLocator);
        logout.click();
    }

    @Step("Отображается кнопка Войти")
    public boolean inDoneDesplayedTextIn() {
        return driver.findElement(buttonInLocator).isDisplayed();
    }
}
