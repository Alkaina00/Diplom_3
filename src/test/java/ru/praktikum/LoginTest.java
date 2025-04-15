package ru.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.page.LoginPage;
import ru.praktikum.page.MainPage;
import ru.praktikum.page.RegisterPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Test
    @DisplayName("Вход на главной")
    @Description("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginMainTest() {
        userSteps.createUser(user);

        mainPage = new MainPage(webDriver);
        mainPage.clickButtonInMain();

        loginPage = new LoginPage(webDriver);
        loginPage.inputLogin(email, password);
        loginPage.clickLogin();

        assertTrue(mainPage.inDoneDesplayedButtonOrd());
    }

    @Test
    @DisplayName("Вход через Личный кабинет")
    @Description("Вход через кнопку «Личный кабинет»")
    public void loginLKTest() {
        userSteps.createUser(user);

        mainPage = new MainPage(webDriver);
        mainPage.clickButtonLK();

        loginPage = new LoginPage(webDriver);
        loginPage.inputLogin(email, password);
        loginPage.clickLogin();

        assertTrue(mainPage.inDoneDesplayedButtonOrd());
    }

    @Test
    @DisplayName("Вход через форму регистрации")
    @Description("Успешный вход через форму регистрации")
    public void loginRegistrationTest() {
        userSteps.createUser(user);

        mainPage = new MainPage(webDriver);
        mainPage.clickButtonLK();

        loginPage = new LoginPage(webDriver);
        loginPage.clickRegister();

        registerPage = new RegisterPage(webDriver);
        registerPage.clickLogin();
        loginPage.inputLogin(email, password);
        loginPage.clickLogin();

        assertTrue(mainPage.inDoneDesplayedButtonOrd());
    }

    @Test
    @DisplayName("Вход через форму восстановления пароля")
    @Description("Успешный вход через кнопку в форме восстановления пароля")
    public void loginRecoveryTest() {
        userSteps.createUser(user);
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
        mainPage = new MainPage(webDriver);

        webDriver.get("https://stellarburgers.nomoreparties.site/login");
        loginPage.clickRecovery();
        registerPage.clickLogin();
        loginPage.inputLogin(email, password);
        loginPage.clickLogin();

        assertTrue(mainPage.inDoneDesplayedButtonOrd());
    }

    @Test
    @DisplayName("Успешный выход")
    @Description("Успешный выход по кнопке «Выйти» в личном кабинете")
    public void logoutTest() {
        userSteps.createUser(user);

        webDriver.get("https://stellarburgers.nomoreparties.site/login");
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        loginPage.inputLogin(email, password);
        loginPage.clickLogin();
        mainPage.clickButtonLK();
        loginPage.clickLogout();

        assertTrue(loginPage.inDoneDesplayedTextIn());
    }
}
