package zoogame.zoo.enclosures;

import zoogame.zoo.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Enclosure {
    protected List<Animal> animals;

    public Enclosure() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public abstract void displayAnimals();
}
