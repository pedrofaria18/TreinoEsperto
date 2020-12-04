package Elemento;

import Dados.Exercicio;

public class HeapElement {
    public Exercicio exercicio;
    public HeapElement proximo;

    public HeapElement(Exercicio exercicio) {
        this.exercicio = exercicio;
        this.proximo = null;
    }

    @Override
    public boolean equals(Object obj) {
        String aux = (String) obj;
        return exercicio.equals(aux);
    }
}