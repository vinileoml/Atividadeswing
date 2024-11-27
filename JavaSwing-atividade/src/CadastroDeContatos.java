import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDeContatos {
    private JPanel panelMain;
    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextField emailField;
    private JButton btnAdicionarContato;
    private JButton btnRemoverContato;
    private JList<String> listaContatos;
    private DefaultListModel<String> listaModel;

    public CadastroDeContatos() {
        listaModel = new DefaultListModel<>();
        inicializarComponentes();

        btnAdicionarContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarContato();
            }
        });

        btnRemoverContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerContato();
            }
        });
    }

    private void inicializarComponentes() {
        panelMain = new JPanel(new BorderLayout());

        JPanel painelSuperior = new JPanel(new GridLayout(4, 2, 5, 5));
        painelSuperior.setBorder(BorderFactory.createTitledBorder("Cadastro de Contato"));

        painelSuperior.add(new JLabel("Nome:"));
        nomeField = new JTextField(15);
        painelSuperior.add(nomeField);

        painelSuperior.add(new JLabel("Telefone:"));
        telefoneField = new JTextField(15);
        painelSuperior.add(telefoneField);

        painelSuperior.add(new JLabel("E-mail:"));
        emailField = new JTextField(15);
        painelSuperior.add(emailField);

        btnAdicionarContato = new JButton("Adicionar Contato");
        painelSuperior.add(btnAdicionarContato);

        btnRemoverContato = new JButton("Remover Contato");
        painelSuperior.add(btnRemoverContato);

        panelMain.add(painelSuperior, BorderLayout.NORTH);

        // Aqui eu crio um List usar esse como modelo
        listaContatos = new JList<>(listaModel);
        JScrollPane scrollPane = new JScrollPane(listaContatos);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Contatos"));
        panelMain.add(scrollPane, BorderLayout.CENTER);
    }

    private void adicionarContato() {
        String nome = nomeField.getText().trim();
        String telefone = telefoneField.getText().trim();
        String email = emailField.getText().trim();

        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            showMessage("Todos os campos devem ser preenchidos.");
            return;
        }

        String contato = String.format("Nome: %s | Telefone: %s | E-mail: %s", nome, telefone, email);
        listaModel.addElement(contato);

        //seta como "" e limpa os campos
        nomeField.setText("");
        telefoneField.setText("");
        emailField.setText("");
    }

    private void removerContato() {
        int indexSelecionado = listaContatos.getSelectedIndex();
        if (indexSelecionado == -1) {
            showMessage("Selecione um contato para remover.");
            return;
        }
        listaModel.remove(indexSelecionado);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(panelMain, message, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        CadastroDeContatos cadastro = new CadastroDeContatos();
        frame.setContentPane(cadastro.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}