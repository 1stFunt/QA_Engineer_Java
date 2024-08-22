package Lesson_6;

/*
Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст. Конструктор класса должен
заполнять эти поля при создании объекта. Внутри класса "Сотрудник" написать метод, который выводит информацию об
объекте в консоль.
 */
public class Employee {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final String position;
    private final String email;
    private final String phoneNumber;
    private final double salary;
    private final int age;

    public Employee(String firstName, String lastName, String middleName, String position, String email,
                    String phoneNumber, double salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Full Name: " + lastName + " " + firstName + " " + middleName);
        System.out.println("Position: " + position);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
        System.out.println();
    }
}