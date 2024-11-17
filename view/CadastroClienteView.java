package Banco_Malvader.view;

import java.util.Scanner;
import Banco_Malvader.dao.ClienteDAO;
import Banco_Malvader.model.Cliente;

public class CadastroClienteView {

    public void exibirCadastro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Cliente");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, dataNascimento, telefone, endereco, cep, bairro, cidade, estado,
                senha);
        ClienteDAO clienteDAO = new ClienteDAO();

        if (clienteDAO.cadastrarCliente(cliente)) {
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar cliente.");
        }

        scanner.close();
    }
}
