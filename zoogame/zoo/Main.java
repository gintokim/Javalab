package zoogame.zoo;

import zoogame.zoo.animals.Lion;
import zoogame.zoo.animals.Parrot;
import zoogame.zoo.enclosures.LionEnclosure;
import zoogame.zoo.enclosures.BirdEnclosure;
import zoogame.zoo.services.FeedingService;
import zoogame.zoo.services.CleaningService;

public class Main {
    public static void main(String[] args) {
        // Создаем зоопарк
        Zoo zoo = new Zoo();

        // Создаем вольеры
        LionEnclosure lionEnclosure = new LionEnclosure();
        BirdEnclosure birdEnclosure = new BirdEnclosure();

        // Создаем животных
        Lion lion = new Lion("Лев", 5);
        Parrot parrot = new Parrot("Попугай", 2);

        // Добавляем животных в вольеры
        lionEnclosure.addAnimal(lion);
        birdEnclosure.addAnimal(parrot);

        // Добавляем вольеры в зоопарк
        zoo.addEnclosure(lionEnclosure);
        zoo.addEnclosure(birdEnclosure);

        // Показываем всех животных в зоопарке
        zoo.showAllAnimals();

        // Создаем сервисы
        FeedingService feedingService = new FeedingService();
        CleaningService cleaningService = new CleaningService();

        // Кормим животных
        feedingService.feedAnimal(lion);
        feedingService.feedAnimal(parrot);

        // Убираем за животными
        cleaningService.cleanEnclosure(lion);
        cleaningService.cleanEnclosure(parrot);
    }
}