import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener {
    JTextField t;
    JButton[] numberButtons = new JButton[10];
    JButton badd, bsub, bmul, bdiv, bdec, beql, bclr;
    double a = 0, b = 0, result = 0;
    char operator;

    Calculator() {
        setTitle("Calculator");

        t = new JTextField();
        t.setPreferredSize(new Dimension(400, 50));
        t.setFont(new Font("Arial", Font.BOLD, 24));
        t.setHorizontalAlignment(SwingConstants.RIGHT);
        t.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 24));
            numberButtons[i].addActionListener(this);
        }

        badd = new JButton("+");
        bsub = new JButton("-");
        bmul = new JButton("*");
        bdiv = new JButton("/");
        bdec = new JButton(".");
        beql = new JButton("=");
        bclr = new JButton("C");

        JButton[] functionButtons = {badd, bsub, bmul, bdiv, bdec, beql, bclr};

        for (JButton btn : functionButtons) {
            btn.setFont(new Font("Arial", Font.BOLD, 24));
            btn.addActionListener(this);
        }

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(badd);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(bsub);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(bmul);
        panel.add(bdec);
        panel.add(numberButtons[0]);
        panel.add(beql);
        panel.add(bdiv);

        setLayout(new BorderLayout());
        add(t, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(bclr, BorderLayout.SOUTH);

        bclr.setPreferredSize(new Dimension(400, 50));
        bclr.setFont(new Font("Arial", Font.BOLD, 24));

        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                t.setText(t.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == bdec) {
            if (!t.getText().contains(".")) {
                t.setText(t.getText().concat("."));
            }
        }

        if (e.getSource() == badd) {
            a = Double.parseDouble(t.getText());
            operator = '+';
            t.setText("");
        }
        if (e.getSource() == bsub) {
            a = Double.parseDouble(t.getText());
            operator = '-';
            t.setText("");
        }
        if (e.getSource() == bmul) {
            a = Double.parseDouble(t.getText());
            operator = '*';
            t.setText("");
        }
        if (e.getSource() == bdiv) {
            a = Double.parseDouble(t.getText());
            operator = '/';
            t.setText("");
        }
        if (e.getSource() == beql) {
            b = Double.parseDouble(t.getText());
            switch (operator) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    if (b != 0) {
                        result = a / b;
                    } else {
                        t.setText("Error");
                        return;
                    }
                    break;
            }
            t.setText(String.valueOf(result));
            a = result;
        }
        if (e.getSource() == bclr) {
            t.setText("");
            a = b = result = 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
