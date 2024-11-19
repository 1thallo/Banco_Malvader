package model.Banco_Malvader.model;

public class ContaCorrente extends Conta {
    private double limite; // limite da conta corrente

    // construtor
    public ContaCorrente(int numero, double saldo, String tipoConta, double limite) {
        super(numero, saldo, tipoConta); // chama o construtor da classe pai (Conta)
        this.limite = limite; // define o limite
    }

    // getter e setter para o limite
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("conta corrente - número: " + numero);
        System.out.println("saldo: R$ " + saldo);
        System.out.println("limite: R$ " + limite);
    }

    @Override
    public void setNumero(int numero) {
        this.numero = numero;
    }
}
