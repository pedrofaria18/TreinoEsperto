package Hash;

import Arvore.HeapMinExercicios;
import Dados.Exercicio;

import Elemento.HeapElement;

import Lista.HeapLista;

public class HashExercicio {
    public static HeapLista tabela[];
    private static final int TAMANHO = 10000;

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
        int posicao = cpfConvertido % 9973;
        return posicao;
    }

    public void addTabela(Exercicio exercicio) {
        int index = funcaoHash(exercicio.cpf);
        tabela[index].inserir(exercicio);
    }

    public static HeapMinExercicios buscaHeapExercicio(String cpf) {
        HeapElement aux = tabela[funcaoHash(cpf)].primeiro.proximo;

        while (aux != null) {
            if (aux.exercicioHeap.get(0).equals(cpf)) {
                return aux.exercicioHeap;
            } else {
                aux = aux.proximo;
            }
        }
        return tabela[funcaoHash(cpf)].primeiro.exercicioHeap;
    }

    public static void listaExercicio(HeapMinExercicios exercicioHeap) {
        while (exercicioHeap.size() != 0) {
            int size = exercicioHeap.size();

            for (int i = size - 1; i >= 0; i--) {
                Exercicio aux = exercicioHeap.retono();
                System.out.println(aux.data + " - " + aux.dificuldade);
            }
        }
    }

    public static void caloriasGastas(HeapMinExercicios exercicioHeap) {

        double kcal = 0;
        int series = 0;
        int repeticoes = 0;
        double tempExecucao = 0;
        int intervalo = 0;
        double tempo = 0;

        while (exercicioHeap.size() != 0) {
            int size = exercicioHeap.size();

            for (int i = size - 1; i >= 0; i--) {
                Exercicio aux = exercicioHeap.retono();

                switch (aux.dificuldade) {
                    case "1":
                        series = 3;
                        repeticoes = 6;
                        tempExecucao = 2;
                        intervalo = 60;
                        break;
                    case "2":
                        series = 4;
                        repeticoes = 8;
                        tempExecucao = 2;
                        intervalo = 60;
                        break;
                    case "3":
                        series = 5;
                        repeticoes = 10;
                        tempExecucao = 2;
                        intervalo = 45;
                        break;
                    case "4":
                        series = 5;
                        repeticoes = 13;
                        tempExecucao = 3;
                        intervalo = 30;
                        break;
                    case "5":
                        series = 6;
                        repeticoes = 15;
                        tempExecucao = 5;
                        intervalo = 15;
                        break;
                }
                tempo = ((series * repeticoes * tempExecucao) + (series * intervalo)) / 60;
                kcal = kcal + (tempo * 6);

            }
            System.out.println("Você já gastou " + kcal + "kcal no total");
        }

    }
}
