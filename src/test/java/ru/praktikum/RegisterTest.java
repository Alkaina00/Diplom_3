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
import ru.praktikum.page.RegisterPage;
import ru.praktikum.steps.UserSteps;

import static org.junit.Assert.assertTrue;

public class RegisterTest {
    public WebDriver webDriver;
    private static final String URL_TEST = "https://stellarburgers.nomoreparties.site/";

    private final UserSteps userSteps = new UserSteps();
    private User user;
    private String email;
    private String password;
    private String name;

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

        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Успешная проверка регистрации пользователя")
    public void registerOK() {
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
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

        registerPage.inputRegister(name, email, password);
        registerPage.clickButtonRegister();

        assertTrue(registerPage.inDoneDesplayedErrorPass());
    }

    @After
    public void tearDown() {
        // Закрой браузер
        webDriver.close();

        String token = userSteps.loginUser(user)
                .extract().body().path("accessToken");
        if(token != null){
            user.setToken(token);
            userSteps.deleteUser(user);
        }
    }
}
