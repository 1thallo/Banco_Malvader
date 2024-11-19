package Banco_Malvader.model;

public class ContaPoupanca extends Conta {

    // Construtor
    public ContaPoupanca(int numero, double saldo) {
        super(numero, saldo, "Poupança");
    }

    // Sobrescrita do método exibirInformacoes para mostrar dados específicos da
    // Conta Poupança
    @Override
    public void exibirInformacoes() {
        System.out.println("Conta Poupança - Número: " + numero);
        System.out.println("Saldo: R$ " + saldo);
    }
}
