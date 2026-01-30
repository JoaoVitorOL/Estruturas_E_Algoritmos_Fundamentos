package algoritmos_ordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// FileReader
// Classe de baixo nível
// Lê caracteres diretamente do arquivo
// Cada chamada:
// acessa o sistema operacional
// Problema:
// Leitura lenta
// Não possui readLine()
// BufferedReader
// Classe de alto nível
// Envolve outro Reader
// Lê blocos grandes de dados para a memória
// Benefícios:
// Muito mais rápido
// Possui readLine()
// Reduz chamadas ao sistema operacional

public class LeitorArquivo {

    public static int[] carregarArray(String caminhoArquivo) {

        ArrayList<Integer> lista = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {

            String linha;

            while ((linha = leitor.readLine()) != null) {

                linha = linha.trim();

                // Ignora linhas vazias
                if (linha.isEmpty()) {
                    continue;
                }

                // Validação de número inteiro
                try {
                    lista.add(Integer.parseInt(linha));
                } catch (NumberFormatException e) {
                    System.out.println("Linha inválida ignorada: " + linha);
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + caminhoArquivo);
            System.out.println("Motivo: " + e.getMessage());
            return new int[0]; // retorno seguro
        }

        // Validação final: arquivo sem números válidos
        if (lista.isEmpty()) {
            System.out.println("Arquivo não contém números válidos.");
            return new int[0];
        }

        // Conversão ArrayList → int[]
        int[] array = new int[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            array[i] = lista.get(i);
        }

        return array;
    }
}

