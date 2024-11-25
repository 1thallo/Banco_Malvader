package src.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente extends Usuario {
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;

    // Construtor padrão
    public Cliente() {
        super();
    }

    // Construtor completo
    public Cliente(String nome, String cpf, String dataNascimento, String telefone, Endereco endereco, String cep,
                   String bairro, String cidade, String estado, String senha) {
        super(nome, cpf, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("yyyy-MM-dd")), telefone, endereco, "CLIENTE", senha);
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Construtor completo com id
    public Cliente(int id, String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco endereco,
                   String cep, String bairro, String cidade, String estado, String senha) {
        super(id, nome, cpf, dataNascimento, telefone, endereco, "CLIENTE", senha);
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Construtor alternativo
    public Cliente(String nomeUsuario, String cpfUsuario, LocalDate dataNascimento, String telefone, Endereco endereco, String senha) {
        super(nomeUsuario, cpfUsuario, dataNascimento, telefone, endereco, "CLIENTE", senha);
    }

    @Override
    public boolean login(String senha) {
        return verificarSenha(senha);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}