package Banco_Malvader.dao;

import Banco_Malvader.model.Cliente;
import Banco_Malvader.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO() {
        this.connection = ConexaoBanco.conectar(); // Estabelece a conexão com o banco de dados
    }

    public boolean cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO Usuario (NO_USUARIO, NR_CPF_USUARIO, DT_NASCIMENTO, NR_TELEFONE, SENHA, TP_USUARIO) "
                + "VALUES (?, ?, ?, ?, ?, 'CLIENTE')";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Define os parâmetros para a consulta SQL
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getDataNascimento());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getSenha());

            // Executa a consulta SQL
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Se mais de uma linha foi afetada, o cadastro foi bem-sucedido
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar cliente: " + e.getMessage());
            return false;
        }
    }
}
