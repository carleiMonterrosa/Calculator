import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    // Componentes de la GUI
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;

    // Variables para almacenar los números y la operación
    private double num1, num2;
    private char operator;

    public Calculator() {
        // Configuración de la ventana
        setTitle("Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Campo de visualización
        displayField = new JTextField();
        displayField.setEditable(false); // No editable por el usuario directamente
        displayField.setFont(new Font("Arial", Font.PLAIN, 24)); // Fuente grande para mejor visibilidad
        add(displayField, BorderLayout.NORTH);

        // Panel para los botones numéricos y de operaciones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 grid con espacio entre botones

        // Botones numéricos
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));
            numberButtons[i].addActionListener(this); // Añadir ActionListener a cada botón
            buttonPanel.add(numberButtons[i]); // Añadir botón al panel
        }

        // Botones de operaciones
        addButton = new JButton("+");
        addButton.setFont(new Font("Arial", Font.PLAIN, 24));
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        subtractButton = new JButton("-");
        subtractButton.setFont(new Font("Arial", Font.PLAIN, 24));
        subtractButton.addActionListener(this);
        buttonPanel.add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.setFont(new Font("Arial", Font.PLAIN, 24));
        multiplyButton.addActionListener(this);
        buttonPanel.add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.setFont(new Font("Arial", Font.PLAIN, 24));
        divideButton.addActionListener(this);
        buttonPanel.add(divideButton);

        equalsButton = new JButton("=");
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 24));
        equalsButton.addActionListener(this);
        buttonPanel.add(equalsButton);

        clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 24));
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        // Añadir panel de botones al centro del BorderLayout
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                displayField.setText(displayField.getText() + i);
                return;
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(displayField.getText());
            operator = '+';
            displayField.setText("");
        } else if (e.getSource() == subtractButton) {
            num1 = Double.parseDouble(displayField.getText());
            operator = '-';
            displayField.setText("");
        } else if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(displayField.getText());
            operator = '*';
            displayField.setText("");
        } else if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(displayField.getText());
            operator = '/';
            displayField.setText("");
        } else if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(displayField.getText());
            double result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Error: División por cero no permitida.");
                        displayField.setText("");
                        return;
                    }
                    break;
            }
            displayField.setText(String.valueOf(result));
        } else if (e.getSource() == clearButton) {
            displayField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true); // Hacer visible la ventana
        });
    }
}
