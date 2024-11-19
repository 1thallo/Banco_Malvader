package Banco_Malvader.model;

import dao.ClienteDAO;
import dao.ContaDAO;
import dao.FuncionarioDAO;
import initial.Endereco;
import initial.Usuario;

import java.time.LocalDate;

public class Funcionario extends Usuario {

    private String codigoFuncionario;
    private String cargo;
    private String senha;

    // Construtor
    public Funcionario(int id, String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco endereco,
            String codigoFuncionario, String cargo, String senha) {
        super(id, nome, cpf, dataNascimento, telefone, endereco);
        this.codigoFuncionario = codigoFuncionario;
        this.cargo = cargo;
        this.senha = senha;
    }

    // Getters e Setters
    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Métodos específicos da classe Funcionario

    @Override
    public boolean login(String senha) {
        return this.senha.equals(senha); // Verifica se a senha fornecida é igual à senha do funcionário
    }

    public void abrirConta(Conta conta) {
        ContaDAO contaDAO = new ContaDAO();
        if (contaDAO.cadastrarConta(conta)) {
            System.out.println("Conta aberta com sucesso para o cliente: " + conta.getCliente().getNome());
        } else {
            System.out.println("Erro ao abrir conta. Verifique os dados e tente novamente.");
        }
    }

    public void encerrarConta(Conta conta) {
        ContaDAO contaDAO = new ContaDAO();
        if (contaDAO.encerrarConta(conta.getNumeroConta())) {
            System.out.println("Conta encerrada com sucesso: " + conta.getNumeroConta());
        } else {
            System.out.println("Erro ao encerrar conta. Verifique o número da conta.");
        }
    }

    public Conta consultarDadosConta(int numeroConta) {
        ContaDAO contaDAO = new ContaDAO();
        Conta conta = contaDAO.consultarConta(numeroConta);
        if (conta != null) {
            System.out.println("Dados da conta: " + conta);
            return conta;
        } else {
            System.out.println("Conta não encontrada.");
            return null;
        }
    }

    public Cliente consultarDadosCliente(int idCliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.consultarCliente(idCliente);
        if (cliente != null) {
            System.out.println("Dados do cliente: " + cliente);
            return cliente;
        } else {
            System.out.println("Cliente não encontrado.");
            return null;
        }
    }

    public void alterarDadosConta(Conta conta) {
        ContaDAO contaDAO = new ContaDAO();
        if (contaDAO.atualizarConta(conta)) {
            System.out.println("Dados da conta atualizados com sucesso.");
        } else {
            System.out.println("Erro ao atualizar dados da conta.");
        }
    }

    public void alterarDadosCliente(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        if (clienteDAO.atualizarCliente(cliente)) {
            System.out.println("Dados do cliente atualizados com sucesso.");
        } else {
            System.out.println("Erro ao atualizar dados do cliente.");
        }
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if (funcionarioDAO.cadastrarFuncionario(funcionario)) {
            System.out.println("Funcionário cadastrado com sucesso: " + funcionario.getNome());
        } else {
            System.out.println("Erro ao cadastrar funcionário.");
        }
    }

    public void gerarRelatorioMovimentacao() {
        ContaDAO contaDAO = new ContaDAO();
        String relatorio = contaDAO.gerarRelatorioMovimentacao();
        if (relatorio != null && !relatorio.isEmpty()) {
            System.out.println("Relatório de movimentações:\n" + relatorio);
        } else {
            System.out.println("Erro ao gerar relatório ou nenhum dado encontrado.");
        }
    }

    @Override
    public String consultarDados() {
        return String.format("Código: %s, Nome: %s, Cargo: %s, Telefone: %s",
                codigoFuncionario, getNome(), cargo, getTelefone());
    }

    @Override
    public boolean login(String senha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
}
