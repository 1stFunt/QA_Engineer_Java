package Lesson_15_16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MainTests extends BaseTest {
    private MainPage mainPage;
    private DropDownList dropDownList;
    private PaymentWindow paymentWindow;

    @BeforeEach
    @Override
    public void setupTest() {
        super.setupTest(); // Инициализация драйвера и wait
        dropDownList = new DropDownList(driver, wait); // Инициализация DropDownList
        mainPage = new MainPage(driver, wait); // Инициализация MainPage
        paymentWindow = new PaymentWindow(driver, wait); // Инициализация PaymentWindow
        mainPage.clickRejectCookies(); // Выполняем действия на странице
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
        paymentWindow.switchToPaymentFrame(); // Переключение на фрейм окна оплаты
        assertTrue(paymentWindow.getPriceText().contains(expectedSum.trim() + " BYN"),
                "Текст на странице карты не содержит сумму и валюту.");
    }

    // 2.1 Проверка надписей полей раздела "Услуги связи"
    @Test
    public void testServicesFieldsText() {
        dropDownList.clickSelectHeader();
        dropDownList.clickOnServicesOption(); // Кликаем по "Услуги связи"
        assertAll("Проверки текста полей для услуг связи",
                () -> assertEquals("Номер телефона", dropDownList.getPhonePlaceholderText(),
                        "Текст плейсхолдера для номера телефона неверный."),
                () -> assertEquals("Сумма", dropDownList.getSumPlaceholderText(),
                        "Текст плейсхолдера для суммы неверный."),
                () -> assertEquals("E-mail для отправки чека", dropDownList.getEmailPlaceholderText(),
                        "Текст плейсхолдера для электронной почты неверный.")
        );
    }

    // Проверка надписей полей раздела "Домашний интернет"
    @Test
    public void testInternetFieldsText() {
        dropDownList.clickSelectHeader();
        dropDownList.clickOnHomeInternetOption(); // Кликаем по "Домашний интернет"
        assertAll("Проверки текста полей для домашнего интернета",
                () -> assertEquals("Номер абонента", dropDownList.getPhoneInternetPlaceholderText(),
                        "Текст плейсхолдера для телефона неверный."),
                () -> assertEquals("Сумма", dropDownList.getSumInternetPlaceholderText(),
                        "Текст плейсхолдера для суммы неверный."),
                () -> assertEquals("E-mail для отправки чека", dropDownList.getEmailInternetPlaceholderText(),
                        "Текст плейсхолдера для электронной почты неверный.")
        );
    }

    // Проверка надписей полей раздела "Рассрочка"
    @Test
    public void testInstalmentFieldsText() {
        dropDownList.clickSelectHeader();
        dropDownList.clickOnInstallmentOption(); // Кликаем по "Рассрочка"
        assertAll("Проверки текста полей для рассрочки",
                () -> assertEquals("Номер счета на 44", dropDownList.getScoreInstalmentPlaceholderText(),
                        "Текст плейсхолдера для счета неверный."),
                () -> assertEquals("Сумма", dropDownList.getSumInstalmentPlaceholderText(),
                        "Текст плейсхолдера для суммы неверный."),
                () -> assertEquals("E-mail для отправки чека", dropDownList.getEmailInstalmentPlaceholderText(),
                        "Текст плейсхолдера для электронной почты неверный.")
        );
    }

    // Проверка надписей полей раздела "Задолженность"
    @Test
    public void testArrearsFieldsText() {
        dropDownList.clickSelectHeader();
        dropDownList.clickOnArrearsOption(); // Кликаем по "Задолженность"
        assertAll("Проверки текста полей для задолженности",
                () -> assertEquals("Номер счета на 2073", dropDownList.getScoreArrearsPlaceholderText(),
                        "Текст плейсхолдера для счета неверный."),
                () -> assertEquals("Сумма", dropDownList.getSumArrearsPlaceholderText(),
                        "Текст плейсхолдера для суммы неверный."),
                () -> assertEquals("E-mail для отправки чека", dropDownList.getEmailArrearsPlaceholderText(),
                        "Текст плейсхолдера для электронной почты неверный.")
        );
    }

    // 2.2 Проверяем отображение суммы в окне и на кнопке
    @Test
    public void testInputFieldSum() throws InterruptedException {
        mainPage.enterPhoneNumber("297777777");
        String expectedSum = "100.00";
        mainPage.enterSum(expectedSum);
        mainPage.enterEmail("funt_88@mail.ru");
        mainPage.clickContinueButton();
        paymentWindow.switchToPaymentFrame(); // Переключение на фрейм окна оплаты
        assertAll("Проверки суммы и текста кнопки",
                () -> assertTrue(paymentWindow.getPriceText().contains(expectedSum.trim() + " BYN"),
                        "Текст на странице карты не содержит сумму и валюту."),
                () -> assertEquals(paymentWindow.getPayButtonText(), "Оплатить " + expectedSum.trim() + " BYN",
                        "Текст кнопки не соответствует ожидаемому значению.")
        );
    }

    // Проверяем наличие иконок платёжных систем
    @ParameterizedTest
    @ValueSource(strings = {"visa", "mastercard", "belkart", "mir", "maestro"})
    public void testPaymentLogos(String logo) throws InterruptedException {
        // Вводим данные перед проверкой логотипов
        mainPage.enterPhoneNumber("297777777");
        mainPage.enterSum("100");
        mainPage.enterEmail("funt_88@mail.ru");
        mainPage.clickContinueButton();
        paymentWindow.switchToPaymentFrame(); // Переключение на фрейм окна оплаты
        assertNotNull(paymentWindow.getPaymentLogoBySystem(logo),
                "Логотип " + logo + " не найден на странице.");
        assertTrue(paymentWindow.getPaymentLogoBySystem(logo).isDisplayed(),
                "Логотип " + logo + " не отображается на странице.");
    }

    // Проверяем верное отображение номера телефона
    @Test
    public void testPhoneNumberInPaymentDescription() throws InterruptedException {
        String phoneNumber = "297777777"; // Вводим переменную с номером телефона
        mainPage.enterPhoneNumber(phoneNumber);
        mainPage.enterSum("100");
        mainPage.enterEmail("funt_88@mail.ru");
        mainPage.clickContinueButton();
        paymentWindow.switchToPaymentFrame(); // Переключение на фрейм окна оплаты
        assertTrue(paymentWindow.getPaymentDescriptionText().contains(phoneNumber),
                "Описание оплаты не соответствует введённому номеру телефона.");
    }

    // Проверяем соответствие текста в пустых полях окна оплаты
    @Test
    public void testPaymentFieldsPlaceholders() throws InterruptedException {
        mainPage.enterPhoneNumber("297777777");
        mainPage.enterSum("100");
        mainPage.enterEmail("funt_88@mail.ru");
        mainPage.clickContinueButton();
        paymentWindow.switchToPaymentFrame(); // Переключение на фрейм окна оплаты
        // Проверка соответствия текстов полей
        assertAll("Проверки соответствия текстов полей",
                () -> assertEquals("Номер карты", paymentWindow.getCreditCardLabelText(),
                        "Текст метки для номера карты неверный."),
                () -> assertEquals("Срок действия", paymentWindow.getExpirationDateLabelText(),
                        "Текст метки для срока действия неверный."),
                () -> assertEquals("CVC", paymentWindow.getCvcLabelText(), "Текст метки для CVC неверный."),
                () -> assertEquals("Имя держателя (как на карте)", paymentWindow.getCardHolderLabelText(),
                        "Текст метки для имени держателя неверный.")
        );
    }

    @AfterEach
    @Override
    public void tearDown() {
        super.tearDown(); // Вызываем tearDown из BaseTest
    }
}