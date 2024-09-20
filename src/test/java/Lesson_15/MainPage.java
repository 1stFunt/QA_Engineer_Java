package Lesson_15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Класс MainPage создан для соблюдения структурного подхода и наглядности использования паттерна Page Object.
public class MainPage {
    private final WebDriverWait wait;
    // Ищем название блока
    @FindBy(xpath = "//div[@class='pay__wrapper']/h2[contains(text(), 'Онлайн пополнение без комиссии')]")
    private WebElement blockName;


    // Конструктор для инициализации элементов (ленивая инициализация)
    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String getBlockNameText() {
        return wait.until(ExpectedConditions.visibilityOf(blockName))
                .getText().replace("\n", " ");
    }
}
