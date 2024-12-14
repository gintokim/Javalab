package zoogame.zoo.enclosures;

import zoogame.zoo.animals.Animal;

public class LionEnclosure extends Enclosure {
    @Override
    public void displayAnimals() {
        System.out.println("В вольере для львов:");
        for (Animal animal : animals) {
            System.out.println("- " + animal.getName());
        }
    }
}
