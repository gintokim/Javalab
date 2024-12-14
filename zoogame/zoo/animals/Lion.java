package zoogame.zoo.animals;

public class Lion extends Mammal {
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(name + " ест мясо.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " спит.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " рычит.");
    }
}
