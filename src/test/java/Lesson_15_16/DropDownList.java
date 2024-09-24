package Lesson_15_16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownList {
    private final WebDriverWait wait;
    private final Actions actions;

    // Выпадающий список, элементы и соответствующие элементам поля
    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement selectHeader;

    // Элементы
    @FindBy(xpath = "//p[@class='select__option' and text()='Услуги связи']")
    private WebElement servicesOption;
    @FindBy(xpath = "//p[@class='select__option' and text()='Домашний интернет']")
    private WebElement homeInternetOption;
    @FindBy(xpath = "//p[@class='select__option' and text()='Рассрочка']")
    private WebElement installmentOption;
    @FindBy(xpath = "//p[@class='select__option' and text()='Задолженность']")
    private WebElement arrearsOption;

    // Поля раздела "Услуги связи"
    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phoneInput;
    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sumInput;
    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement emailInput;

    // Поля раздела "Домашний интернет"
    @FindBy(xpath = "//input[@id='internet-phone']")
    private WebElement phoneInternetInput;
    @FindBy(xpath = "//input[@id='internet-sum']")
    private WebElement sumInternetInput;
    @FindBy(xpath = "//input[@id='internet-email']")
    private WebElement emailInternetInput;

    // Поля раздела "Рассрочка"
    @FindBy(xpath = "//input[@id='score-instalment']")
    private WebElement scoreInstalmentInput;
    @FindBy(xpath = "//input[@id='instalment-sum']")
    private WebElement sumInstalmentInput;
    @FindBy(xpath = "//input[@id='instalment-email']")
    private WebElement emailInstalmentInput;

    // Поля раздела "Задолженность"
    @FindBy(xpath = "//input[@id='score-arrears']")
    private WebElement scoreArrearsInput;
    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sumArrearsInput;
    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement emailArrearsInput;

    // Конструктор для инициализации элементов (ленивая инициализация)
    public DropDownList(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        this.actions = new Actions(driver); // Инициализация Actions
        PageFactory.initElements(driver, this);
    }

    // Выпадающий список
    public void clickSelectHeader() {
        wait.until(ExpectedConditions.elementToBeClickable(selectHeader)).click();
    }

    // Клик на "Услуги связи" в выпадающем списке через класс Actions
    public void clickOnServicesOption() {
        wait.until(ExpectedConditions.visibilityOf(servicesOption));
        actions.moveToElement(servicesOption).click().perform();
    }

    // Клик на "Домашний интернет" в выпадающем списке через класс Actions
    public void clickOnHomeInternetOption() {
        wait.until(ExpectedConditions.visibilityOf(homeInternetOption));
        actions.moveToElement(homeInternetOption).click().perform();
    }

    // Клик на "Рассрочку" в выпадающем списке через класс Actions
    public void clickOnInstallmentOption() {
        wait.until(ExpectedConditions.visibilityOf(installmentOption));
        actions.moveToElement(installmentOption).click().perform();
    }

    // Клик на "Задолженность" в выпадающем списке через класс Actions
    public void clickOnArrearsOption() {
        wait.until(ExpectedConditions.visibilityOf(arrearsOption));
        actions.moveToElement(arrearsOption).click().perform();
    }

    // Получаем текст из поля "номер телефона" для услуг связи
    public String getPhonePlaceholderText() {
        return phoneInput.getAttribute("placeholder");
    }

    // Получаем текст из поля "сумма" для услуг связи
    public String getSumPlaceholderText() {
        return sumInput.getAttribute("placeholder");
    }

    // Получаем текст из поля "E-mail" для услуг связи
    public String getEmailPlaceholderText() {
        return emailInput.getAttribute("placeholder");
    }

    // Получаем текст из поля "Телефон" для домашнего интернета
    public String getPhoneInternetPlaceholderText() {
        return phoneInternetInput.getAttribute("placeholder");
    }

    // Получаем текст из поля "Сумма" для домашнего интернета
    public String getSumInternetPlaceholderText() {
        return sumInternetInput.getAttribute("placeholder");
    }

    // Получаем текст из поля "E-mail" для домашнего интернета
    public String getEmailInternetPlaceholderText() {
        return emailInternetInput.getAttribute("placeholder");
    }

    // Получаем текст из поля "Счет" для рассрочки
    public String getScoreInstalmentPlaceholderText() {
        return scoreInstalmentInput.getAttribute("placeholder");
    }

    // Получаем текст из поля "Сумма" для рассрочки
    public String getSumInstalmentPlaceholderText() {
        return sumInstalmentInput.getAttribute("placeholder");
    }

    // Получаем текст из поля "E-mail" для рассрочки
    public String getEmailInstalmentPlaceholderText() {
        return emailInstalmentInput.getAttribute("placeholder");
    }

    // Получаем текст из поля "Счет" для задолженности
    public String getScoreArrearsPlaceholderText() {
        return scoreArrearsInput.getAttribute("placeholder");
    }

    // Получаем текст из поля "Сумма" для задолженности
    public String getSumArrearsPlaceholderText() {
        return sumArrearsInput.getAttribute("placeholder");
    }

    // Получаем текст из поля "E-mail" для задолженности
    public String getEmailArrearsPlaceholderText() {
        return emailArrearsInput.getAttribute("placeholder");
    }
}