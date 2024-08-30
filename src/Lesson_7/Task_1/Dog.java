package Lesson_7.Task_1;

public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        System.out.println(distance <= 500 ?
                (name + " пробежал " + distance + " м.") :
                (name + " не может пробежать " + distance + " м.")
        );
    }

    @Override
    public void swim(int distance) {
        System.out.println(distance <= 10 ? name + " проплыл" + distance + " м." : name + " не смог проплыть "
                + distance + " м.");
    }

    public static int getDogCount() {
        return dogCount;
    }
}
