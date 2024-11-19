package security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ConnectionFactory;

public class GerenteSenhaManager {

    // Método para validar senha de gerente
    public boolean validarSenhaAdministrador(String senha) {
        String sql = "SELECT SENHA FROM TB_USUARIO WHERE TP_USUARIO = 'GERENTE'";

        try (Connection connection = ConnectionFactory.conectar();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String senhaGerente = resultSet.getString("SENHA");
                return senha.equals(senhaGerente);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao validar senha do administrador: " + e.getMessage());
        }

        return false;
    }
}
