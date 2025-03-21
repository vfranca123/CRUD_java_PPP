package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ListagemProdutos extends JPanel {

    String url = "jdbc:derby:MeuBancoDeDados";

    public ListagemProdutos(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Listagem de Produtos", SwingConstants.CENTER);
        JButton botao = new JButton("Página Inicial");
        JButton botao2 = new JButton("Cadastrar Produtos");
        JPanel painelBotoes = new JPanel();
        JPanel painelListagem = new JPanel();

        // Criar a tabela
        DefaultTableModel model = new DefaultTableModel();
        JTable tabelaProdutos = new JTable(model);

        // Definir as colunas da tabela

        model.addColumn("Nome");
        model.addColumn("Descrição");
        model.addColumn("Preço");
        model.addColumn("Estoque");

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM produtos")) {

            // Preencher a tabela com os dados do banco de dados
            while (rs.next()) {

                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double preco = rs.getDouble("preco");
                int estoque = rs.getInt("estoque");

                model.addRow(new String[]{nome, descricao, String.valueOf(preco), String.valueOf(estoque)});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Configurar o layout dos painéis
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.add(botao);
        painelBotoes.add(botao2);

        painelListagem.setLayout(new BorderLayout());
        painelListagem.add(new JScrollPane(tabelaProdutos), BorderLayout.CENTER); // Adicionar tabela com barra de rolagem

        // Configurar os listeners dos botões
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.trocarPagina("home");
            }
        });

        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.trocarPagina("AddProduto");
            }
        });

        // Adicionar os componentes ao painel
        add(label, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.SOUTH);
        add(painelListagem, BorderLayout.CENTER);
    }
}