import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CalculadoraDeMedias {
    private JPanel panelMain;
    private JTextField btnNota;
    private JButton btnAddNota;
    private JButton btnCalcularMedia;
    private JTextArea areaNotas;
    private JLabel resultadoLabel;

    private List<Double> notas;

    public CalculadoraDeMedias() {
        notas = new ArrayList<>();
        inicializarComponentes();

        btnAddNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNota();
            }
        });

        btnCalcularMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMedia();
            }
        });
    }

    private void inicializarComponentes() {
        panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());

        JPanel painelSuperior = new JPanel(new FlowLayout());
        btnNota = new JTextField(10);
        btnAddNota = new JButton("Adicionar Nota");
        painelSuperior.add(new JLabel("Nota:"));
        painelSuperior.add(btnNota);
        painelSuperior.add(btnAddNota);
        panelMain.add(painelSuperior, BorderLayout.NORTH);

        areaNotas = new JTextArea(10, 30);
        areaNotas.setEditable(false);
        panelMain.add(new JScrollPane(areaNotas), BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new BorderLayout());
        btnCalcularMedia = new JButton("Calcular Média");
        resultadoLabel = new JLabel("Média: - | Status: -", SwingConstants.CENTER);
        painelInferior.add(btnCalcularMedia, BorderLayout.NORTH);
        painelInferior.add(resultadoLabel, BorderLayout.SOUTH);
        panelMain.add(painelInferior, BorderLayout.SOUTH);
    }

    private void adicionarNota() {
        try {
            double nota = Double.parseDouble(btnNota.getText());
            if (nota < 0 || nota > 10) {
                showMessage("Por favor, insira uma nota entre 0 e 10.");
            } else {
                notas.add(nota);
                areaNotas.append("Nota: " + nota + "\n");
                btnNota.setText("");
            }
        } catch (NumberFormatException e) {
            showMessage("Por favor, insira um número válido.");
        }
    }

    private void calcularMedia() {
        if (notas.isEmpty()) {
            showMessage("Nenhuma nota foi adicionada.");
            return;
        }

        double media = notas.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        String status = media >= 7.0 ? "Aprovado" : "Reprovado";
        resultadoLabel.setText(String.format("Média: %.2f | Status: %s", media, status));
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(panelMain, message, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Médias");
        CalculadoraDeMedias calculadora = new CalculadoraDeMedias();
        frame.setContentPane(calculadora.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
