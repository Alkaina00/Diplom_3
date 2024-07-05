package ru.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.model.User;
import ru.praktikum.page.LoginPage;
import ru.praktikum.page.MainPage;
import ru.praktikum.page.RegisterPage;
import ru.praktikum.steps.UserSteps;

import static org.junit.Assert.assertTrue;

public class LoginTest{
    public WebDriver webDriver;
    private static final String URL_TEST = "https://stellarburgers.nomoreparties.site/";

    private final UserSteps userSteps = new UserSteps();
    private User user;
    private String email;
    private String password;
    private String name;

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.getWebDriver();
        webDriver.get(URL_TEST);
        RestAssured.filters(new RequestLoggingFilter());
        email = RandomStringUtils.randomAlphabetic(10)+"@mail.ru";
        password = RandomStringUtils.randomAlphabetic(10);
        name = RandomStringUtils.randomAlphabetic(10);

        user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        userSteps.createUser(user);

        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);

    }

    @Test
    @DisplayName("Вход на главной")
    @Description("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginMainTest() {
        mainPage.clickButtonInMain();
        loginPage.inputLogin(email, password);
        loginPage.clickLogin();

        assertTrue(mainPage.inDoneDesplayedButtonOrd());
    }

    @Test
    @DisplayName("Вход через Личный кабинет")
    @Description("Вход через кнопку «Личный кабинет»")
    public void loginLKTest() {
        mainPage.clickButtonLK();
        loginPage.inputLogin(email, password);
        loginPage.clickLogin();

        assertTrue(mainPage.inDoneDesplayedButtonOrd());
    }

    @Test
    @DisplayName("Вход через форму регистрации")
    @Description("Успешный вход через форму регистрации")
    public void loginRegistrationTest() {
        mainPage.clickButtonLK();
        loginPage.clickRegister();
        registerPage.clickLogin();
        loginPage.inputLogin(email, password);
        loginPage.clickLogin();

        assertTrue(mainPage.inDoneDesplayedButtonOrd());
    }

    @Test
    @DisplayName("Вход через форму восстановления пароля")
    @Description("Успешный вход через кнопку в форме восстановления пароля")
    public void loginRecoveryTest() {
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
    public void logoutTest(){
        webDriver.get("https://stellarburgers.nomoreparties.site/login");
        loginPage.inputLogin(email, password);
        loginPage.clickLogin();
        mainPage.clickButtonLK();
        loginPage.clickLogout();

        assertTrue(loginPage.inDoneDesplayedTextIn());
    }

    @After
    public void tearDown() {
        // Закрой браузер
        webDriver.close();

        // Удаление пользователя
        String token = userSteps.loginUser(user)
                .extract().body().path("accessToken");
        if(token != null){
            user.setToken(token);
            userSteps.deleteUser(user);
        }
    }
}
