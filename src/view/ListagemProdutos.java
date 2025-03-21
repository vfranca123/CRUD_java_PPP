package view;

import javax.swing.*;
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
        JPanel PainelBotoes = new JPanel();
        JPanel PainelListagem = new JPanel();

        try(Connection conn = DriverManager.getConnection(url)){
            Statement stmt= conn.createStatement();
            ResultSet rs= stmt.executeQuery("SELECT * FROM produtos");
            StringBuilder html = new StringBuilder("<html><body>");

            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double preco = rs.getDouble("preco");
                int estoque = rs.getInt("estoque");


                html.append("<p><b>ID:</b> ").append(id).append("<br>");
                html.append("<b>Nome:</b> ").append(nome).append("<br>");
                html.append("<b>Descrição:</b> ").append(descricao).append("<br>");
                html.append("<b>Preço:</b> ").append(preco).append("<br>");
                html.append("<b>Estoque:</b> ").append(estoque).append("</p><hr>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


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
        PainelBotoes.add(botao);
        PainelBotoes.add(botao2);
        add(label, BorderLayout.NORTH);
        add(PainelBotoes, BorderLayout.SOUTH);

    }
}
