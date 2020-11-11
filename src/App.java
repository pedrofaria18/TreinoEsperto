import Cria.CriaAtleta;
import Cria.CriaSerie;

import Dados.Atleta;
import Dados.Series;

import Lista.AtletaLista;
import Lista.SeriesLista;

import Hash.TabelaHash;
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
    TabelaHash.alturaAtletas();
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
    int escolha = ler.nextInt();

    switch (escolha) {
      case 1:
        listarSerie(cpf);
        break;

      case 2:
        break;

      default:
        System.out.println("Funcionalidade escolhida não existe");
        break;
    }
    ler.close();
  }

  private static void listarSerie(String cpf) throws FileNotFoundException {
  }

  // private static void alturaAtletas() {

  // for (int i = 0; i < TabelaHash.Vetor.length; i++) {

  // TabelaHash.Vetor[i].ImprimeLista();
  // }

}

// Date data = new Date();
// SimpleDateFormat formatar = new SimpleDateFormat("d/M/y");
// String dataFormatada = formatar.format(data);