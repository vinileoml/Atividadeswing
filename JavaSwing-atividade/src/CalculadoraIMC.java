import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC {
    private JPanel mainPanel;
    private JTextField pesoField;
    private JTextField alturaField;
    private JButton calcularIMCButton;
    private JLabel resultadoLabel;

    public CalculadoraIMC() {
        inicializarComponentes();

        calcularIMCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
    }

    private void inicializarComponentes() {
        mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Calculadora de IMC"));

        inputPanel.add(new JLabel("Peso (kg):"));
        pesoField = new JTextField(15);
        inputPanel.add(pesoField);

        inputPanel.add(new JLabel("Altura (m):"));
        alturaField = new JTextField(15);
        inputPanel.add(alturaField);

        calcularIMCButton = new JButton("Calcular IMC");
        inputPanel.add(calcularIMCButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        resultadoLabel = new JLabel("Insira peso e altura para calcular o IMC", SwingConstants.CENTER);
        resultadoLabel.setBorder(BorderFactory.createTitledBorder("Resultado"));
        mainPanel.add(resultadoLabel, BorderLayout.CENTER);
    }

    private void calcularIMC() {
        String pesoTexto = pesoField.getText().trim();
        String alturaTexto = alturaField.getText().trim();

        try {
            double peso = Double.parseDouble(pesoTexto);
            double altura = Double.parseDouble(alturaTexto);

            if (peso <= 0 || altura <= 0) {
                throw new IllegalArgumentException("Peso e altura devem ser maiores que zero.");
            }

            double imc = peso / (altura * altura);
            String categoria = determinarCategoriaIMC(imc);

            resultadoLabel.setText(String.format("IMC: %.2f - Categoria: %s", imc, categoria));
        } catch (NumberFormatException ex) {
            showMessage("Por favor, insira valores numéricos válidos.");
        } catch (IllegalArgumentException ex) {
            showMessage(ex.getMessage());
        }
    }

    private String determinarCategoriaIMC(double imc) {
        if (imc < 18.5) {
            return "Baixo peso";
        } else if (imc < 24.9) {
            return "Normal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(mainPanel, message, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de IMC");
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        frame.setContentPane(calculadoraIMC.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
