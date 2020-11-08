package Cria;

import Dados.Series;
import Lista.SeriesLista;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class CriaSerie {
    public static SeriesLista criaSerie() throws FileNotFoundException {
        Scanner lerArquivo = new Scanner(new File("Series.txt"));
        SeriesLista seriesLista = new SeriesLista();

        while(lerArquivo.hasNextLine()) {
            String linhaAtual = lerArquivo.nextLine();
            String [] dados = linhaAtual.split(";");
            Series series = new Series(
                    dados[0],
                    dados[1],
                    dados[2]
            );
            seriesLista.inserir(series);
        }

        lerArquivo.close();
        return seriesLista;
    }
}
