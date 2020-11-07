import Cria.CriaAtleta;
import Dados.Atleta;
import Lista.AtletaLista;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println("Bem vindo ao Treino Esperto!");
    login();
  }

  public static void login() throws FileNotFoundException {
    Scanner ler = new Scanner(System.in);

    System.out.println("Para fazer o login digite o CPF: ");
    String cpf = ler.nextLine();

    AtletaLista atletaLista = CriaAtleta.criaAtleta();
    Atleta busca = null;
    String buscaCpf = cpf;

    while (busca == null) {

      busca = atletaLista.localizarAtleta(buscaCpf);

      if (busca != null) {
        System.out.println("\nBem vindo " + busca.nome + "!!");
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.menuPrincipal(cpf);
      } else {
        System.out.println("Atleta não encontrado, por favor digite seu cpf novamente: ");
        buscaCpf = ler.nextLine();
      }
    }

    ler.close();
  }
}
