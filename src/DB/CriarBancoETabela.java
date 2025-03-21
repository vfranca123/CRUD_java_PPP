package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarBancoETabela {

    public static void cria(){
        TableProduto tabelaProduto = new TableProduto();
        String urls ="jdbc:derby:MeuBancoDeDados;create=true";
        try(Connection conn = DriverManager.getConnection(urls)){
            if(conn != null){
                System.out.println("conecxão executada com sucesso");
                tabelaProduto.criaTabelaProutos(conn);

            }
        } catch(SQLException e){
            System.err.println("Erro:"+e.getMessage());
        }

    }
}