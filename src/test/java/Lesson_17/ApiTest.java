package Lesson_17;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    @Test
    public void testGetRequest() {
        // Выполняем GET-запрос
        given()
                .baseUri("https://postman-echo.com") // Установка базового URL
                .when().get("/get?foo1=bar1&foo2=bar2") // Параметры передаются в URL
                .then().log().body() // Логирование тела ответа
                .statusCode(200) // Проверка статуса кода
                .and().body("args.foo1", equalTo("bar1")) // Проверка аргумента foo1
                .body("args.foo2", equalTo("bar2")); // Проверка аргумента foo2
    }
}
// В процессе, закончу через часик. Спасибо! =)