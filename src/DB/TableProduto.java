package DB;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TableProduto {
    public static  void criaTabelaProutos(Connection conn) throws  SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        ResultSet tables = dbmd.getTables(null, null, "PRODUTOS", null); // Verifica se a tabela "PRODUTOS" existe
        if (!tables.next()) {
            String sql = "CREATE TABLE produtos (" +
                    "    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                    "    nome VARCHAR(100)," +
                    "    descricao VARCHAR(255)," +
                    "    preco INT," +
                    "    estoque INT" +
                    ")";
            try (java.sql.Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(sql);
                System.out.println("Tabela 'produtos' criada ou já existente.");
            }
        }
    }

}
