package zoogame.zoo.enclosures;

import zoogame.zoo.animals.Animal;

public class BirdEnclosure extends Enclosure {
    @Override
    public void displayAnimals() {
        System.out.println("В вольере для птиц:");
        for (Animal animal : animals) {
            System.out.println("- " + animal.getName());
        }
    }
}
