package Banco_Malvader.model;

public class ContaCorrente extends Conta {
    private double limite; // Limite de crédito da conta corrente

    // Construtor
    public ContaCorrente(int numero, double saldo, double limite) {
        super(numero, saldo, "Corrente");
        this.limite = limite;
    }

    // Método para verificar o limite de crédito
    public double verificarLimite() {
        return limite;
    }

    // Sobrescrita do método exibirInformacoes para mostrar dados específicos da
    // Conta Corrente
    @Override
    public void exibirInformacoes() {
        System.out.println("Conta Corrente - Número: " + numero);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Limite: R$ " + limite);
    }
}
