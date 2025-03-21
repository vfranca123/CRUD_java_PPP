package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        // Configuração da janela
        setTitle("Sistema de Rotas Swing");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criando o painel principal com CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Criando as páginas
        CadastraProduto cadastraProduto= new CadastraProduto (this);
        HomePage homePage = new HomePage(this);
        ListagemProdutos listagemProdutos = new ListagemProdutos(this);

        // Adicionando páginas ao painel principal
        mainPanel.add(cadastraProduto, "AddProduto");
        mainPanel.add(homePage, "home");
        mainPanel.add(listagemProdutos, "listagem");

        // Adicionando o painel principal ao frame
        add(mainPanel);

        // Exibir a página inicial
        cardLayout.show(mainPanel, "home");
    }

    // Método para mudar de página
    public void trocarPagina(String pagina) {
        cardLayout.show(mainPanel, pagina);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
