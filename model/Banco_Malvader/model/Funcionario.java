package initial;

import java.time.LocalDate;

public class Funcionario extends Usuario {
    private String codigoFuncionario;
    private String cargo;

    public Funcionario(int id, String nome, String cpf, LocalDate dataNascimento, String telefone, String senha,
            String tipoUsuario, String codigoFuncionario, String cargo) {
        super(id, nome, cpf, dataNascimento, telefone, senha, tipoUsuario); // Chamada ao construtor de Usuario
        this.codigoFuncionario = codigoFuncionario;
        this.cargo = cargo;
    }

    @Override
    public boolean login(String senha) {
        return this.senha.equals(senha);
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
