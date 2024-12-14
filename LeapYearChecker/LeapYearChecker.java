import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите год: ");
        
        try {
            int year = Integer.parseInt(scanner.nextLine());
            if (isLeapYear(year)) {
                System.out.println(year + " является високосным годом.");
            } else {
                System.out.println(year + " не является високосным годом.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено неверное значение. Пожалуйста, введите целое число.");
        } finally {
            scanner.close();
        }
    }

    // Метод для проверки, является ли год високосным
    public static boolean isLeapYear(int year) {
        // Год является високосным, если:
        // 1. Делится на 4, но не делится на 100, или
        // 2. Делится на 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
