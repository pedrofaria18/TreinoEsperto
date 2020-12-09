package Lista;

import Arvore.HeapMinExercicios;
//import Dados.Exercicio;
import Elemento.ExercicioElement;

public class ExercicioLista {
    public ExercicioElement primeiro;
    public ExercicioElement ultimo;

    public ExercicioLista() {
        primeiro = new ExercicioElement(null);
        ultimo = primeiro;
    }

    public void inserir(HeapMinExercicios exercicio) {
        ExercicioElement novo = new ExercicioElement(exercicio);
        ultimo.proximo = novo;
        ultimo = novo;
    }

    public HeapMinExercicios localizarExercicio(String cpf) {
        ExercicioElement aux = primeiro.proximo;

        while (aux != null) {
            if (aux.equals(cpf)) {
                return aux.exercicio;
            } else {
                aux = aux.proximo;
            }
        }

        return null;
    }

    public void ImprimeLista() {
        ExercicioElement percorre = primeiro.proximo;

        while (percorre != null) {
            System.out.println(percorre.exercicio);
            percorre = percorre.proximo;
        }
    }
}