package zoogame.zoo.animals;

public class Parrot extends Bird {
    public Parrot(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(name + " ест семена.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " спит.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Привет!");
    }
}
