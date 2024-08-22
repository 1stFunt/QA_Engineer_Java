package Lesson_6;

import java.util.ArrayList;
import java.util.List;

/*
Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
времени их работы и стоимость.
 */
public class Park {
    private final List<Attraction> attractions = new ArrayList<>();

    private class Attraction {
        private final String attractionName;
        private String openingHours;
        private double price;

        public Attraction(String attractionName, String openingHours, double price) {
            this.attractionName = attractionName;
            this.openingHours = openingHours;
            this.price = price;
        }

        public String getAttractionName() {
            return attractionName;
        }

        public String getOpeningHours() {
            return openingHours;
        }

        public double getPrice() {
            return price;
        }

        public void printAttractionInfo() {
            System.out.println("Attraction: " + getAttractionName());
            System.out.println("Opening Hours: " + getOpeningHours());
            System.out.println("Price: $" + getPrice());
            System.out.println();
        }
    }

    public void addAttraction(String name, String hours, double price) {
        Attraction newAttraction = new Attraction(name, hours, price);
        attractions.add(newAttraction);
    }

    public void printAllAttractions() {
        for (Attraction attraction : attractions) {
            attraction.printAttractionInfo();
        }
    }
}