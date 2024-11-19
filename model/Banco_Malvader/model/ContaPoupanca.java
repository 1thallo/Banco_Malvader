package model.Banco_Malvader.model;

public class ContaPoupanca extends Conta {
    private double taxaRendimento; // taxa de rendimento
    private int idCliente; // id do cliente

    // construtor
    public ContaPoupanca(int numero, double saldo, String tipoConta, int idCliente, double taxaRendimento) {
        super(numero, saldo, tipoConta); // chama o construtor da classe mãe (Conta)
        this.idCliente = idCliente;
        this.taxaRendimento = taxaRendimento;
    }

    // getter e setter para taxa de rendimento
    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    // getter e setter para id do cliente
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // exibe as informações da conta poupança
    @Override
    public void exibirInformacoes() {
        System.out.println("Conta Poupança - Número: " + numero);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Taxa de Rendimento: " + taxaRendimento + "%");
    }

    // set para o número da conta
    @Override
    public void setNumero(int numero) {
        this.numero = numero;
    }
}
