package Lesson_7.Task_1;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isSatiated = false;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        System.out.println(distance <= 200 ? name + " пробежал " + distance + " м." : name + " не смог пробежать "
                + distance + " м.");
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public boolean eat(Bowl bowl, int amount) {
        boolean canEat = bowl.getFoodAmount() >= amount;
        if (canEat) {
            bowl.decreaseFood(amount);
            isSatiated = true;
        }
        return isSatiated;
    }

    public static int getCatCount() {
        return catCount;
    }
}