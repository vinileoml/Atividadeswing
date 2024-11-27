import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnMais;
    private JButton btnDiminui;
    private JButton btnDiv;
    private JButton btnMultiplicacao;
    private JButton btnSomar;
    private JButton btnLimpar;
    private JTextField txtTela;
    private JPanel panelMain;

    private double num1 = 0;
    private double num2 = 0;
    private String operador = "";

    public Calculadora() {
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTela.setText(txtTela.getText() + 0);
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTela.setText(txtTela.getText() + 1);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTela.setText(txtTela.getText() + 2);
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTela.setText(txtTela.getText() + 3);
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTela.setText(txtTela.getText() + 4);
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTela.setText(txtTela.getText() + 5);
            }
        });

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTela.setText(txtTela.getText() + 6);
            }
        });

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTela.setText(txtTela.getText() + 7);
            }
        });

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTela.setText(txtTela.getText() + 8);
            }
        });

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTela.setText(txtTela.getText() + 9);
            }
        });

        btnMais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtTela.getText().isEmpty()) {
                    num1 = Double.parseDouble(txtTela.getText());
                    operador = "+";
                    txtTela.setText("");
                }
            }
        });

        btnDiminui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtTela.getText().isEmpty()) {
                    num1 = Double.parseDouble(txtTela.getText());
                    operador = "-";
                    txtTela.setText("");
                }
            }
        });

        btnMultiplicacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtTela.getText().isEmpty()) {
                    num1 = Double.parseDouble(txtTela.getText());
                    operador = "*";
                    txtTela.setText("");
                }
            }
        });

        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtTela.getText().isEmpty()) {
                    num1 = Double.parseDouble(txtTela.getText());
                    operador = "/";
                    txtTela.setText("");
                }
            }
        });

        btnSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtTela.getText().isEmpty()) {
                    num2 = Double.parseDouble(txtTela.getText());
                    double resultado = 0;

                    if (operador.equals("+")) {
                        resultado = num1 + num2;
                    } else if (operador.equals("-")) {
                        resultado = num1 - num2;
                    } else if (operador.equals("*")) {
                        resultado = num1 * num2;
                    } else if (operador.equals("/")) {
                        if (num2 != 0) {
                            resultado = num1 / num2;
                        } else {
                            txtTela.setText("Erro");
                            return;
                        }
                    }

                    txtTela.setText(String.valueOf(resultado));
                    num1 = resultado;
                    operador = "";
                }
            }
        });


        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTela.setText("");
                num1 = 0;
                num2 = 0;
                operador = "";
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new Calculadora().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
//sempre criar um jframe qualquer coisa dar um extends