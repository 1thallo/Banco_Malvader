package test;

import Banco_Malvader.model.*;

public class TestContas {
    public static void main(String[] args) {
        // Criando uma conta poupança e uma conta corrente
        ContaPoupanca contaPoupanca = new ContaPoupanca(12345, 5000.00);
        ContaCorrente contaCorrente = new ContaCorrente(67890, 2000.00, 1500.00);

        // Exibindo informações das contas
        contaPoupanca.exibirInformacoes();
        contaCorrente.exibirInformacoes();

        // Depositando em ambas as contas
        contaPoupanca.depositar(500);
        contaCorrente.depositar(1000);

        // Sacando das contas
        contaPoupanca.sacar(200);
        contaCorrente.sacar(2500); // Tenta sacar acima do saldo disponível (incluindo limite)
        contaCorrente.sacar(1000); // Saque dentro do saldo (incluindo limite)

        // Consultando saldo
        System.out.println("Saldo da Conta Poupança: R$ " + contaPoupanca.consultarSaldo());
        System.out.println("Saldo da Conta Corrente: R$ " + contaCorrente.consultarSaldo());
    }
}
