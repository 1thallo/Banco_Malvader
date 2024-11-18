package initial;

import java.time.LocalDate;

public abstract class Usuario {
    protected int id;
    protected String nome;
    protected String cpf;
    protected LocalDate dataNascimento;
    protected String telefone;
    protected String senha;
    protected String tipoUsuario; // FUNCIONARIO ou CLIENTE

    public Usuario(int id, String nome, String cpf, LocalDate dataNascimento, String telefone, String senha,
            String tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(int id2, String nome2, String cpf2, LocalDate dataNascimento2, String telefone2, Endereco endereco) {
        // TODO Auto-generated constructor stub
    }

    // Método abstrato para login - será implementado nas subclasses
    public abstract boolean login(String senha);

    public void logout() {
        System.out.println(nome + " realizou logout com sucesso.");
    }

    public String consultarDados() {
        return "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Data de Nascimento: " + dataNascimento + "\n" +
                "Telefone: " + telefone + "\n" +
                "Tipo de Usuário: " + tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
