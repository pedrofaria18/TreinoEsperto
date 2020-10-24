import Cria.CriaAtleta;
import Dados.Atleta;
import Lista.AtletaLista;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner ler = new Scanner(System.in);

    CriaAtleta criaAtleta = new CriaAtleta();

    AtletaLista atletaLista = CriaAtleta.criaAtleta();
    int escolha = 0;

    System.out.println("Bem vindo ao Treino Esperto!");
    do {
      System.out.println("Escolha o número respectivo à funcionalidade desejada:");
      System.out.println("1 - Login");
      System.out.println("2 - Cadastro de novo usuário");
      System.out.println("9 - Finalizar programa");
      escolha = ler.nextInt();

      switch (escolha) {
        case 1:
          System.out.println("Para fazer o login digite o CPF: ");
          String cpf = ler.nextLine();
          Atleta busca = null;
          login(busca, atletaLista, cpf);
          break;

        case 2:
          cadastro();
          break;

        case 9:
          System.out.println("Volte sempre!");
          break;
      }
    } while (escolha != 9);
    ler.close();
  }

  // Validar o CPF do atleta
  public static void login(Atleta busca, AtletaLista atletaLista, String cpf) {
    Scanner ler = new Scanner(System.in);
    String buscaCpf = cpf;

    while (busca == null) { // Enquanto busca = null

      busca = atletaLista.localizarAtleta(buscaCpf); // método localizado em AtletaLista

      if (busca != null) {
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

  public static void cadastro() {
    Scanner ler = new Scanner(System.in);
    String[] tipos = { "nome", "cpf", "data de nascimento", "genero", "peso", "altura" };
    String dados = "";

    System.out.println("Menu de cadastro ");
    for (int i = 0; i < 6; i++) {
      if ((i == 2) || (i == 5))
        System.out.println("Insira sua " + tipos[i] + ":");
      else
        System.out.println("Insira seu " + tipos[i] + ":");
      dados = dados.concat(ler.nextLine());
      if (i != 5)
        dados = dados.concat(";");
      else
        dados = dados.concat("\n");
    }

    try (FileWriter criador = new FileWriter("Atleta.txt", true);
        BufferedWriter buffer = new BufferedWriter(criador);
        PrintWriter escritor = new PrintWriter(buffer);) {
      escritor.append(dados);
      System.out.println("Cadastro concluído com sucesso!");
    } catch (Exception e) {
      System.out.println("Erro ao cadastrar o atleta");
    }

    ler.close();
  }
}
