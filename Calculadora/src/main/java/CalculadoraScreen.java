import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CalculadoraScreen extends JFrame implements ActionListener {
    private JTextField display;
    private String operador;
    private double num1;
    private double resultado;
    private boolean novoNumero;

    CalculadoraScreen() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar a aplicação e cancelar a execução do código
        setSize(400, 600); // Tamanho da aplicação
        setTitle("Calculadora"); // Título da aplicação

        display = new JTextField();
        display.setEditable(false); // Display da calculadora
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
        operador = "";
        novoNumero = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        double num2;
        
        if (comando.matches("[0-9]") || comando.equals(".")) {
            if (novoNumero) {
                display.setText(comando);
                novoNumero = false;
            } else if (!comando.equals(".") || !display.getText().contains(".")) {
                display.setText(display.getText() + comando);
            }
        } else if (comando.matches("[+\\*/]")) {
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operador = comando;
                novoNumero = true;
            }
        } else if (comando.equals("=")) {
            if (!operador.isEmpty() && !display.getText().isEmpty()) {
                num2 = Double.parseDouble(display.getText());
                switch (operador) {
                    case "+": resultado = num1 + num2; break;
                    case "-": resultado = num1 - num2; break;
                    case "*": resultado = num1 * num2; break;
                    case "/": resultado = (num2 == 0) ? Double.NaN : num1 / num2; break;
                }
                display.setText(new DecimalFormat("0.######").format(resultado));
                novoNumero = true;
                operador = "";
            }
        } else if (comando.equals("C")) {
            display.setText("");
            operador = "";
            num1 = num2 = resultado = 0;
            novoNumero = true;
        }
    }

    public static void main(String[] args) {
        new CalculadoraScreen();
    }
}
