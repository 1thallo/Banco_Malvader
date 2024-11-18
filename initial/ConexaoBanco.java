package initial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "fFLUZAO2004.";

    private static Connection conn;

    public static Connection conectar() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexão estabelecida com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao estabelecer a conexão com o banco de dados: " + e.getMessage());
            }
        }
        return conn;
    }

    public static void desconectar() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
                System.out.println("Conexão fechada com sucesso!");
            } catch (Exception e) {
                System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
}
