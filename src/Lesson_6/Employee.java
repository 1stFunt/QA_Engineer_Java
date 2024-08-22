package Lesson_6;

import java.math.BigDecimal;

/*
Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст. Конструктор класса должен
заполнять эти поля при создании объекта. Внутри класса "Сотрудник" написать метод, который выводит информацию об
объекте в консоль.
 */
public class Employee {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private String position;
    private String email;
    private String phoneNumber;
    private BigDecimal salary;
    private int age;

    public Employee(String firstName, String lastName, String middleName, String position, String email,
                    String phoneNumber, BigDecimal salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("Full Name: " + getLastName() + " " + getFirstName() + " " + getMiddleName());
        System.out.println("Position: " + getPosition());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Salary: " + getSalary());
        System.out.println("Age: " + getAge());
        System.out.println();
    }
}