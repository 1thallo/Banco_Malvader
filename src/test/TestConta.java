// package src.test;

// import src.model.ContaCorrente;
// import src.model.ContaPoupanca;

// public class TestConta {
// public static void main(String[] args) {
// // Criando uma conta poupança
// ContaPoupanca cp = new ContaPoupanca(12345, 500.00, "Poupança", (int)
// 1000.00, 0.05);

// // Criando uma conta corrente
// ContaCorrente cc = new ContaCorrente(67890, 2000.00, "Corrente", 5000.00,
// "30/12/2024");

// // Testando a exibição das informações
// System.out.println("Informações da Conta Poupança:");
// cp.exibirInformacoes();

// System.out.println("\nInformações da Conta Corrente:");
// cc.exibirInformacoes();

// // Testando depósito e saque na conta poupança
// System.out.println("\nTestando Conta Poupança:");
// cp.depositar(200.00);
// cp.sacar(150.00);
// System.out.println("Saldo final da conta poupança: R$ " +
// cp.consultarSaldo());

// // Testando depósito e saque na conta corrente
// System.out.println("\nTestando Conta Corrente:");
// cc.depositar(500.00);
// cc.sacar(250.00);
// System.out.println("Saldo final da conta corrente: R$ " +
// cc.consultarSaldo());
// }
// }
