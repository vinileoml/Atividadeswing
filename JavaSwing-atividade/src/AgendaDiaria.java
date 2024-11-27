import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AgendaDiaria {
    private JPanel panelMain;
    private JTextField txtCompromisso;
    private JSpinner spnDataHora;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JTable tblCompromissos;
    private DefaultTableModel modeloTabela;

    public AgendaDiaria() {
        spnDataHora.setModel(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spnDataHora, "dd/MM/yyyy HH:mm");
        spnDataHora.setEditor(dateEditor);

        String[] colunas = {"Data/Hora", "Descrição"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tblCompromissos.setModel(modeloTabela);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String compromisso = txtCompromisso.getText();
                Date dataHora = (Date) spnDataHora.getValue();

                if (compromisso.isEmpty()) {
                    JOptionPane.showMessageDialog(panelMain, "Por favor, insira um compromisso.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                modeloTabela.addRow(new Object[]{dataHora, compromisso});
                txtCompromisso.setText("");
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tblCompromissos.getSelectedRow();
                if (linhaSelecionada == -1) {
                    JOptionPane.showMessageDialog(panelMain, "Por favor, selecione um compromisso para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                modeloTabela.removeRow(linhaSelecionada);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda Diária");
        frame.setContentPane(new AgendaDiaria().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
