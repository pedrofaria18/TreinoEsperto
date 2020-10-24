import Cria.CriaAtleta;
import Dados.Atleta;
import Lista.AtletaLista;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class App {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner ler = new Scanner(System.in);

    CriaAtleta criaAtleta = new CriaAtleta();

    AtletaLista atletaLista = CriaAtleta.criaAtleta();

    System.out.println("Para fazer o login digite o CPF: ");
    String cpf = ler.nextLine();

    Atleta busca = null;
    login(busca, atletaLista, cpf);


    ler.close();
  }

  // Validar o CPF do atleta
  public static void login(Atleta busca, AtletaLista atletaLista, String cpf) {
    Scanner ler = new Scanner(System.in);
    String buscaCpf = cpf;

    while(busca == null) { // Enquanto busca = null

      busca = atletaLista.localizarAtleta(buscaCpf); // método localizado em AtletaLista

      if(busca != null) {
        System.out.println("\nBem vindo " + busca.nome + "!!");
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.menuPrincipal();
      } else {
        System.out.println("Atleta não encontrado, por favor digite seu cpf novamente: ");
        buscaCpf = ler.nextLine();
      }
    }

    ler.close();
  }

}
