package Elemento;

import Dados.Exercicio;

public class ExercicioElement {
    public Exercicio exercicio;
    public ExercicioElement proximo;

    public ExercicioElement(Exercicio exercicio) {
        this.exercicio = exercicio;
        this.proximo = null;
    }

    @Override
    public boolean equals(Object obj){
        String aux = (String)obj;
        return exercicio.equals(aux);
    }
}