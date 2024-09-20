package Lesson_15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    }

    // 1. Проверить название указанного блока
    @Test
    public void testBlockName() {
        assertEquals("Онлайн пополнение без комиссии", mainPage.getBlockNameText(),
                "Текст не соответствует ожидаемому значению.");
    }

    // Закрываем браузер и драйвер
    @AfterEach
    public void teardown() {
        driver.quit();
    }
}