

import calculator.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.CalculatorUI;

public class CalculatorApp {
    private static Calculator calculator = new Calculator();
    private static CalculatorUI calculatorUI = new CalculatorUI();
    private static boolean isSecondValue = false; // Флаг для отслеживания второго значения

    public static void main(String[] args) {
        calculatorUI.addButtonListener(new ButtonClickListener());
        calculatorUI.setVisible(true);
    }

    static class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                // Если нажата цифра, добавляем ее к дисплею
                if (isSecondValue) {
                    calculatorUI.setDisplay(command); // Сбрасываем дисплей для второго значения
                    isSecondValue = false; // Сбрасываем флаг
                } else {
                    calculatorUI.setDisplay(calculatorUI.getDisplay() + command);
                }
            } else if (command.equals("C")) {
                // Если нажата кнопка "C", очищаем дисплей
                calculatorUI.setDisplay("");
                calculator.setNum1(0);
                calculator.setNum2(0);
                isSecondValue = false; // Сбрасываем флаг
            } else if (command.equals("=")) {
                                // Если нажата кнопка "=", выполняем расчет
                                try {
                                    calculator.setNum2(Double.parseDouble(calculatorUI.getDisplay()));
                                    double result = calculator.calculate();
                                    calculatorUI.setDisplay(String.valueOf(result));
                                    // Устанавливаем флаг для следующего ввода
                                    isSecondValue = true; // Устанавливаем флаг, чтобы следующее значение сбрасывало дисплей
                                } catch (Exception ex) {
                                    calculatorUI.setDisplay("Ошибка");
                                }
                            } else {
                                // Если нажата операция, сохраняем текущее число и оператор
                                if (!calculatorUI.getDisplay().isEmpty()) {
                                    calculator.setNum1(Double.parseDouble(calculatorUI.getDisplay()));
                                    calculator.setOperator(command);
                                    isSecondValue = true; // Устанавливаем флаг для второго значения
                                }
                            }
                        }
                    }
                }
                

