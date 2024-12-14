package zoogame.zoo;

import zoogame.zoo.enclosures.Enclosure;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Enclosure> enclosures;

    public Zoo() {
        this.enclosures = new ArrayList<>();
    }

    public void addEnclosure(Enclosure enclosure) {
        enclosures.add(enclosure);
    }

    public void showAllAnimals() {
        for (Enclosure enclosure : enclosures) {
            enclosure.displayAnimals();
        }
    }
}