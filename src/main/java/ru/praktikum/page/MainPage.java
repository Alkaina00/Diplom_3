package ru.praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

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
    public void clickButtonLK(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(buttonLKLocator));
        WebElement buttonLK = driver.findElement(buttonLKLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(buttonLK));
        buttonLK.click();
    }

    @Step("Нажать кнопку Войти в аккаунт")
    public void clickButtonInMain(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(buttonInMainLocator));
        WebElement buttonInMain = driver.findElement(buttonInMainLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(buttonInMain));
        buttonInMain.click();
    }

    @Step("Нажать на логотип StellarBurger")
    public void clickLogo(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(logoLocator));
        WebElement logo = driver.findElement(logoLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(logo));
        logo.click();
    }

    @Step("Переход в Конструктор")
    public void clickConstructor(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(constructorLocator));
        WebElement constructor = driver.findElement(constructorLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(constructor));
        constructor.click();
    }

    @Step("Нажать на вкладку Булки")
    public void clickBunTab(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(bunTabLocator));
        WebElement bunTab = driver.findElement(bunTabLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(bunTab));
        bunTab.click();
    }

    @Step("Нажать на вкладку Соусы")
    public void clickSouseTab(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(souseTabLocator));
        WebElement souseTab = driver.findElement(souseTabLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(souseTab));
        souseTab.click();
    }

    @Step("Нажать на вкладку Начинки")
    public void clickFillingTab(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(fillingTabLocator));
        WebElement fillingTab = driver.findElement(fillingTabLocator);
        new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(fillingTab));
        fillingTab.click();
    }

    public boolean inDoneDesplayedButtonOrd(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(buttonCreateOrderLocator));
        return driver.findElement(buttonCreateOrderLocator).isDisplayed();
    }

    public boolean inDoneDesplayedBurger(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(burgerLocator));
        return driver.findElement(burgerLocator).isDisplayed();
    }

    public boolean inDoneDesplayedBun(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(bunTextLocator));
        return driver.findElement(bunTextLocator).isDisplayed();
    }
    public boolean inDoneDesplayedSouse(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(souseTextLocator));
        return driver.findElement(souseTextLocator).isDisplayed();
    }
    public boolean inDoneDesplayedFilling(){
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(fillingTextLocator));
        return driver.findElement(fillingTextLocator).isDisplayed();
    }
}
