import Arvore.ABB;
import Cria.CriaAtleta;
import Cria.CriaSerie;

import Dados.Atleta;
import Dados.Series;

import Lista.AtletaLista;
import Lista.SeriesLista;

import Hash.TabelaHash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println("Bem vindo ao Treino Esperto!");

    login();
  }

  public static void login() throws FileNotFoundException {
    Scanner ler = new Scanner(System.in);
    AtletaLista atletaLista = CriaAtleta.criaAtleta();

    System.out.println("Para fazer o login digite o CPF: ");
    String cpf = ler.nextLine();

    AtletaLista buscaLista = TabelaHash.buscaHash(cpf);

    Atleta buscaAtleta = null;
    while (buscaAtleta == null) {

      buscaAtleta = buscaLista.localizarAtleta(cpf);

      if (buscaAtleta != null) {
        System.out.println("\nBem vindo " + buscaAtleta.nome + "!!");

        menuPrincipal(cpf);
      } else {
        System.out.println("Atleta não encontrado, por favor digite seu cpf novamente: ");
        cpf = ler.nextLine();
        buscaLista = TabelaHash.buscaHash(cpf);
      }
    }
    ler.close();
  }

  public static void menuPrincipal(String cpf) throws FileNotFoundException {
    Scanner ler = new Scanner(System.in);

    System.out.println("Escolha o número respectivo à funcionalidade desejada:");
    System.out.println("1 - Listar série");
    System.out.println("2 - Cálculo");
    System.out.println("3 - Atletas por altura");
    int escolha = ler.nextInt();

    switch (escolha) {
      case 1:
        CriaSerie.criaSerie(cpf);
        // listarSerie(cpf);
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

        TabelaHash.alturaAtletas(maximo, minimo);
        break;

      default:
        System.out.println("Funcionalidade escolhida não existe");
        break;
    }
    ler.close();
  }

  private static void listarSerie(String cpf) throws FileNotFoundException {
    Scanner lerArquivo = new Scanner(new File("Series.txt"));
    SeriesLista seriesLista = new SeriesLista();
    ABB seriesArvore = new ABB();
    int inseriu = 0;

    while (lerArquivo.hasNextLine()) {
      String linhaAtual = lerArquivo.nextLine();
      String[] dados = linhaAtual.split(";");
      Series series = new Series(dados[0], dados[1], dados[2]);
      seriesArvore.inserir(series);
      seriesLista.inserir(series);
      inseriu++;
    }
    System.out.println(inseriu);

    Series aux = seriesArvore.buscar(cpf);
    if (aux != null) {
      System.out.println(aux);
    } else {
      System.out.println("Aluno não existe.");
    }
    lerArquivo.close();
  }

}

// Date data = new Date();
// SimpleDateFormat formatar = new SimpleDateFormat("d/M/y");
// String dataFormatada = formatar.format(data);