package Lista;

import Dados.Exercicio;
import Elemento.HeapElement;

public class HeapLista {
    public HeapElement primeiro;
    public HeapElement ultimo;

    public HeapLista() {
        primeiro = new HeapElement(null);
        ultimo = primeiro;
    }

    public void inserir(Exercicio exercicio) {
        HeapElement novo = new HeapElement(exercicio);
        ultimo.proximo = novo;
        ultimo = novo;
    }

    public Exercicio localizarExercicio(String cpf, int escolha) {
        HeapElement aux = primeiro.proximo;

        while (aux != null) {
            if (aux.equals(cpf)) {
                if (escolha == 3)
                    caloriasGastas(cpf);
                else if (escolha == 2)
                    imprimeLista(cpf);
                return aux.exercicio;
            } else {
                aux = aux.proximo;
            }
        }
        return null;
    }

    public void imprimeLista(String cpf) {
        HeapElement percorre = primeiro.proximo;
        int cont = 0;

        while (percorre != null) {
            if (percorre.equals(cpf)) {
                System.out.println(cont + " " + percorre.exercicio);
                percorre = percorre.proximo;
                cont++;
            } else {
                percorre = percorre.proximo;
            }
        }
    }

    public void caloriasGastas(String cpf) {
        HeapElement percorre = primeiro.proximo;
        double kcal = 0;
        int series = 0;
        int repeticoes = 0;
        double tempExecucao = 0;
        int intervalo = 0;
        double tempo = 0;

        while (percorre != null) {
            if (percorre.equals(cpf)) {
                switch (percorre.exercicio.dificuldade) {
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
                System.out.println("Tempo da serie: " + tempo);
                percorre = percorre.proximo;
            } else {
                percorre = percorre.proximo;
            }
        }
        System.out.println("Você já gastou " + kcal + "kcal no total");
    }

}
