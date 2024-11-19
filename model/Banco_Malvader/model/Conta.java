package model.Banco_Malvader.model;

public abstract class Conta {
    protected int numero;
    protected double saldo;
    protected String tipoConta; // tipo de conta, "Poupança" ou "Corrente"
    protected double limite;

    public Conta(int numero, double saldo, String tipoConta) {
        this.numero = numero;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    // construtor
    public void ContaCorrente(int numero, double saldo, String tipoConta, double limite) {
        super(numero, saldo, tipoConta); // chama o construtor da classe pai (Conta)
        this.limite = limite; // define o limite
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // método para depositar
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("valor inválido para depósito.");
        }
    }

    // método para sacar
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("saque de R$ " + valor + " realizado com sucesso!");
            return true;
        } else {
            System.out.println("saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    // método para consultar saldo
    public double consultarSaldo() {
        return saldo;
    }

    // método abstrato para exibir informações específicas
    public abstract void exibirInformacoes();

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public ContaPoupanca getCliente() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCliente'");
    }

    public double getSaldo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSaldo'");
    }

    public void setCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCliente'");
    }
}
