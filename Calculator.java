import java.awt.*;
import java.awt.event.*;

public class Calculator {
    public static void main(String[] args) {
        new calc();
    }
    public static class calc extends Frame {
        Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bPlus, bMinus, bMul, bDiv, bEqual, bMod, bSqrt, bSq, bLog, bPoint;
        TextField tf1, tf2, tfAns, selectedTF;
        String result;

        calc() {
            tf1 = new TextField("");
            tf2 = new TextField("");
            tfAns = new TextField("");

            tf1.setBounds(100, 60, 120, 20);
            tf2.setBounds(100, 120, 120, 20);
            tfAns.setBounds(100, 180, 120, 20);

            bPlus = new Button("+");
            bPlus.setBounds(105, 90, 20, 20);
            bMinus = new Button("-");
            bMinus.setBounds(135, 90, 20, 20);
            bMul = new Button("x");
            bMul.setBounds(165, 90, 20, 20);
            bDiv = new Button("/");
            bDiv.setBounds(195, 90, 20, 20);
            bMod = new Button("%");
            bMod.setBounds(225, 90, 20, 20);
            bSqrt = new Button("sqrt");
            bSqrt.setBounds(255, 90, 20, 20);
            bSq = new Button("sq");
            bSq.setBounds(75, 90, 20, 20);
            bLog = new Button("log");
            bLog.setBounds(45, 90, 20, 20);
            bEqual = new Button(" = ");
            bEqual.setBounds(140, 150, 30, 20);

            b1 = new Button("1");
            b1.setBounds(105, 210, 30, 30);
            b2 = new Button("2");
            b2.setBounds(145, 210, 30, 30);
            b3 = new Button("3");
            b3.setBounds(185, 210, 30, 30);
            b4 = new Button("4");
            b4.setBounds(105, 250, 30, 30);
            b5 = new Button("5");
            b5.setBounds(145, 250, 30, 30);
            b6 = new Button("6");
            b6.setBounds(185, 250, 30, 30);
            b7 = new Button("7");
            b7.setBounds(105, 290, 30, 30);
            b8 = new Button("8");
            b8.setBounds(145, 290, 30, 30);
            b9 = new Button("9");
            b9.setBounds(185, 290, 30, 30);
            b0 = new Button("0");
            b0.setBounds(145, 330, 30, 30);
            bPoint = new Button(".");
            bPoint.setBounds(185, 330, 30, 30);

            add(tf1);
            add(tf2);
            add(tfAns);
            add(bPlus);
            add(bPlus);
            add(bMinus);
            add(bMul);
            add(bDiv);
            add(bSq);
            add(bSqrt);
            add(bLog);
            add(bMod);
            add(bEqual);
            add(b1);
            add(b2);
            add(b3);
            add(b4);
            add(b5);
            add(b6);
            add(b7);
            add(b8);
            add(b9);
            add(b0);
            add(bPoint);

            setSize(300, 400);
            setTitle("Calculator");
            setLayout(null);
            setVisible(true);

            MouseAdapter mouseAdapter = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getSource() == tf1) {
                        selectedTF = tf1;
                    } else if (e.getSource() == tf2) {
                        selectedTF = tf2;
                    }
                }
            };
            tf1.addMouseListener(mouseAdapter);
            tf2.addMouseListener(mouseAdapter);
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (selectedTF != null) {
                        String buttonText = ((Button) e.getSource()).getLabel();
                        selectedTF.setText(selectedTF.getText() + buttonText);
                    }
                }
            };
            MouseAdapter globalMouseAdapter = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (selectedTF != null && e.getSource() != selectedTF) {
                        deselectTextField();
                    }
                }
            };
            addMouseListener(globalMouseAdapter);
            ActionListener calcResult = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s1 = tf1.getText();
                    String s2 = tf2.getText();

                    double a = Double.parseDouble(s1);
                    double b = Double.parseDouble(s2);
                    double res = 0.0;
                    if (e.getSource() == bPlus) {
                        res = a + b;
                    } else if (e.getSource() == bMinus) {
                        res = a - b;
                    } else if (e.getSource() == bMul) {
                        res = a * b;
                    } else if (e.getSource() == bDiv) {
                        res = a / b;
                    } else if (e.getSource() == bMod){
                        res = a % b;
                    }
                    result = String.valueOf(res);
                }
            };
            ActionListener calcSingleResult = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = tf1.getText();
                    double num = Double.parseDouble(s);
                    double res = 0.0;
                    if(e.getSource() == bLog){
                        res = Math.log10(num);
                        tf2.setText("");
                    }
                    else if(e.getSource() == bSq){
                        res = num*num;
                        tf2.setText("");
                    }
                    else if(e.getSource() == bSqrt){
                        res = Math.sqrt(num);
                        tf2.setText("");
                    }
                    result = String.valueOf(res);
                }
            };
            ActionListener display = e -> {
                if(e.getSource() == bEqual){
                    tfAns.setText(result);
                }
            };
            b1.addActionListener(actionListener);
            b2.addActionListener(actionListener);
            b3.addActionListener(actionListener);
            b4.addActionListener(actionListener);
            b5.addActionListener(actionListener);
            b6.addActionListener(actionListener);
            b7.addActionListener(actionListener);
            b8.addActionListener(actionListener);
            b9.addActionListener(actionListener);
            b0.addActionListener(actionListener);
            bPoint.addActionListener(actionListener);
            bPlus.addActionListener(calcResult);
            bMinus.addActionListener(calcResult);
            bMul.addActionListener(calcResult);
            bDiv.addActionListener(calcResult);
            bMod.addActionListener(calcResult);
            bLog.addActionListener(calcSingleResult);
            bSq.addActionListener(calcSingleResult);
            bSqrt.addActionListener(calcSingleResult);
            bEqual.addActionListener(display);
        }
        private void deselectTextField () {
            selectedTF = null;
        }
    }
}
