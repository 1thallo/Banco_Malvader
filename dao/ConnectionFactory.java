package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb"; // URL do banco de dados
    private static final String USER = "root"; // Usuário do banco de dados
    private static final String PASSWORD = "fFLUZAO2004."; // Senha do banco de dados
    private static Connection connection = null;

    // Método para obter a conexão com o banco de dados
    public static Connection conectar() {
        try {
            if (connection == null || connection.isClosed()) {
                // Conectar ao banco de dados
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar com o banco de dados.");
        }
        return connection;
    }

    // Método para fechar a conexão com o banco de dados
    public static void desconectar() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexão encerrada com sucesso.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao fechar a conexão com o banco de dados.");
        }
    }

    // Método para verificar se a conexão está ativa
    public static boolean isConectado() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
