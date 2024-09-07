package Menu.Janela;

import Menu.AnalisadorDeQueimada.AnalisadorDeQueimada;
import Menu.Usuario.Cliente;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal {
    public static void main(String[] args) {

        // Criação da janela
        JFrame janela = new JFrame("DryTerrain");
        janela.setSize(800, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        // Definir layout da janela
        janela.setLayout(new BorderLayout());

        // Painel principal para os componentes (GridLayout 6 linhas x 2 colunas)
        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Título
        JLabel titulo = new JLabel("Monitor de Queimada", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        janela.add(titulo, BorderLayout.NORTH);

        // Rótulos e campos de entrada para o Cliente
        painel.add(new JLabel("Nome do Cliente:"));
        JTextField campoNome = new JTextField();
        campoNome.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(campoNome);

        painel.add(new JLabel("CPF:"));
        JTextField campoCPF = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(campoCPF);

        painel.add(new JLabel("Telefone:"));
        JTextField campoTelefone = new JTextField();
        painel.add(campoTelefone);

        painel.add(new JLabel("Email:"));
        JTextField campoEmail = new JTextField();
        painel.add(campoEmail);

        // Botão para cadastro do cliente
        JButton btnCadastro = new JButton("Cadastrar Cliente\n");
        painel.add(btnCadastro);

        btnCadastro.addActionListener(e -> {
            String nome = campoNome.getText();
            String cpf = campoCPF.getText();
            String telefone = campoTelefone.getText();
            String email = campoEmail.getText();
            Cliente cliente = new Cliente(nome, cpf, telefone, email);
            cliente.cadastrarUsuario();

            // Limpar os campos após o cadastro
            campoNome.setText("");
            campoCPF.setText("");
            campoTelefone.setText("");
            campoEmail.setText("");

            JOptionPane.showMessageDialog(janela, "Cliente cadastrado com sucesso!");
        });

        // Rótulo e campo para entrada de dados sobre Queimada
        painel.add(new JLabel("Dados da Queimada:"));
        JTextField campoQueimada = new JTextField();
        painel.add(campoQueimada);

        // Botão para análise da queimada
        JButton btnAnalise = new JButton("Analisar Queimada");
        painel.add(btnAnalise);

        JTextArea resultado = new JTextArea(5, 20);
        resultado.setEditable(false);
        JScrollPane scrollResultado = new JScrollPane(resultado);
        janela.add(scrollResultado, BorderLayout.SOUTH);  // Adicionar a área de resultados ao Sul

        btnAnalise.addActionListener(e -> {
            String dadosQueimada = campoQueimada.getText();
            AnalisadorDeQueimada analisador = new AnalisadorDeQueimada();
            analisador.adicionaQueimada(dadosQueimada);

            // Exibir os resultados na área de texto
            String resultados = "Queimada analisada no local: " + analisador.localQueimada() + "\n";
            resultados += "Total de queimadas: " + analisador.qtdQueimada() + "\n";
            resultados += "Queimadas analisadas: " + analisador.qtdAnalisadas();

            resultado.setText(resultados);
        });

        // Adicionar o painel principal ao centro da janela
        janela.add(painel, BorderLayout.CENTER);

        // Torna a janela visível
        janela.setVisible(true);
    }
}
