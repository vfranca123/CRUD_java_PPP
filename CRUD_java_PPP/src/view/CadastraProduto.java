package view;

import javax.swing.*;
import java.awt.*;

public class CadastraProduto extends JPanel {

    public CadastraProduto(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Cadastro de Produtos", SwingConstants.CENTER);
        JButton botao1 = new JButton("Listagem");
        JButton botao2 = new JButton("Home");

        // Painel para os botões
        JPanel PainelBotoes = new JPanel(new FlowLayout());
        PainelBotoes.add(botao1);
        PainelBotoes.add(botao2);

        // Definir ações dos botões
        botao1.addActionListener(e -> mainFrame.trocarPagina("listagem"));
        botao2.addActionListener(e -> mainFrame.trocarPagina("home"));

        // Adicionar componentes ao painel
        add(label, BorderLayout.CENTER);
        add(PainelBotoes, BorderLayout.SOUTH); // ✅ Agora o painel contém os dois botões
    }
}
