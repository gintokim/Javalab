package zoogame.zoo.animals;

public abstract class Animal implements AnimalBehavior {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name; // Геттер для поля name
    }

    @Override
    public abstract void makeSound();
}
