package ru.praktikum;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.praktikum.model.User;
import ru.praktikum.steps.UserSteps;

import java.time.Duration;

public class BaseTest {

    private static final String URL_TEST = "https://stellarburgers.nomoreparties.site/";
    public final UserSteps userSteps = new UserSteps();
    public WebDriver webDriver;
    public User user;

    public String email;
    public String password;
    public String name;

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.getWebDriver();
        webDriver.get(URL_TEST);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        RestAssured.filters(new RequestLoggingFilter());
        email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
        password = RandomStringUtils.randomAlphabetic(10);
        name = RandomStringUtils.randomAlphabetic(10);

        user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
    }

    @After
    public void tearDown() {
        // Закрой браузер
        webDriver.close();

        // Удаление пользователя
        String token = userSteps.loginUser(user)
                .extract().body().path("accessToken");
        if (token != null) {
            user.setToken(token);
            userSteps.deleteUser(user);
        }
    }
}
