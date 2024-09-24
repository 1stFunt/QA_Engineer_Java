package Lesson_15_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentWindow {
    private final WebDriverWait wait;
    // Селектор фрейма
    private final By paymentIframeSelector = By.cssSelector("iframe.bepaid-iframe");

    @FindBy(xpath = "//span[contains(text(), 'BYN')]")
    private WebElement priceElement;

    // Конструктор для инициализации элементов (ленивая инициализация)
    public PaymentWindow(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
    }
}
