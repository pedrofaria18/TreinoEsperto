package Cria;

import Dados.Atleta;
import Lista.AtletaLista;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CriaAtleta {
    public static AtletaLista criaAtleta() throws FileNotFoundException {
        Scanner lerArquivo = new Scanner(new File("Atleta.txt")); // Para leitura do arquivo txt
        AtletaLista atletaLista = new AtletaLista(); // Cria uma lista

        while(lerArquivo.hasNextLine()) { // enquanto houver linha
            String linhaAtual = lerArquivo.nextLine(); // lê uma linha
            String [] dados = linhaAtual.split(";"); // separa os dados
            Atleta atleta = new Atleta(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5]); // Cria um atleta
            atletaLista.inserir(atleta); // insere um atleta na lista
        }
        lerArquivo.close();
        return atletaLista;
    }
}
