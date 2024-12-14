import cards.Card;
import cards.Deck;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardDeckExample {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle(); // Перетасовка колоды

        // Сдача нескольких карт
       // Card card1 = deck.dealCard();
       // Card card2 = deck.dealCard();
       // Card card3 = deck.dealCard();
       // System.out.println("Сданные карты: " + card1 + ", " + card2);

        // Возвращение карты в колоду
       // deck.returnCard(card1);
       // System.out.println("Количество оставшихся карт в колоде: " + deck.remainingCards());

        // Попытка вернуть дубликат карты
       // deck.returnCard(card1); // Эта карта уже есть в колодe

       Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество сдаваемых карт: ");
        
        try {
            int numberOfCards = Integer.parseInt(scanner.nextLine());
            if (numberOfCards < 1 || numberOfCards > deck.remainingCards()) {
                System.out.println("Ошибка: количество карт должно быть от 1 до " + deck.remainingCards());
            } else {
                List<Card> dealtCards = new ArrayList<>();
                System.out.println("Сданные карты:");
                for (int i = 0; i < numberOfCards; i++) {
                    Card dealtCard = deck.dealCard();
                    dealtCards.add(dealtCard);
                    System.out.println(dealtCard);
                }
                System.out.println("Количество оставшихся карт в колоде: " + deck.remainingCards());

                // Попытка вернуть сданные карты в колоду
                for (Card card : dealtCards) {
                    System.out.println("Возвращаем карту в колоду: " + card);
                    deck.returnCard(card); // Возвращаем карту в колоду
                }

                // Попытка вернуть дубликат
                System.out.println("Попытка вернуть дубликат карты: " + dealtCards.get(0));
                deck.returnCard(dealtCards.get(0)); // Возвращаем ту же карту снова
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено неверное значение. Пожалуйста, введите целое число.");
        } finally {
            scanner.close();
        }

    }
}