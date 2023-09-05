package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
    private int[][] matrizTransicao;
    private List<Integer> estadosFinais;

    public Arquivo(String nomeArquivo) {
        estadosFinais = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            // Lê a primeira linha para obter os estados finais
            String primeiraLinha = br.readLine();
            String[] estadosFinaisStr = primeiraLinha.split(";");
            
            for (String estadoFinalStr : estadosFinaisStr) {
                estadosFinais.add(Integer.parseInt(estadoFinalStr));
            }

            // Lê a segunda linha para obter o número de linhas e colunas
            String segundaLinha = br.readLine();
            String[] dimensoes = segundaLinha.split(";");
            int numLinhas = Integer.parseInt(dimensoes[0]);
            int numColunas = Integer.parseInt(dimensoes[1]);

            // Inicializa a matriz de transição com o tamanho correto
            matrizTransicao = new int[numLinhas][numColunas];

            // Lê as linhas subsequentes para preencher a matriz de transição
            for (int i = 0; i < numLinhas; i++) {
                String linha = br.readLine();
                String[] valores = linha.split(";");
                for (int j = 0; j < numColunas; j++) {
                    matrizTransicao[i][j] = Integer.parseInt(valores[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[][] getMatrizTransicao() {
        return matrizTransicao;
    }

    public List<Integer> getEstadosFinais() {
        return estadosFinais;
    }
}

    

