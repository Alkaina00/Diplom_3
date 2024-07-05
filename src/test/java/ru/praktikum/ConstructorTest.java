package ru.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.page.LoginPage;
import ru.praktikum.page.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest{
    public WebDriver webDriver;
    private static final String URL_TEST = "https://stellarburgers.nomoreparties.site/";
    private MainPage mainPage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.getWebDriver();
        webDriver.get(URL_TEST);
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Успешный переход по клику на «Личный кабинет»")
    public void transitionLKTest(){
        mainPage.clickButtonLK();
        assertTrue(loginPage.inDoneDesplayedTextIn());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Успешный переход по клику на «Конструктор»")
    public void transitionConstructorTest() {
        webDriver.get("https://stellarburgers.nomoreparties.site/login");
        mainPage.clickConstructor();
        assertTrue(mainPage.inDoneDesplayedBurger());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по лого")
    @Description("Успешный переход по клику на логотип Stellar Burgers")
    public void transitionLogoTest() {
        webDriver.get("https://stellarburgers.nomoreparties.site/login");
        mainPage.clickLogo();
        assertTrue(mainPage.inDoneDesplayedBurger());
    }

    @Test
    @DisplayName("Переход к разделам «Булки»")
    @Description("Успешный переход к разделам «Булки»")
    public void transitionBunTest() {
        mainPage.clickSouseTab();
        mainPage.clickBunTab();
        assertTrue(mainPage.inDoneDesplayedBun());
    }

    @Test
    @DisplayName("Переход к разделам «Соусы»")
    @Description("Успешный переход к разделам «Соусы»")
    public void transitionSouseTest() {
        mainPage.clickSouseTab();
        assertTrue(mainPage.inDoneDesplayedSouse());
    }

    @Test
    @DisplayName("Переход к разделам «Начинки»")
    @Description("Успешный переход к разделам «Начинки»")
    public void transitionFillingTest() {
        mainPage.clickFillingTab();
        assertTrue(mainPage.inDoneDesplayedFilling());
    }

    @After
    public void tearDown() {
        // Закрой браузер
        webDriver.close();
    }
}
