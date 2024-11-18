package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb"; // Substitua pelo seu banco de dados
    private static final String USER = "root"; // Substitua pelo usuário do seu banco
    private static final String PASSWORD = "fFLUZAO2004."; // Substitua pela senha do seu banco

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        try {
            // Carregar o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Retornar a conexão
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // Caso ocorra algum erro, imprimir a exceção e lançar
            e.printStackTrace();
            throw new SQLException("Erro ao conectar ao banco de dados", e);
        }
    }

    // Método para fechar a conexão com o banco de dados
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
