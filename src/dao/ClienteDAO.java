package src.dao;

import src.model.Cliente;
import src.model.Endereco;
import src.dao.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class ClienteDAO {
    private static final String SQL_SELECT_BY_NOME = "SELECT * FROM tb_usuario WHERE NO_USUARIO = ?";
    private static final String CLIENTE_TIPO = "CLIENTE";

    public Optional<Cliente> getUserByNomeAndPassword(String nome, String senha) {
        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement ps = conn.prepareStatement(SQL_SELECT_BY_NOME)) {

            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String senhaHash = rs.getString("SENHA");

                    Cliente dummyCliente = new Cliente(); // Construtor padrão permitido
                    dummyCliente.setSenha(senhaHash);

                    if (!dummyCliente.verificarSenha(senha)) {
                        System.out.println("Senha incorreta para o usuário: " + nome);
                        return Optional.empty();
                    }

                    String tipoUsuario = rs.getString("TP_USUARIO");
                    if (!CLIENTE_TIPO.equalsIgnoreCase(tipoUsuario)) {
                        System.out.println("Usuário não é um cliente: " + nome);
                        return Optional.empty();
                    }

                    Cliente cliente = criarCliente(rs, nome, senhaHash);
                    System.out.println("ID: " + cliente.getId() + ", Nome: " + cliente.getNome());
                    return Optional.of(cliente);
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

    private Cliente criarCliente(ResultSet rs, String nome, String senhaHash) throws SQLException {
        int id = rs.getInt("ID_USUARIO");
        String cpf = rs.getString("NR_CPF_USUARIO");
        LocalDate dataNascimento = rs.getDate("DT_NASCIMENTO").toLocalDate();
        String telefone = rs.getString("NR_TELEFONE");
        String cep = rs.getString("CEP");
        String local = rs.getString("LOCAL");
        int numeroCasa = rs.getInt("NUMERO_CASA");
        String bairro = rs.getString("BAIRRO");
        String cidade = rs.getString("CIDADE");
        String estado = rs.getString("ESTADO");

        Endereco endereco = new Endereco(cep, local, numeroCasa, bairro, cidade, estado); // Construindo Endereco

        return new Cliente(
                id,
                nome,
                cpf,
                dataNascimento,
                telefone,
                endereco,
                cep,
                bairro,
                cidade,
                estado,
                senhaHash
        );
    }
}