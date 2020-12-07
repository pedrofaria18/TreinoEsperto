package Cria;

import Arvore.ABB;
import Arvore.HeapSeries;
import Dados.Series;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class CriaSerie {
    public static ABB criaSerie() throws FileNotFoundException {
        Scanner lerArquivo = new Scanner(new File("Series.txt"));

        ABB seriesArvore = new ABB();

        while (lerArquivo.hasNextLine()) {
            String linhaAtual = lerArquivo.nextLine();
            String[] dados = linhaAtual.split(";");
            Series series = new Series(dados[0], dados[1], dados[2]);
            seriesArvore.inserir(series);

        }

        lerArquivo.close();
        return seriesArvore;
    }

    public static HeapSeries seriesHeap(ABB seriesArvore, String cpf) {

        HeapSeries seriesHeap = new HeapSeries();
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

    public static void listaSerie(HeapSeries seriesHeap) {
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