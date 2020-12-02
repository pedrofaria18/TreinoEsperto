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
        Heap seriesHeap = new Heap();

        while (lerArquivo.hasNextLine()) {
            String linhaAtual = lerArquivo.nextLine();
            String[] dados = linhaAtual.split(";");
            Series series = new Series(dados[0], dados[1], dados[2]);
            seriesArvore.inserir(series);
            seriesLista.inserir(series);
        }

        Series aux = null;

        while (aux == null) {
            aux = seriesArvore.buscar(cpf);
            if (aux != null) {
                // System.out.println(aux);
                seriesArvore.emOrdem(cpf, seriesHeap);
                int size = seriesHeap.size();

                Series[] vetorOrdem = new Series[size];

                for (int i = size - 1; i >= 0; i--) {
                    Series max = seriesHeap.delete();
                    vetorOrdem[i] = max;
                }

                for (int j = 0; j <= size - 1; j++) {
                    System.out.println(j + " - " + vetorOrdem[j].data + " - " + vetorOrdem[j].duracao);
                }

            } else {
                System.out.println("Série não existe.");
            }
        }

        lerArquivo.close();
        return seriesLista;
    }
}
