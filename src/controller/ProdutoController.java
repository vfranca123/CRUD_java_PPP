package controller;

import model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoController {

    public void inserirProduto( String nome,String descricao, int preco, int qnt_dEstoqe){
        try(Connection conn = DriverManager.getConnection("url")){
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO produtos(nome, descricao, preco, estoque)");
            pstmt.setString(1,nome);
            pstmt.setString(2,descricao);
            pstmt.setInt(3,preco);
            pstmt.setInt(4,qnt_dEstoqe);
            System.out.println("Produto inserido com sucesso");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir produto: " + e.getMessage());
        }
    }
}
