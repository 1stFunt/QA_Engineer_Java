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
                .and().body("args.foo2", equalTo("bar2")); // Проверка аргумента foo2
    }

    @Test
    public void testPostRequest1() {
        // Выполняем POST-запрос
        given()
                .baseUri("https://postman-echo.com") // Установка базового URL
                .contentType("text/plain") // Установка типа контента
                .body("This is expected to be sent back as part of response body.") // Тело запроса
                .when().post("/post") // Выполняем POST-запрос
                .then().log().body() // Логирование тела ответа
                .statusCode(200) // Проверка статуса кода
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void testPostRequest2() {
        String jsonBody = "{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}"; // Создание JSON-объекта
        given()
                .baseUri("https://postman-echo.com") // Установка базового URL
                .contentType("application/json") // Установка типа контента
                .body(jsonBody) // Тело запроса в формате JSON
                .when().post("/post") // Выполняем POST-запрос
                .then().log().body() // Логирование тела ответа
                .statusCode(200) // Проверка статуса кода
                .and().body("json.foo1", equalTo("bar1")) // Проверка данных в ответе
                .and().body("json.foo2", equalTo("bar2")); // Проверка данных в ответе
    }

    @Test
    public void testPutRequest() {
        // Выполняем PUT-запрос
        given()
                .baseUri("https://postman-echo.com") // Установка базового URL
                .contentType("text/plain") // Установка типа контента
                .body("This is expected to be sent back as part of response body.") // Тело запроса
                .when().put("/put") // Выполняем PUT-запрос
                .then().log().body() // Логирование тела ответа
                .statusCode(200) // Проверка статуса кода
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void testPatchRequest() {
        // Выполняем PATCH-запрос
        given()
                .baseUri("https://postman-echo.com") // Установка базового URL
                .contentType("text/plain") // Установка типа контента
                .body("This is expected to be sent back as part of response body.") // Тело запроса
                .when().patch("/patch") // Выполняем PATCH-запрос
                .then().log().body() // Логирование тела ответа
                .statusCode(200) // Проверка статуса кода
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void testDeleteRequest() {
        // Выполняем DELETE-запрос
        String requestBody = "This is expected to be sent back as part of response body."; // Тело запроса
        given()
                .baseUri("https://postman-echo.com") // Установка базового URL
                .body(requestBody) // Устанавливаем тело запроса
                .contentType("text/plain") // Устанавливаем тип контента на text/plain
                .when().delete("/delete") // Выполняем DELETE-запрос
                .then().log().body() // Логирование тела ответа
                .statusCode(200) // Проверка статуса кода
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}