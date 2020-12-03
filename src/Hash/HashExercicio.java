package Hash;

import java.time.LocalDate;

import Dados.Exercicio;
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

    public static int funcaoHash(LocalDate data) {
        // calcular o valor hash do cpf
        // cpf = cpf.substring(0, 7);
        // int cpfConvertido = Integer.parseInt(data);
        // int posicao = cpfConvertido % 47;
        return posicao;
    }

    public void addTabela(Exercicio exercicio) {
        tabela[funcaoHash(exercicio.data)].inserir(exercicio);
    }

    public static ExercicioLista buscaHash(LocalDate data) {
        return tabela[funcaoHash(data)];
    }

}
