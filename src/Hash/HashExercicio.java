package Hash;

import java.time.LocalDate;

import Dados.Exercicio;
import Elemento.ExercicioElement;
import Lista.ExercicioLista;

public class HashExercicio {
    public static ExercicioLista tabela[];
    private static final int TAMANHO = 50;

    public HashExercicio() {
        tabela = new ExercicioLista[TAMANHO];
        inicializaListas();
    }

    public static void inicializaListas() {
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new ExercicioLista();
        }
    }

    public static int funcaoHash(String cpf) {

        cpf = cpf.substring(0, 7);
        int cpfConvertido = Integer.parseInt(cpf);
        int posicao = cpfConvertido % 4999;
        return posicao;
    }

    public void addTabela(Exercicio exercicio) {
        tabela[funcaoHash(exercicio.data)].inserir(exercicio);
    }

    public static ExercicioLista buscaHash(String data) {
        return tabela[funcaoHash(data)];
    }

    public static void Exercicios() {
        ExercicioElement aux = null;
        // String cpf = "";

        for (int i = 0; i < TAMANHO; i++) {
            aux = tabela[i].primeiro.proximo;
            // System.out.println(i);
            while (aux != null) {

                System.out.println(aux);
            }
            aux = aux.proximo;
        }
    }
}
