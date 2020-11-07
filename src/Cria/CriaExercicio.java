package Cria;

import Dados.Exercicio;
import Lista.ExercicioLista;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class CriaExercicio {
    public static ExercicioLista criaExercicio() throws FileNotFoundException {
        Scanner lerArquivo = new Scanner(new File("Exercicio.txt"));
        ExercicioLista exercicioLista = new ExercicioLista();

        while(lerArquivo.hasNextLine()) {
            String linhaAtual = lerArquivo.nextLine();
            String [] dados = linhaAtual.split(";");
            Exercicio exercicio = new Exercicio(
                    dados[0],
                    LocalDate.parse(dados[1]),
                    dados[2]
            );
            exercicioLista.inserir(exercicio);
        }

        lerArquivo.close();
        return exercicioLista;
    }
}
