package Lesson_11;

public class Main {
    public static void main(String[] args) {
        // Task 1
        String[] words = {
                "яблоко", "банан", "апельсин", "яблоко", "киви", "банан",
                "виноград", "груша", "киви", "яблоко", "персик", "манго",
                "виноград", "апельсин", "персик"
        };

        // Создаем объект WordProcessor и запускаем метод processWords
        UniqueWords wordProcessor = new UniqueWords();
        wordProcessor.processWords(words);

        // Разделяем вывод
        System.out.println("\n--- Телефонный справочник ---");

        // Task 2
        // Создаем объект PhoneBook
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи в телефонный справочник
        phoneBook.add("Пасько", "8-918-12345678");
        phoneBook.add("Ночевной", "8-918-7777777");
        phoneBook.add("Волчинский", "8-918-5555555");
        phoneBook.add("Колмык", "8-918-4444444"); // Добавляем второй номер для "Иванов"

        // Поиск номеров по фамилии
        System.out.println("Телефоны Пасько: " + phoneBook.get("Пасько"));
        System.out.println("Телефоны Ночевной: " + phoneBook.get("Ночевной"));
        System.out.println("Телефоны Волчинский: " + phoneBook.get("Волчинский"));
        System.out.println("Телефоны Крылов: " + phoneBook.get("Крылов"));
    }
}

