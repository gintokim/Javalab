import java.util.Scanner;

public class procentcalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начальную сумму (число1): ");
        double principal = scanner.nextDouble();

        System.out.print("Введите процент (в виде десятичной дроби, например, 0.05 для 5%): ");
        double rate = scanner.nextDouble();

        System.out.print("Введите количество периодов: ");
        int periods = scanner.nextInt();

        double finalAmount = calculateCompoundInterest(principal, rate, periods);
        System.out.printf("Конечная сумма после %d периодов: %.2f%n", periods, finalAmount);

     
        System.out.print("Введите начальную сумму (число1) для обратного действия: ");
        double initialAmount = scanner.nextDouble();

        System.out.print("Введите конечную сумму (число2) для обратного действия: ");
        double targetAmount = scanner.nextDouble();

        System.out.print("Введите количество периодов для обратного действия: ");
        int nPeriods = scanner.nextInt();

       
        double requiredRate = calculateRequiredRate(initialAmount, targetAmount, nPeriods);
        System.out.printf("Необходимый процент для достижения %.2f из %.2f за %d периодов: %.2f%%%n",
                targetAmount, initialAmount, nPeriods, requiredRate * 100);
    }

    // Метод для вычисления сложного процента A = P x (1+r)^n
    public static double calculateCompoundInterest(double principal, double rate, int periods) {
        return principal * Math.pow(1 + rate, periods);
    }

    // Метод для вычисления необходимого процента r = (A/P)^(1/n)-1
    public static double calculateRequiredRate(double initialAmount, double targetAmount, int periods) {
        return Math.pow(targetAmount / initialAmount, 1.0 / periods) - 1;
    }
}
