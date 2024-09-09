package Lesson_11;

import java.util.*;

/*
Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово
(реализовать с использованием коллекций)
 */
public class UniqueWords {
    // Метод для нахождения уникальных слов и подсчета вхождений
    public void processWords(String[] words) {

        // Используем HashSet для хранения уникальных слов
        Set<String> uniqueWords = new HashSet<>();

        // Используем HashMap для подсчета количества вхождений каждого слова
        Map<String, Integer> wordCount = new HashMap<>();

        // Проходим по массиву слов
        for (String word : words) {
            // Добавляем слово в Set уникальных слов
            uniqueWords.add(word);

            // Увеличиваем счетчик для текущего слова в HashMap
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Преобразуем уникальные слова в список и выводим его
        List<String> uniqueWordsList = new ArrayList<>(uniqueWords);
        System.out.println("Список уникальных слов: " + uniqueWordsList);

        // Выводим количество вхождений каждого слова
        System.out.println("Количество вхождений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
