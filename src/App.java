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

    System.out.println("Para fazer o login digite o CPF: ");
    String cpf = ler.nextLine();

    Atleta busca = null;
    String buscaCpf = cpf;

    while (busca == null) {

      busca = atletaLista.localizarAtleta(buscaCpf);

      if (busca != null) {
        System.out.println("\nBem vindo " + busca.nome + "!!");

        TabelaHash.Vetor[2].ImprimeLista();
        menuPrincipal(cpf);
      } else {
        System.out.println("Atleta não encontrado, por favor digite seu cpf novamente: ");
        buscaCpf = ler.nextLine();
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
}

// Date data = new Date();
// SimpleDateFormat formatar = new SimpleDateFormat("d/M/y");
// String dataFormatada = formatar.format(data);