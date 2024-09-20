package Lesson_15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MainTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;

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
        mainPage.clickRejectCookies();
    }

    // 1. Проверить название указанного блока
    @Test
    public void testBlockName() {
        assertEquals("Онлайн пополнение без комиссии", mainPage.getBlockNameText(),
                "Текст не соответствует ожидаемому значению.");
    }

    // 2. Проверить наличие логотипов платёжных систем
    @ParameterizedTest
    @ValueSource(strings = {"visa", "verified by visa", "mastercard", "mastercard secure", "белкарт"})
    public void testPaymentLogosAreDisplayed(String logo) {
        assertNotNull(mainPage.getPaymentLogoById(logo), "Логотип " + logo + " не найден на странице.");
        assertTrue(mainPage.getPaymentLogoById(logo).isDisplayed(), "Логотип " + logo + " не отображается на странице.");
    }

    // 3. Проверить работу ссылки "Подробнее о сервисе"
    @Test
    public void testClickAboutServiceLink() {
        mainPage.clickAboutServiceLink();
        // Проверка, что после клика мы попали на нужную страницу
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                currentUrl, "URL не соответствует ожидаемому.");
    }

    // Заполнить поля и проверить работу кнопки "Продолжить"
    @Test
    public void testInputFieldsAndSubmit() throws InterruptedException {
        mainPage.enterPhoneNumber("297777777");
        mainPage.enterSum("100");
        mainPage.enterEmail("funt_88@mail.ru");
        mainPage.clickContinueButton();
        Thread.sleep(3000); // Ожидание
        assertEquals("100.00 BYN", mainPage.getCardPageText(),
                "Текст на странице карты не соответствует ожидаемому.");

    }

    // Закрываем браузер и драйвер
    @AfterEach
    public void teardown() {
        driver.quit();
    }
}