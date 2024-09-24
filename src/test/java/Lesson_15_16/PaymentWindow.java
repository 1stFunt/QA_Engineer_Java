package Lesson_15_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentWindow {
    private final WebDriverWait wait;
    private final WebDriver driver;
    // Селектор фрейма
    private final By paymentIframeSelector = By.cssSelector("iframe.bepaid-iframe");

    // Отображение суммы
    @FindBy(xpath = "//span[contains(text(), 'BYN')]")
    private WebElement priceElement;
    // Кнопка оплаты
    @FindBy(xpath = "//button[contains(text(), 'Оплатить') and contains(text(), 'BYN')]")
    private WebElement payButton;

    // Иконки платёжных систем
    @FindBy(css = "img[src*='visa-system']")
    private WebElement visaLogo;
    @FindBy(css = "img[src*='mastercard-system']")
    private WebElement mastercardLogo;
    @FindBy(css = "img[src*='belkart-system']")
    private WebElement belkartLogo;
    @FindBy(css = "img[src*='mir-system-ru']")
    private WebElement mirLogo;
    @FindBy(css = "img[src*='maestro-system']")
    private WebElement maestroLogo;

    // Отображение номер телефона
    @FindBy(xpath = "//div[contains(@class, 'pay-description__text')]/span[contains(text(), 'Оплата: Услуги связи')]")
    private WebElement paymentDescription;

    // Поля окна оплаты
    @FindBy(css = "div.content label.ng-star-inserted")
    private WebElement cardNumberLabel;
    @FindBy(css = "label.ng-tns-c46-4")
    private WebElement expirationDateLabel;
    @FindBy(css = "label.ng-tns-c46-5")
    private WebElement cvcLabel;
    @FindBy(css = "label.ng-tns-c46-3")
    private WebElement cardHolderLabel;

    // Конструктор для инициализации элементов (ленивая инициализация)
    public PaymentWindow(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Метод для переключения на фрейм окна оплаты
    public void switchToPaymentFrame() {
        driver.switchTo().frame(driver.findElement(paymentIframeSelector));
    }

    // Сумма окна оплаты
    public String getPriceText() {
        return wait.until(ExpectedConditions.visibilityOf(priceElement)).getText().replace("\n", " ");
    }

    // Сумма на кнопке оплаты
    public String getPayButtonText() {
        return wait.until(ExpectedConditions.visibilityOf(payButton)).getText().trim();
    }

    // Метод для получения логотипов платёжных систем
    public WebElement getPaymentLogoBySystem(String logoSystem) {
        switch (logoSystem.toLowerCase()) {
            case "visa":
                return wait.until(ExpectedConditions.visibilityOf(visaLogo));
            case "mastercard":
                return wait.until(ExpectedConditions.visibilityOf(mastercardLogo));
            case "belkart":
                return wait.until(ExpectedConditions.visibilityOf(belkartLogo));
            case "mir":
                return wait.until(ExpectedConditions.visibilityOf(mirLogo));
            case "maestro":
                return wait.until(ExpectedConditions.visibilityOf(maestroLogo));
            default:
                return null; // Логотип не найден
        }
    }

    // Получение номера телефона
    public String getPaymentDescriptionText() {
        return wait.until(ExpectedConditions.visibilityOf(paymentDescription)).getText().trim();
    }

    // Получение текста из номера карты
    public String getCreditCardLabelText() {
        return cardNumberLabel.getText();
    }

    // Получение текста из поля срока действия карты
    public String getExpirationDateLabelText() {
        return expirationDateLabel.getText();
    }

    // Получение текста из поля CVC
    public String getCvcLabelText() {
        return cvcLabel.getText();
    }

    // Получение текста из поля имени держателя карты
    public String getCardHolderLabelText() {
        return cardHolderLabel.getText();
    }
}