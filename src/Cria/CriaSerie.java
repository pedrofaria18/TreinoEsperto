package Cria;

import Arvore.ABB;
import Arvore.Heap;
import Dados.Series;
//import Lista.SeriesLista;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class CriaSerie {
    public static ABB criaSerie(String cpf) throws FileNotFoundException {
        Scanner lerArquivo = new Scanner(new File("Series.txt"));
        // SeriesLista seriesLista = new SeriesLista();
        ABB seriesArvore = new ABB();

        while (lerArquivo.hasNextLine()) {
            String linhaAtual = lerArquivo.nextLine();
            String[] dados = linhaAtual.split(";");
            Series series = new Series(dados[0], dados[1], dados[2]);
            seriesArvore.inserir(series);
            // seriesLista.inserir(series);
        }

        lerArquivo.close();
        return seriesArvore;
    }

    public static Heap seriesHeap(ABB seriesArvore, String cpf) {

        Heap seriesHeap = new Heap();
        Series aux = null;

        while (aux == null) {
            aux = seriesArvore.buscar(cpf);
            if (aux != null)
                seriesArvore.emOrdem(cpf, seriesHeap);

            else
                System.out.println("Série não existe.");

        }
        return seriesHeap;
    }

    public static void listaSerie(Heap seriesHeap) {
        while (seriesHeap.size() != 0) {
            int size = seriesHeap.size();

            Series[] vetorOrdem = new Series[size];

            for (int i = size - 1; i >= 0; i--) {
                Series max = seriesHeap.delete();
                vetorOrdem[i] = max;
            }

            for (int j = 0; j <= size - 1; j++) {
                System.out.println(j + " - " + vetorOrdem[j].data + " - " + vetorOrdem[j].duracao);
            }
        }
    }
}