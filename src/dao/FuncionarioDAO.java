package src.dao;

import src.model.Endereco;
import src.model.Funcionario;
import src.dao.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class FuncionarioDAO {
    private static final String SQL_SELECT_BY_NOME = "SELECT * FROM tb_usuario WHERE NO_USUARIO = ?";
    private static final String FUNCIONARIO_TIPO = "FUNCIONARIO";

    public Optional<Funcionario> getUserByNomeAndPassword(String nome, String senha) {
        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement ps = conn.prepareStatement(SQL_SELECT_BY_NOME)) {

            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String senhaHash = rs.getString("SENHA");

                    Funcionario dummyFuncionario = new Funcionario();
                    dummyFuncionario.setSenha(senhaHash);

                    if (!dummyFuncionario.verificarSenha(senha)) {
                        System.out.println("Senha incorreta para o usuário: " + nome);
                        return Optional.empty();
                    }

                    String tipoUsuario = rs.getString("TP_USUARIO");
                    if (!FUNCIONARIO_TIPO.equalsIgnoreCase(tipoUsuario)) {
                        System.out.println("Usuário não é um funcionário: " + nome);
                        return Optional.empty();
                    }

                    Funcionario funcionario = criarFuncionario(rs, nome, senhaHash);
                    System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome());
                    return Optional.of(funcionario);
                } else {
                    System.out.println("Usuário não encontrado com o nome: " + nome);
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar os dados: " + e.getMessage());
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Funcionario criarFuncionario(ResultSet rs, String nome, String senhaHash) throws SQLException {
        int id = rs.getInt("ID_USUARIO");
        String cpf = rs.getString("NR_CPF_USUARIO");
        LocalDate dataNascimento = rs.getDate("DT_NASCIMENTO").toLocalDate();
        String telefone = rs.getString("NR_TELEFONE");

        Endereco endereco = null; // Supondo que precise construir o endereço baseado em mais dados

        return new Funcionario(
                id,
                nome,
                cpf,
                dataNascimento,
                telefone,
                endereco,
                senhaHash,
                rs.getString("CODIGO_FUNCIONARIO"),
                rs.getString("CARGO")
        );
    }
}