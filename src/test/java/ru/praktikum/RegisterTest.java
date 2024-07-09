package ru.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import ru.praktikum.page.LoginPage;
import ru.praktikum.page.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Успешная проверка регистрации пользователя")
    public void registerOK() {
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
        registerPage.inputRegister(name, email, password);
        registerPage.clickButtonRegister();

        assertTrue(loginPage.inDoneDesplayedTextIn());
    }

    @Test
    @DisplayName("Ошибка на некорректный пароль")
    @Description("Ошибка для некорректного пароля. Минимальный пароль — шесть символов.")
    public void registerPasswordError() {
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
        password = RandomStringUtils.randomAlphabetic(5);

        registerPage = new RegisterPage(webDriver);
        registerPage.inputRegister(name, email, password);
        registerPage.clickButtonRegister();

        assertTrue(registerPage.inDoneDesplayedErrorPass());
    }
}
