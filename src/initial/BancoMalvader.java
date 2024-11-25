package src.initial;

public class BancoMalvader {
    private String nome;

    public BancoMalvader(String nome) {
        this.nome = nome;
    }

    // Método principal que inicia o programa
    public static void main(String[] args) {
        BancoMalvader banco = new BancoMalvader("Banco Malvader");
        // banco.iniciarSistema();
    }
}