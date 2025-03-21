package view;

import controller.ProdutoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastraProduto extends JPanel {
    private ProdutoController produtoController= new ProdutoController();
    public CadastraProduto(MainFrame mainFrame) {
        setLayout(new BorderLayout());
        JPanel painelCampos = new JPanel(new GridLayout(5,2,5,20));

        JLabel label = new JLabel("Cadastro de Produtos", SwingConstants.CENTER);
        JButton botao1 = new JButton("Listagem");
        JButton botao2 = new JButton("Home");
        JButton adicionar = new JButton("Adicionar");
        // Painel para os botões
        JPanel PainelBotoes = new JPanel(new FlowLayout());


        JLabel nomeProduto = new JLabel("Nome");
        JTextField nomeField = new JTextField();

        JLabel descricaoProduto = new JLabel("Descrição");
        JTextField descricaoField = new JTextField();

        JLabel precoProduto = new JLabel("Preço");
        JTextField precoField = new JTextField();

        JLabel qntdProduto = new JLabel("Quantidade");
        JTextField qntdField = new JTextField();



        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String nome = nomeField.getText();
                    String descricao = descricaoField.getText();
                    int preco = Integer.parseInt(precoField.getText());
                    int qnt_estoque = Integer.parseInt(qntdField.getText());

                    produtoController.inserirProduto(nome,descricao,preco,qnt_estoque);

                    JOptionPane.showMessageDialog(mainFrame, "Produto adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(mainFrame, "Erro: Preço ou estoque deve ser um número ou tem dados faltantes.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        painelCampos.add(nomeProduto);
        painelCampos.add(nomeField);
        painelCampos.add(descricaoProduto);
        painelCampos.add(descricaoField);
        painelCampos.add(precoProduto);
        painelCampos.add(precoField);
        painelCampos.add(qntdProduto);
        painelCampos.add(qntdField);

        PainelBotoes.add(botao1);
        PainelBotoes.add(botao2);
        PainelBotoes.add(adicionar);

        // Definir ações dos botões
        botao1.addActionListener(e -> mainFrame.trocarPagina("listagem"));
        botao2.addActionListener(e -> mainFrame.trocarPagina("home"));

        // Adicionar componentes ao painel
        add(label, BorderLayout.NORTH);
        add(painelCampos,BorderLayout.CENTER);
        add(PainelBotoes, BorderLayout.SOUTH); //  Agora o painel contém os dois botões
    }
}
