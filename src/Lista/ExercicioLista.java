package Lista;

import Dados.Exercicio;
import Elemento.ExercicioElement;

public class ExercicioLista {
    public ExercicioElement primeiro;
    public ExercicioElement ultimo;

    public ExercicioLista() {
        primeiro = new ExercicioElement(null);
        ultimo = primeiro;
    }

    public void inserir(Exercicio exercicio) {
        ExercicioElement novo = new ExercicioElement(exercicio);
        ultimo.proximo = novo;
        ultimo = novo;
    }
}