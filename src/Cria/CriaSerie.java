package Cria;

import Arvore.ABB;
import Dados.Series;
import Lista.SeriesLista;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class CriaSerie {
    public static SeriesLista criaSerie() throws FileNotFoundException {
        Scanner lerArquivo = new Scanner(new File("Series.txt"));
        SeriesLista seriesLista = new SeriesLista();
        ABB seriesArvore = new ABB();

        while(lerArquivo.hasNextLine()) {
            String linhaAtual = lerArquivo.nextLine();
            String [] dados = linhaAtual.split(";");
            Series series = new Series(
                    dados[0],
                    dados[1],
                    dados[2]
            );
            seriesArvore.inserir(series);
            seriesLista.inserir(series);
        }

        String cpf = "12345678990";
        Series aux = seriesArvore.buscar(cpf);
        if(aux!=null)
            System.out.println(aux);
        else
            System.out.println("Aluno não existe.");
        lerArquivo.close();

        lerArquivo.close();
        return seriesLista;
    }
}
