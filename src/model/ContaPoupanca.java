package src.model;

public class ContaPoupanca extends Conta {
    private double taxaRendimento; // taxa de rendimento

    // Construtor vazio (necessário para algumas situações, como frameworks ou carregamento dinâmico)
    public ContaPoupanca() {
    }

    // Construtor completo
    public ContaPoupanca(int numero, String agencia, double saldo, Cliente cliente, double taxaRendimento) {
        super(numero, agencia, saldo, cliente);
        this.taxaRendimento = taxaRendimento;
    }

    // Métodos específicos de ContaPoupanca

    public double calcularRendimento() {
        return getSaldo() * (taxaRendimento / 100);
    }

    // Getters e setters
    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    // Exibe as informações da conta poupança
    @Override
    public void exibirInformacoes() {
        System.out.println("Conta Poupança - Número: " + getNumero());
        System.out.println("Agência: " + getAgencia());
        System.out.println("Saldo: R$ " + getSaldo());
        System.out.println("Cliente: " + getCliente().getNome()); // Supondo que Cliente tem um método getNome()
        System.out.println("Taxa de Rendimento: " + taxaRendimento + "%");
    }
}