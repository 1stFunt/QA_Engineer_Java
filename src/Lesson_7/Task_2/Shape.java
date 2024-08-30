package Lesson_7.Task_2;

interface Shape {
    String getFillColor();

    String getBorderColor();

    default double getPerimeter() {
        throw new UnsupportedOperationException("Расчет периметра не реализован");
    }

    default double getArea() {
        throw new UnsupportedOperationException("Расчет площади не реализован");
    }
}
