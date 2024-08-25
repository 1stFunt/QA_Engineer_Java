package Lesson_8;

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера
 необходимо бросить исключение MyArraySizeExeption.
2. Далее метод должен пройтись по всем элементам массива преобразовать в int и просуммировать. Если в каком-то элементе
массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
исключение MyErrayDataExeption с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeExeption и MyErrayDataExeption
и вывести результат расчёта.
 */
public class Main {
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] invalidSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "ошибка", "@"},
                {"13", "14", "15", "16"}
        };

        ArrayProcessor processor = new ArrayProcessor();

        // Проверка для корректного массива
        try {
            int result = processor.sumArray(validArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        // Проверка для массива с неверным размером
        try {
            int result = processor.sumArray(invalidSizeArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        // Проверка для массива с некорректными данными
        try {
            int result = processor.sumArray(invalidDataArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
