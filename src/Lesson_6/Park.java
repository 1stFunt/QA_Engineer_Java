package Lesson_6;

/*
Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
времени их работы и стоимость.
 */
public class Park {
    public static class Attraction {
        private final String attractionName;
        private final String openingHours;
        private final double price;

        public Attraction(String attractionName, String openingHours, double price) {
            this.attractionName = attractionName;
            this.openingHours = openingHours;
            this.price = price;
        }

        public void printAttractionInfo() {
            System.out.println("Attraction: " + attractionName);
            System.out.println("Opening Hours: " + openingHours);
            System.out.println("Price: $" + price);
            System.out.println();
        }
    }
}