package aplicacao;

import java.util.List;


public class Automato {
    private int[][] matrizTransicao;
    private List<Integer> estadosFinais;

    public Automato(Arquivo arquivo) {
        this.matrizTransicao = arquivo.getMatrizTransicao();
        this.estadosFinais = arquivo.getEstadosFinais();
    }

    public boolean validarPalavra(String palavra) {
        int estadoAtual = 0;

        for (char letra : palavra.toCharArray()) { //para cada letra da palavra se transforma em um vetor de char
            int coluna = letra - 'a'; // esta fazendo a validaçao das letras 'a' vale 96, se chegar 'a' na palavra, 96 - 96 = 0
                                     

            if (coluna < 0 || coluna >= matrizTransicao[0].length) {
                // se qualquer letra for menor que 'a', ou maior que as letras listadas ex 'c'. Vai dar merda
                return false;
            }

            int proximoEstado = matrizTransicao[estadoAtual][coluna];

            if (proximoEstado == -1) {
                // Encontrou uma transição que leva a um estado inválido, rejeita a palavra
                return false;
            }

            estadoAtual = proximoEstado;
        }

        // A palavra é aceita se o estado atual estiver na lista de estados finais
        return estadosFinais.contains(estadoAtual);
    }
}

   



