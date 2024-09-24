package Lesson_15_16;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriverWait wait;

    // Ищем название блока
    @FindBy(xpath = "//div[@id='pay-section']//h2")
    private WebElement blockName;

    // Логотипы
    @FindBy(xpath = "//img[@alt=\"Visa\"]\n")
    private WebElement visaLogo;
    @FindBy(xpath = "//img[@alt='Verified By Visa']")
    private WebElement verifiedVisaLogo;
    @FindBy(xpath = "//img[@alt='MasterCard']")
    private WebElement masterCardLogo;
    @FindBy(xpath = "//img[@alt='MasterCard Secure Code']")
    private WebElement masterCardSecureLogo;
    @FindBy(xpath = "//img[@alt='Белкарт']")
    private WebElement belcardLogo;

    // Ссылка "Подробнее о сервисе"
    @FindBy(xpath = "//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']")
    private WebElement aboutService;

    // Поля и кнопка "Продолжить"
    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement connectionPhoneInput;
    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement connectionSumInput;
    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement connectionEmailInput;
    @FindBy(xpath = "//form[1]//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;

    // Конструктор для инициализации элементов (ленивая инициализация)
    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    // Отклонение куки
    public void clickRejectCookies() {
        try {
            // Ожидание видимости окна с кнопками
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]")));
            // Ожидание кнопки отклонения куки
            WebElement rejectButton = wait.until(ExpectedConditions.elementToBeClickable
                    (By.cssSelector("button.btn.btn_gray.cookie__cancel[data-close]")));
            rejectButton.click();
        } catch (TimeoutException e) {
            System.out.println("Окно с куками не появилось.");
        }
    }

    // Метод для получения названия блока
    public String getBlockNameText() {
        return wait.until(ExpectedConditions.visibilityOf(blockName))
                .getText().replace("\n", " ");
    }

    // Получаем логотипы платёжных систем
    public WebElement getPaymentLogoById(String logoId) {
        switch (logoId.toLowerCase()) {
            case "visa":
                return wait.until(ExpectedConditions.visibilityOf(visaLogo));
            case "verified by visa":
                return wait.until(ExpectedConditions.visibilityOf(verifiedVisaLogo));
            case "mastercard":
                return wait.until(ExpectedConditions.visibilityOf(masterCardLogo));
            case "mastercard secure":
                return wait.until(ExpectedConditions.visibilityOf(masterCardSecureLogo));
            case "белкарт":
                return wait.until(ExpectedConditions.visibilityOf(belcardLogo));
            default:
                return null; // Логотип не найден
        }
    }

    // Кликаем на ссылку "Подробнее о сервисе"
    public void clickAboutServiceLink() {
        wait.until(ExpectedConditions.elementToBeClickable(aboutService)).click();
    }

    // Вводим телефон в поле
    public void enterPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOf(connectionPhoneInput));
        connectionPhoneInput.clear();
        connectionPhoneInput.sendKeys(phoneNumber);
    }

    // Вводим сумму в поле
    public void enterSum(String sum) {
        wait.until(ExpectedConditions.visibilityOf(connectionSumInput));
        connectionSumInput.clear();
        connectionSumInput.sendKeys(sum);
    }

    // Вводим электронную почту в поле
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(connectionEmailInput));
        connectionEmailInput.clear();
        connectionEmailInput.sendKeys(email);
    }

    // Жмём "Продолжить"
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }
}