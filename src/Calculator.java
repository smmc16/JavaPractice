import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberBtns = new JButton[10];
    JButton[] functionBtns = new JButton[9];
    JButton add, subtract, multiply, divide;
    JButton decimal, equals, del, clear, neg;
    JPanel panel;

    Font myFont = new Font("Arial",Font.BOLD,30);

    double num1=0, num2=0, result=0;
    char op;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 450);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(25, 25, 250, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        decimal = new JButton(".");
        equals = new JButton("=");
        del = new JButton("DEL");
        clear = new JButton("C");
        neg = new JButton("(-)");

        functionBtns[0] = add;
        functionBtns[1] = subtract;
        functionBtns[2] = multiply;
        functionBtns[3] = divide;
        functionBtns[4] = decimal;
        functionBtns[5] = equals;
        functionBtns[6] = del;
        functionBtns[7] = clear;
        functionBtns[8] = neg;

        for(int i = 0; i < 9; i++) {
            functionBtns[i].addActionListener(this);
            functionBtns[i].setFont(myFont);
            functionBtns[i].setFocusable(true);
        }

        for(int i = 0; i < 10; i++) {
            numberBtns[i] = new JButton(String.valueOf(i));
            numberBtns[i].addActionListener(this);
            numberBtns[i].setFont(myFont);
            numberBtns[i].setFocusable(false);
        }

        del.setBounds(25, 350, 100, 50);
        clear.setBounds(175, 350, 100, 50);
        neg.setBounds(125, 350, 50, 50);

        panel = new JPanel();
        panel.setBounds(25, 85, 250, 250);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberBtns[1]);
        panel.add(numberBtns[2]);
        panel.add(numberBtns[3]);
        panel.add(add);
        panel.add(numberBtns[4]);
        panel.add(numberBtns[5]);
        panel.add(numberBtns[6]);
        panel.add(subtract);
        panel.add(numberBtns[7]);
        panel.add(numberBtns[8]);
        panel.add(numberBtns[9]);
        panel.add(multiply);
        panel.add(decimal);
        panel.add(numberBtns[0]);
        panel.add(equals);
        panel.add(divide);

        frame.add(panel);
        frame.add(del);
        frame.add(neg);
        frame.add(clear);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
       Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberBtns[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decimal) {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == add) {
            num1 = Double.parseDouble(textField.getText());
            op = '+';
            textField.setText("");
        }
        if(e.getSource() == subtract) {
            num1 = Double.parseDouble(textField.getText());
            op = '-';
            textField.setText("");
        }
        if(e.getSource() == multiply) {
            num1 = Double.parseDouble(textField.getText());
            op = '*';
            textField.setText("");
        }
        if(e.getSource() == divide) {
            num1 = Double.parseDouble(textField.getText());
            op = '/';
            textField.setText("");
        }
        if(e.getSource() == equals) {
            num2 = Double.parseDouble(textField.getText());

            switch(op) {
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
                    result = num1 / num2;
                break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clear) {
            textField.setText("");
        }
        if(e.getSource() == del) {
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length() - 1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if(e.getSource() == neg) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
