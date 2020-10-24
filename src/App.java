import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import Dados.Atleta;
import Dados.Series;

import Lista.AtletaLista;
import Lista.SeriesLista;


public class App {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner ler = new Scanner(System.in);

    AtletaLista atletaLista = criaAtleta();

    System.out.println("Para fazer o login digite o CPF: ");
    String cpf = ler.nextLine();

    Atleta busca = null;
    login(busca, atletaLista, cpf);


    ler.close();
  }


  public static AtletaLista criaAtleta() throws FileNotFoundException {
    Scanner lerArquivo = new Scanner(new File("Atleta.txt")); // Para leitura do arquivo txt
    AtletaLista atletaLista = new AtletaLista(); // Cria uma lista

    while(lerArquivo.hasNextLine()) { // enquanto houver linha
      String linhaAtual = lerArquivo.nextLine(); // lê uma linha
      String [] dados = linhaAtual.split(";"); // separa os dados
      Atleta atleta = new Atleta(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5]); // Cria um atleta
      atletaLista.inserir(atleta); // insere um atleta na lista
    }
    lerArquivo.close();
    return atletaLista;
  }


  public static SeriesLista criaSerie() throws FileNotFoundException {
    Scanner lerArquivo = new Scanner(new File("Series.txt")); // Para leitura do arquivo txt
    SeriesLista seriesLista = new SeriesLista(); // Cria uma lista

    //DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //DateTimeFormatter formatarTempo = DateTimeFormatter.ofPattern("HH:mm:ss");

    while(lerArquivo.hasNextLine()) { // enquanto houver linha
      String linhaAtual = lerArquivo.nextLine(); // lê uma linha
      String [] dados = linhaAtual.split(";"); // separa os dados
      Series series = new Series(
        dados[0],
        LocalDate.parse(dados[1]),
        dados[2],
        dados[3]
      ); // Cria uma série
      seriesLista.inserir(series); // insere uma série na lista
    }

    lerArquivo.close();
    return seriesLista;
  }


  // Validar o CPF do atleta
  public static void login(Atleta busca, AtletaLista atletaLista, String cpf) {
    Scanner ler = new Scanner(System.in);
    String buscaCpf = cpf;

    while(busca == null) { // Enquanto busca = null

      busca = atletaLista.localizarAtleta(buscaCpf); // método localizado em AtletaLista

      if(busca != null) {
        System.out.println("\nBem vindo " + busca.nome + "!!");
      } else {
        System.out.println("Atleta não encontrado, por favor digite seu cpf novamente: ");
        buscaCpf = ler.nextLine();
      }

    }

    ler.close();
  }

  public static void menuPrincipal() {

  }
}
