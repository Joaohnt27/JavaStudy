import javax.swing.*;
import java.awt.*;

public class CalculadoraScreen extends JFrame {

    CalculadoraScreen(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 600);
        setTitle("Calculadora");

        JTextField display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(4, 4, 5, 5);
        panel.setLayout(layout);

        JButton btn1 = new JButton("1");
        panel.add(btn1);
        JButton btn2 = new JButton("2");
        panel.add(btn2);

        add(panel);
        setVisible(true);
    }
}
