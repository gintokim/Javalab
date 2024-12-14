package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards; // Список карт в колоде

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Создание колоды карт
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Метод для перетасовки колоды
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Метод для сдачи карты
    public Card dealCard() {
        if (cards.isEmpty()) {
            return null; // Если колода пуста, возвращаем null
        }
        return cards.remove(cards.size() - 1); // Удаляем и возвращаем последнюю карту
    }

    // Метод для возвращения карты в колоду
    public void returnCard(Card card) {
        // Проверка на дублирование
        if (!cards.contains(card)) {
            cards.add(card);
        } else {
            System.out.println("Эта карта уже есть в колоде: " + card);
        }
    }

    // Метод для получения количества оставшихся карт в колоде
    public int remainingCards() {
        return cards.size();
    }
}
