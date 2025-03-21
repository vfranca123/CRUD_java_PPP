package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListagemProdutos extends JPanel {
    public ListagemProdutos(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Listagem de Produtos", SwingConstants.CENTER);
        JButton botao = new JButton("Página Inicial");
        JButton botao2 = new JButton("Cadastrar Produtos");
        JPanel PainelBotoes = new JPanel();

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
        add(label, BorderLayout.CENTER);
        add(PainelBotoes, BorderLayout.SOUTH);

    }
}
