package Cria;

import Dados.Series;
import Lista.SeriesLista;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class CriaSerie {
    public static SeriesLista criaSerie() throws FileNotFoundException {
        Scanner lerArquivo = new Scanner(new File("Series.txt")); // Para leitura do arquivo txt
        SeriesLista seriesLista = new SeriesLista(); // Cria uma lista

        //DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //DateTimeFormatter formatarTempo = DateTimeFormatter.ofPattern("HH:mm:ss");

        while(lerArquivo.hasNextLine()) { // enquanto houver linha
            String linhaAtual = lerArquivo.nextLine(); // lê uma linha
            String [] dados = linhaAtual.split(";"); // separa os dados
            Series series = new Series(
                    dados[0],
                    LocalDate.parse(dados[1]),
                    dados[2],
                    dados[3]
            ); // Cria uma série
            seriesLista.inserir(series); // insere uma série na lista
        }

        lerArquivo.close();
        return seriesLista;
    }
}
