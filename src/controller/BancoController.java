package src.controller;

import src.model.Conta;
import src.model.Funcionario;
import src.util.DataManager;

import java.util.ArrayList;
import java.util.List;

public class BancoController {

    // Atributos
    private List<Conta> contas;
    private List<Funcionario> funcionarios;

    // Construtor
    public BancoController() {
        contas = new ArrayList<>();
        funcionarios = new ArrayList<>();
        carregarDados();
    }

    // Método para abrir uma nova conta
    public void abrirConta(Conta conta) {
        contas.add(conta);
        System.out.println("Conta de número " + conta.getNumero() + " aberta com sucesso!");
    }

    // Método para encerrar uma conta
    public void encerrarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                contas.remove(conta);
                System.out.println("Conta de número " + numeroConta + " encerrada com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada!");
    }

    // Método para consultar uma conta
    public Conta consultarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta; // Retorna a conta se encontrada
            }
        }
        System.out.println("Conta não encontrada!");
        return null;
    }

//     Método para salvar todos os dados (contas e funcionários) em arquivos
    public void salvarDados() {
        // Salva as contas
        DataManager.salvarContas(contas, "contas.dat");

        // Salva os funcionários
        DataManager.salvarFuncionarios(funcionarios, "funcionarios.dat");

        System.out.println("Dados salvos com sucesso!");
    }

    // Método para carregar todos os dados (contas e funcionários) de arquivos
    public void carregarDados() {
        // Carrega as contas
        List<Conta> contasCarregadas = DataManager.carregarContas("contas.dat");
        if (contasCarregadas != null) {
            contas = contasCarregadas;
        }

        // Carrega os funcionários
        List<Funcionario> funcionariosCarregados = DataManager.carregarFuncionarios("funcionarios.dat");
        if (funcionariosCarregados != null) {
            funcionarios = funcionariosCarregados;
        }

        System.out.println("Dados carregados com sucesso!");
    }

    // Getters e Setters
    public List<Conta> getContas() {
        return contas;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
