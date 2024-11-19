package Banco_Malvader.model;

public abstract class Conta {
    protected int numero;
    protected double saldo;
    protected String tipoConta; // Pode ser "Poupança" ou "Corrente"

    // Construtor
    public Conta(int numero, double saldo, String tipoConta) {
        this.numero = numero;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Método para depositar um valor
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    // Método para sacar um valor
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    // Método para consultar o saldo da conta
    public double consultarSaldo() {
        return saldo;
    }

    // Método abstrato para cada tipo de conta mostrar informações específicas
    public abstract void exibirInformacoes();
}
