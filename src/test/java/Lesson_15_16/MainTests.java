package Lesson_15_16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MainTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;
    private DropDownList dropDownList;
    private PaymentWindow paymentWindow;

    @BeforeEach
    public void setupTest() {
        // Создаём экземпляр драйвера
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Растягиваем окно браузера
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        // Объект созданного Page Object для взаимодействия со страницей
        mainPage = new MainPage(driver, wait);
        dropDownList = new DropDownList(driver, wait);
        paymentWindow = new PaymentWindow(driver, wait);
        mainPage.clickRejectCookies();
    }

    // 1.1 Проверить название указанного блока
    @Test
    public void testBlockName() {
        assertEquals("Онлайн пополнение без комиссии", mainPage.getBlockNameText(),
                "Текст не соответствует ожидаемому значению.");
    }

    // 1.2. Проверить наличие логотипов платёжных систем
    @ParameterizedTest
    @ValueSource(strings = {"visa", "verified by visa", "mastercard", "mastercard secure", "белкарт"})
    public void testPaymentLogosAreDisplayed(String logo) {
        assertNotNull(mainPage.getPaymentLogoById(logo), "Логотип " + logo + " не найден на странице.");
        assertTrue(mainPage.getPaymentLogoById(logo).isDisplayed(), "Логотип " + logo + " не отображается на странице.");
    }

    // 1.3. Проверить работу ссылки "Подробнее о сервисе"
    @Test
    public void testClickAboutServiceLink() {
        mainPage.clickAboutServiceLink();
        // Проверка, что после клика мы попали на нужную страницу
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                currentUrl, "URL не соответствует ожидаемому.");
    }

    // 1.4. Заполнить поля и проверить работу кнопки "Продолжить"
    @Test
    public void testInputFieldsAndSubmit() throws InterruptedException {
        mainPage.enterPhoneNumber("297777777");
        String expectedSum = "100.00";
        mainPage.enterSum(expectedSum);
        mainPage.enterEmail("funt_88@mail.ru");
        mainPage.clickContinueButton();
        Thread.sleep(3000); // Ожидание
        // Ожидание загрузки и переключение на фрейм
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.bepaid-iframe")));
        assertTrue(mainPage.getCardPageText().contains(expectedSum + " BYN"),
                "Текст на странице карты не содержит сумму и валюту.");
    }

    // 2.1 Проверка надписей полей раздела "Услуги связи"
    @Test
    public void testServicesFieldsText() {
        dropDownList.clickSelectHeader();
        dropDownList.clickOnServicesOption(); // Кликаем по "Услуги связи"
        assertEquals("Номер телефона", dropDownList.getPhonePlaceholderText(), "Текст плейсхолдера для номера телефона неверный.");
        assertEquals("Сумма", dropDownList.getSumPlaceholderText(), "Текст плейсхолдера для суммы неверный.");
        assertEquals("E-mail для отправки чека", dropDownList.getEmailPlaceholderText(), "Текст плейсхолдера для электронной почты неверный.");
    }

    // Проверка надписей полей раздела "Домашний интернет"
    @Test
    public void testInternetFieldsText() {
        dropDownList.clickSelectHeader();
        dropDownList.clickOnHomeInternetOption(); // Кликаем по "Домашний интернет"
        assertEquals("Номер абонента", dropDownList.getPhoneInternetPlaceholderText(), "Текст плейсхолдера для телефона неверный.");
        assertEquals("Сумма", dropDownList.getSumInternetPlaceholderText(), "Текст плейсхолдера для суммы неверный.");
        assertEquals("E-mail для отправки чека", dropDownList.getEmailInternetPlaceholderText(), "Текст плейсхолдера для электронной почты неверный.");
    }

    // Проверка надписей полей раздела "Рассрочка"
    @Test
    public void testInstalmentFieldsText() {
        dropDownList.clickSelectHeader();
        dropDownList.clickOnInstallmentOption(); // Кликаем по "Рассрочка"
        assertEquals("Номер счета на 44", dropDownList.getScoreInstalmentPlaceholderText(), "Текст плейсхолдера для счета неверный.");
        assertEquals("Сумма", dropDownList.getSumInstalmentPlaceholderText(), "Текст плейсхолдера для суммы неверный.");
        assertEquals("E-mail для отправки чека", dropDownList.getEmailInstalmentPlaceholderText(), "Текст плейсхолдера для электронной почты неверный.");
    }

    // Проверка надписей полей раздела "Задолженность"
    @Test
    public void testArrearsFieldsText() {
        dropDownList.clickSelectHeader();
        dropDownList. clickOnArrearsOption(); // Кликаем по "Задолженность"
        assertEquals("Номер счета на 2073", dropDownList.getScoreArrearsPlaceholderText(), "Текст плейсхолдера для счета неверный.");
        assertEquals("Сумма", dropDownList.getSumArrearsPlaceholderText(), "Текст плейсхолдера для суммы неверный.");
        assertEquals("E-mail для отправки чека", dropDownList.getEmailArrearsPlaceholderText(), "Текст плейсхолдера для электронной почты неверный.");
    }

    // Закрываем браузер и драйвер
    @AfterEach
    public void teardown() {
        driver.quit();
    }
}