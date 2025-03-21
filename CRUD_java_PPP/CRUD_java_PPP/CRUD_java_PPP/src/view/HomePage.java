package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JPanel {
    public HomePage(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JPanel PainelBotoes = new JPanel();
        JLabel label = new JLabel("Página Inicial", SwingConstants.CENTER);
        JButton botao1 = new JButton("Listagem");
        JButton botao2= new JButton("Cadastra Produto");

        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.trocarPagina("listagem");
            }
        });

        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.trocarPagina("AddProduto");
            }
        });
        PainelBotoes.add(botao1);
        PainelBotoes.add(botao2);
        add(label, BorderLayout.CENTER);
        add(PainelBotoes, BorderLayout.SOUTH);

    }
}
