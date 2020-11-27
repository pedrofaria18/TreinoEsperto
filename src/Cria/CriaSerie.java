package Cria;

import Arvore.ABB;
import Arvore.Heap;
import Dados.Series;
import Lista.SeriesLista;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class CriaSerie {
    public static SeriesLista criaSerie(String cpf) throws FileNotFoundException {
        Scanner lerArquivo = new Scanner(new File("Series.txt"));
        SeriesLista seriesLista = new SeriesLista();
        ABB seriesArvore = new ABB();
        Heap<Series> seriesHeap = new Heap<Series>();
        int inseriu = 0;

        while (lerArquivo.hasNextLine()) {
            String linhaAtual = lerArquivo.nextLine();
            String[] dados = linhaAtual.split(";");
            Series series = new Series(dados[0], dados[1], dados[2]);
            seriesArvore.inserir(series);
            seriesLista.inserir(series);
            inseriu++;
        }
        System.out.println(inseriu);
        Series aux = null;

        while (aux == null) {
            aux = seriesArvore.buscar(cpf);
            if (aux != null) {
                System.out.println(aux);
                System.out.println(seriesArvore.emOrdem(cpf));
            } else {
                System.out.println("Série não existe.");
            }
        }

        lerArquivo.close();
        return seriesLista;
    }
}
