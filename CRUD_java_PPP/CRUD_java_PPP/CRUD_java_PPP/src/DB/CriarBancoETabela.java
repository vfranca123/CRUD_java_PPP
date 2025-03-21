package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBancoETabela {

    public static void CriarBancoETabela(String[] args) {
        String url = "jdbc:derby:MeuBancoDeDados;create=true"; // URL de conexão com Derby

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso.");
                criarTabelaProdutos(conn); // Chama o método para criar a tabela
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou criar tabela: " + e.getMessage());
        }
    }

    public static void criarTabelaProdutos(Connection conn) throws SQLException {
        String sql = "CREATE TABLE produtos (" +
                "    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                "    nome VARCHAR(100)," +
                "    descricao VARCHAR(255)," +
                "    preco DECIMAL(10, 2)," +
                "    estoque INT" +
                ")";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Tabela 'produtos' criada com sucesso.");
        }
    }
}