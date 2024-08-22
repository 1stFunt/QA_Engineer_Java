package Lesson_6;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        printEmployeeInfo();    // Задание 1, 2
        printParkInfo();    // Задание 3
    }

    private static void printEmployeeInfo() {
        // Создать массив из 5 сотрудников
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Sergey", "Nochevnoy", "Alekseevich", "QC",
                "sergey88@mail.ru", "+79187777777", new BigDecimal("100000"), 35);
        employees[1] = new Employee("Ivan", "Ivanov", "Petrovich", "Developer",
                "ivan.ivanov@mail.ru", "+79185555555", new BigDecimal("120000"), 30);
        employees[2] = new Employee("Maria", "Sidorova", "Ivanovna", "Manager",
                "maria.sidorova@mail.ru", "+79186666666", new BigDecimal("110000"), 28);
        employees[3] = new Employee("Petr", "Petrov", "Nikolaevich", "Designer",
                "petr.petrov@mail.ru", "+79187777788", new BigDecimal("90000"), 32);
        employees[4] = new Employee("Elena", "Smirnova", "Sergeevna", "HR",
                "elena.smirnova@mail.ru", "+79189999999", new BigDecimal("95000"), 29);
        System.out.println("Employee Information:");
        for (Employee employee : employees) {
            employee.printInfo();
        }
    }

    private static void printParkInfo() {
        Park park = new Park();
        park.addAttraction("Roller Coaster", "10:00 - 18:00", 25.0);
        park.addAttraction("Snake", "10:00 - 15:00", 30.0);
        park.printAllAttractions();
    }
}