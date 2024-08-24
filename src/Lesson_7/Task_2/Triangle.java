package Lesson_7.Task_2;

class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;
    private String fillColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
