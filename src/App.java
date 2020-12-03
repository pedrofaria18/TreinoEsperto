
import Arvore.ABB;
import Cria.CriaAtleta;
import Cria.CriaExercicio;
import Cria.CriaSerie;

import Dados.Atleta;
//import Dados.Series;
import Dados.Series;
import Lista.AtletaLista;
//import Lista.SeriesLista;

import Hash.HashAtleta;
import Hash.HashExercicio;

//import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Arvore.Heap;

public class App {

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println("Bem vindo ao Treino Esperto!");

    login();
  }

  public static void login() throws FileNotFoundException {
    Scanner ler = new Scanner(System.in);
    HashAtleta atletaHash = CriaAtleta.criaAtleta();
    System.out.println("Para fazer o login digite o CPF: ");
    String cpf = ler.nextLine();
    System.out.println("Loading..... ");
    ABB seriesArvore = CriaSerie.criaSerie(cpf);
    Heap seriesHeap = CriaSerie.seriesHeap(seriesArvore, cpf);

    AtletaLista buscaLista = HashAtleta.buscaHash(cpf);

    Atleta buscaAtleta = null;
    while (buscaAtleta == null) {

      buscaAtleta = buscaLista.localizarAtleta(cpf);

      if (buscaAtleta != null) {
        System.out.println("\nBem vindo " + buscaAtleta.nome + "!!");

        menuPrincipal(cpf, seriesArvore, seriesHeap);
      } else {
        System.out.println("Atleta não encontrado, por favor digite seu cpf novamente: ");
        cpf = ler.nextLine();
        buscaLista = HashAtleta.buscaHash(cpf);
      }
    }
    ler.close();
  }

  public static void menuPrincipal(String cpf, ABB seriesArvore, Heap seriesHeap) throws FileNotFoundException {
    Scanner ler = new Scanner(System.in);

    System.out.println("Escolha o número respectivo à funcionalidade desejada:");
    System.out.println("1 - Listar série");
    System.out.println("2 - Cálculo");
    System.out.println("3 - Atletas por altura");
    int escolha = ler.nextInt();

    switch (escolha) {
      case 1:
        CriaSerie.listaSerie(seriesHeap);
        break;

      case 2:

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

      default:
        System.out.println("Funcionalidade escolhida não existe");
        break;
    }
    ler.close();
  }
}
