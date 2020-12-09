package Cria;

import Arvore.ABB;
import Arvore.HeapMinSeries;
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

    public static HeapMinSeries seriesHeap(ABB seriesArvore, String cpf) {
        HeapMinSeries seriesHeap = new HeapMinSeries();
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

    public static void listaSerie(HeapMinSeries seriesHeap) {
        while (seriesHeap.size() != 0) {
            int size = seriesHeap.size();

            for (int i = size - 1; i >= 0; i--) {
                Series aux = seriesHeap.retorno();

                System.out.println(aux.data + " - " + aux.duracao);
            }
        }
    }
}