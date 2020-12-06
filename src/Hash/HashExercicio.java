package Hash;

import Arvore.HeapExercicios;
import Dados.Exercicio;
import Elemento.ExercicioElement;
import Elemento.HeapElement;
import Lista.ExercicioLista;
import Lista.HeapLista;

public class HashExercicio {
    public static HeapLista tabela[];
    private static final int TAMANHO = 5000;

    public HashExercicio() {
        tabela = new HeapLista[TAMANHO];

        inicializaListas();
    }

    public static void inicializaListas() {
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new HeapLista();
        }
    }

    public static int funcaoHash(String cpf) {

        cpf = cpf.substring(0, 7);
        int cpfConvertido = Integer.parseInt(cpf);
        int posicao = cpfConvertido % 4999;
        return posicao;
    }

    public void addTabela(Exercicio exercicio) {
        tabela[funcaoHash(exercicio.cpf)].inserir(exercicio);
    }

    public static HeapLista buscaExercicio(String cpf) {
        return tabela[funcaoHash(cpf)];
    }

    public static void Exercicios(String cpf) {
        HeapElement aux = null;

        aux = tabela[funcaoHash(cpf)].primeiro.proximo;
        while (aux != null) {
            aux = tabela[funcaoHash(cpf)].primeiro.proximo;
            System.out.println(aux.exercicio.cpf + " - " + aux.exercicio.data + " - " + aux.exercicio.dificuldade);
            aux = aux.proximo;
        }

    }

    public static void listaExercicio(HeapExercicios seriesHeap) {
        while (seriesHeap.size() != 0) {
            int size = seriesHeap.size();

            Exercicio[] vetorOrdem = new Exercicio[size];

            for (int i = size - 1; i >= 0; i--) {
                Exercicio max = seriesHeap.delete();
                vetorOrdem[i] = max;
            }

            for (int j = 0; j <= size - 1; j++) {
                System.out.println(j + " - " + vetorOrdem[j].data + " - " + vetorOrdem[j].dificuldade);
            }
        }
    }
}
