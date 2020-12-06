
import Arvore.ABB;
import Cria.CriaAtleta;
import Cria.CriaExercicio;
import Cria.CriaSerie;

import Dados.Atleta;
import Dados.Series;
import Dados.Exercicio;
import Lista.AtletaLista;
//import Lista.SeriesLista;
import Lista.ExercicioLista;
import Lista.HeapLista;
import Hash.HashAtleta;
import Hash.HashExercicio;

//import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Arvore.HeapSeries;

public class App {

  public static void main(String[] args) throws FileNotFoundException {

    login();
  }

  public static void login() throws FileNotFoundException {
    Scanner ler = new Scanner(System.in);
    System.out.println("Loading..... ");
    HashAtleta atletaHash = CriaAtleta.criaAtleta();
    HashExercicio exercicioHash = CriaExercicio.criaExercicio();
    ABB seriesArvore = CriaSerie.criaSerie();
    System.out.println("Bem vindo ao Treino Esperto!");
    System.out.println("Para fazer o login digite o CPF: ");
    String cpf = ler.nextLine();

    HeapSeries seriesHeap = CriaSerie.seriesHeap(seriesArvore, cpf);

    AtletaLista buscaAtletaLista = HashAtleta.buscaAtleta(cpf);

    Atleta buscaAtleta = null;
    while (buscaAtleta == null) {

      buscaAtleta = buscaAtletaLista.localizarAtleta(cpf);

      if (buscaAtleta != null) {
        System.out.println("\nBem vindo " + buscaAtleta.nome + "!!");

        menuPrincipal(cpf, seriesArvore, seriesHeap);
      } else {
        System.out.println("Atleta não encontrado, por favor digite seu cpf novamente: ");
        cpf = ler.nextLine();
        buscaAtletaLista = HashAtleta.buscaAtleta(cpf);
      }
    }
    ler.close();
  }

  public static void menuPrincipal(String cpf, ABB seriesArvore, HeapSeries seriesHeap) throws FileNotFoundException {
    Scanner ler = new Scanner(System.in);

    System.out.println("Escolha o número respectivo à funcionalidade desejada:");
    System.out.println("1 - Listar série");
    System.out.println("2 - Cálculo de gasto calórico");
    System.out.println("3 - Atletas por altura");
    System.out.println("4 - Area de testes");
    int escolha = ler.nextInt();

    switch (escolha) {
      case 1:
        CriaSerie.listaSerie(seriesHeap);
        break;

      case 2:
        HeapLista buscaExercicioLista = HashExercicio.buscaExercicio(cpf);
        Exercicio buscaExercicio = buscaExercicioLista.localizarExercicio(cpf);
        System.out.println(buscaExercicio);

        break;

      case 3:
        String max;
        String min;
        int maximo;
        int minimo;
        boolean condicao = true;

        do {
          System.out.println("Insira a altura máxima");
          max = ler.next();

          System.out.println("Insira a altura mínima");
          min = ler.next();

          if (max.contains(",")) {
            max = max.replace(",", "");
          }
          if (max.contains(".")) {
            max = max.replace(".", "");
          }
          if (min.contains(",")) {
            min = min.replace(",", "");
          }
          if (min.contains(".")) {
            min = min.replace(".", "");
          }
          maximo = Integer.parseInt(max);
          minimo = Integer.parseInt(min);
          if (minimo > maximo) {
            System.out.println("Faixa de altura inválida! Favor inserir novamente.");
            condicao = false;
          } else
            condicao = true;
        } while (condicao != true);

        HashAtleta.alturaAtletas(maximo, minimo);
        break;

      case 4:
        double kcal = 0;
        int series = 3;
        int repeticoes = 6;
        double tempExecucao = 1.5;
        int intervalo = 60;
        double tempo = ((series * repeticoes * tempExecucao) + (series * intervalo)) / 60;

        kcal = (tempo / 60) * 6;
        System.out.println("Básico: " + kcal + "tempo: " + tempo);

        series = 4;
        repeticoes = 8;
        tempExecucao = 2;
        intervalo = 60;
        tempo = ((series * repeticoes * tempExecucao) + (series * intervalo)) / 60;
        kcal = (tempo / 60) * 6;
        System.out.println("Intermediário: " + kcal + "tempo: " + tempo);

        series = 5;
        repeticoes = 10;
        tempExecucao = 2;
        intervalo = 45;
        tempo = ((series * repeticoes * tempExecucao) + (series * intervalo)) / 60;
        kcal = (tempo / 60) * 6;
        System.out.println("Avançado: " + kcal + "tempo: " + tempo);

        series = 5;
        repeticoes = 13;
        tempExecucao = 3;
        intervalo = 30;
        tempo = ((series * repeticoes * tempExecucao) + (series * intervalo)) / 60;
        kcal = (tempo / 60) * 6;
        System.out.println("Atleta: " + kcal + "tempo: " + tempo);

        series = 6;
        repeticoes = 15;
        tempExecucao = 5;
        intervalo = 15;
        tempo = ((series * repeticoes * tempExecucao) + (series * intervalo)) / 60;
        kcal = (tempo / 60) * 6;
        System.out.println("Profissional: " + kcal + "tempo: " + tempo);

        int num1 = 0;
        int num2 = 0;
        int num3 = 3;
        int num4 = 5;
        int num5 = 2;

        double mult = num1 * 3.45 + num2 * 5.06 + num3 + 5.416 + num4 * 5.75 + num5 * 9;

        System.out.println("Testando tempo total: " + mult);

        break;

      default:
        System.out.println("Funcionalidade escolhida não existe");
        break;
    }
    ler.close();
  }
}
