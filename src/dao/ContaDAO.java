package src.dao;

import src.model.Conta;
import src.model.Cliente;
import src.model.ContaPoupanca;
import src.model.ContaCorrente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    private Connection connection;

    // cria conexão com o banco
    public ContaDAO() {
        this.connection = ConnectionFactory.conectar();
    }

    // cadastra uma conta
    public boolean cadastrarConta(Conta conta) {
        String sql = "INSERT INTO Conta (NR_CONTA, VL_SALDO, TP_CONTA, ID_CLIENTE, VL_TAXA_RENDIMENTO, VL_LIMITE) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, conta.getNumero());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setString(3, conta.getTipoConta());
            stmt.setInt(4, conta.getCliente().getIdCliente());

            if (conta instanceof ContaPoupanca) {
                stmt.setDouble(5, ((ContaPoupanca) conta).getTaxaRendimento());
                stmt.setNull(6, Types.NULL); // conta poupanca sem limite
            } else if (conta instanceof ContaCorrente) {
                stmt.setNull(5, Types.NULL); // conta corrente sem taxa de rendimento
                stmt.setDouble(6, ((ContaCorrente) conta).getLimite());
            } else {
                stmt.setNull(5, Types.NULL);
                stmt.setNull(6, Types.NULL);
            }

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // sucesso
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // falha
        }
    }

    // consulta uma conta pelo número
    public Conta consultarConta(int numeroConta) {
        String sql = "SELECT * FROM Conta WHERE NR_CONTA = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, numeroConta);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Conta conta = null;
                String tipoConta = rs.getString("tipo_conta");

                // cria conta conforme o tipo
                if (tipoConta.equals("CC")) {
                    conta = new ContaCorrente(rs.getInt("numero"), rs.getDouble("saldo"), tipoConta,
                            rs.getDouble("limite")); // removido o parâmetro `sql`
                } else if (tipoConta.equals("CP")) {
                    conta = new ContaPoupanca(rs.getInt("numero"), rs.getDouble("saldo"), tipoConta,
                            rs.getInt("id_cliente"), rs.getDouble("taxa_rendimento"));
                }

                // associa o cliente à conta
                Cliente cliente = new ClienteDAO().consultarCliente(rs.getInt("id_cliente"));
                conta.setCliente(cliente);

                return conta; // retorna a conta
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // conta não encontrada
    }

    // atualiza dados da conta
    public boolean atualizarConta(Conta conta) {
        String sql = "UPDATE Conta SET saldo = ?, limite = ?, taxa_rendimento = ? WHERE numero = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, conta.getSaldo());

            if (conta instanceof ContaCorrente) {
                stmt.setDouble(2, ((ContaCorrente) conta).getLimite());
                stmt.setNull(3, Types.NULL); // conta corrente sem taxa de rendimento
            } else if (conta instanceof ContaPoupanca) {
                stmt.setNull(2, Types.NULL); // conta poupanca sem limite
                stmt.setDouble(3, ((ContaPoupanca) conta).getTaxaRendimento());
            } else {
                stmt.setNull(2, Types.NULL);
                stmt.setNull(3, Types.NULL);
            }

            stmt.setInt(4, conta.getNumero());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // sucesso
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // falha
        }
    }

    // encerra uma conta
    public boolean encerrarConta(int numeroConta) {
        String sql = "DELETE FROM Conta WHERE numero = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, numeroConta);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // sucesso
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // falha
        }
    }

    // gera relatório de movimentações (exemplo simples)
    // public String gerarRelatorioMovimentacao() {

    // }

    // lista todas as contas
    public List<Conta> listarContas() {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM Conta";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Conta conta = null;
                String tipoConta = rs.getString("tipo_conta");

                if (tipoConta.equals("CC")) {
                    conta = new ContaCorrente(rs.getInt("numero"), rs.getDouble("saldo"), tipoConta,
                            rs.getDouble("limite"));

                } else if (tipoConta.equals("CP")) {
                    conta = new ContaPoupanca(rs.getInt("numero"), rs.getDouble("saldo"), tipoConta,
                            rs.getInt("id_cliente"), rs.getDouble("taxa_rendimento"));
                }

                Cliente cliente = new ClienteDAO().consultarCliente(rs.getInt("id_cliente"));
                conta.setCliente(cliente);

                contas.add(conta); // adiciona a conta à lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contas; // retorna lista de contas
    }
}
