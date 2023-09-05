package com.mycompany.lfaatividade1;

import aplicacao.Arquivo;
import aplicacao.Automato;

public class LfaAtividade1 {

    public static void main(String[] args) {
        
        Arquivo arquivo = new Arquivo("C:\\Users\\bruno\\OneDrive\\\u00C1rea de Trabalho\\Projetos\\Java\\LfaAtividade1\\src\\main\\java\\automatos\\automato1.csv"); 
        
        Automato automato = new Automato(arquivo);

        String palavraTeste = "abba";

        boolean aceita = automato.validarPalavra(palavraTeste);

        if (aceita) {
            System.out.println("A palavra \"" + palavraTeste + "\" é aceita.");
        } else {
            System.out.println("A palavra \"" + palavraTeste + "\" é rejeitada.");
        }
    }
}
