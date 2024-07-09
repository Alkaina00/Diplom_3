package ru.praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;

    private final By buttonLKLocator = By.xpath("//*[@id='root']/div/header/nav/a/p");
    private final By buttonInMainLocator = By.xpath("//*[@id='root']/div/main/section[2]/div/button");
    private final By buttonCreateOrderLocator = By.xpath("//*[@id='root']/div/main/section[2]/div/button");

    private final By logoLocator = By.xpath("//div/a");
    private final By constructorLocator = By.xpath(".//*[text()='Конструктор']");

    private final By burgerLocator = By.xpath(".//*[text()='Соберите бургер']");
    private final By bunTabLocator = By.xpath(".//*[@id='root']/div/main/section[1]/div[1]/div[1]/span[text()='Булки']");
    private final By souseTabLocator = By.xpath(".//*[@id='root']/div/main/section[1]/div[1]/div[2]/span[text()='Соусы']");
    private final By fillingTabLocator = By.xpath(".//*[@id='root']/div/main/section[1]/div[1]/div[3]/span[text()='Начинки']");

    private final By bunTextLocator = By.xpath(".//*/div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By souseTextLocator = By.xpath(".//*/div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By fillingTextLocator = By.xpath(".//*/div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход в личный кабинет")
    public void clickButtonLK() {
        WebElement buttonLK = driver.findElement(buttonLKLocator);
        buttonLK.click();
    }

    @Step("Нажать кнопку Войти в аккаунт")
    public void clickButtonInMain() {
        WebElement buttonInMain = driver.findElement(buttonInMainLocator);
        buttonInMain.click();
    }

    @Step("Нажать на логотип StellarBurger")
    public void clickLogo() {
        WebElement logo = driver.findElement(logoLocator);
        logo.click();
    }

    @Step("Переход в Конструктор")
    public void clickConstructor() {
        WebElement constructor = driver.findElement(constructorLocator);
        constructor.click();
    }

    @Step("Нажать на вкладку Булки")
    public void clickBunTab() {
        WebElement bunTab = driver.findElement(bunTabLocator);
        bunTab.click();
    }

    @Step("Нажать на вкладку Соусы")
    public void clickSouseTab() {
        WebElement souseTab = driver.findElement(souseTabLocator);
        souseTab.click();
    }

    @Step("Нажать на вкладку Начинки")
    public void clickFillingTab() {
        WebElement fillingTab = driver.findElement(fillingTabLocator);
        fillingTab.click();
    }

    @Step("Отображается кнопка Оформить заказ")
    public boolean inDoneDesplayedButtonOrd() {
        return driver.findElement(buttonCreateOrderLocator).isDisplayed();
    }

    @Step("Отображается текст Соберите бургер")
    public boolean inDoneDesplayedBurger() {
        return driver.findElement(burgerLocator).isDisplayed();
    }

    @Step("Выделена вкладка Булки")
    public boolean inDoneDesplayedBun() {
        return driver.findElement(bunTextLocator).isDisplayed();
    }

    @Step("Выделена вкладка Соусы")
    public boolean inDoneDesplayedSouse() {
        return driver.findElement(souseTextLocator).isDisplayed();
    }

    @Step("Выделена вкладка Начинки")
    public boolean inDoneDesplayedFilling() {
        return driver.findElement(fillingTextLocator).isDisplayed();
    }
}
