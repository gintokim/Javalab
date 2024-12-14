package zoogame.zoo.services;

import zoogame.zoo.animals.Animal;

public class FeedingService {
    public void feedAnimal(Animal animal) {
        System.out.println("Кормим " + animal.getName() + ":");
        animal.eat();
    }
}
