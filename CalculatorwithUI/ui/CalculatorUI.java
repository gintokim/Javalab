package ui;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorUI extends JFrame {
    private JTextField display;

    public CalculatorUI() {
        // Настройка окна
        setTitle("Калькулятор");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Поле для отображения
        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Панель кнопок
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        // Кнопки
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    public void setDisplay(String text) {
        display.setText(text);
    }

    public String getDisplay() {
        return display.getText();
    }

    public void addButtonListener(ActionListener listener) {
        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof JPanel) {
                for (Component button : ((JPanel) comp).getComponents()) {
                    if (button instanceof JButton) {
                        ((JButton) button).addActionListener(listener);
                    }
                }
            }
        }
    }
}
