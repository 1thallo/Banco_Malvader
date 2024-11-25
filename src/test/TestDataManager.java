package src.test;

import java.util.List;

import src.util.DataManager;

public class TestDataManager {
    public static void main(String[] args) {
        // Caminho do arquivo
        String caminho = "dados.txt";

        // Testando gravação de dados
        String dadosParaGravar = "Exemplo de dado no arquivo";
        boolean sucessoGravacao = DataManager.gravarDadosEmArquivo(caminho, dadosParaGravar);
        if (sucessoGravacao) {
            System.out.println("Dados gravados com sucesso!");
        }

        // Testando leitura de dados
        List<String> dadosLidos = DataManager.lerDadosDeArquivo(caminho);
        for (String linha : dadosLidos) {
            System.out.println("Linha lida: " + linha);
        }
    }
}
