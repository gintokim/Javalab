package zoogame.zoo.services;

import zoogame.zoo.animals.Animal;

public class CleaningService {
    public void cleanEnclosure(Animal animal) {
        System.out.println("Убираем за " + animal.getName());
    }
}
