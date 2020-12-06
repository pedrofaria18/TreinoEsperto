package Lista;

import Arvore.HeapExercicios;
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

    public Exercicio localizarExercicio(String cpf) {
        HeapElement aux = primeiro.proximo;

        while (aux != null) {
            if (aux.equals(cpf)) {
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

}
