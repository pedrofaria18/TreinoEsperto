import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MenuPrincipal {

    public void menuPrincipal() {
        Scanner ler = new Scanner(System.in);

        System.out.println("Escolha o número respectivo à funcionalidade desejada:");
        System.out.println("1 - Cadastrar série");
        System.out.println("2 - Listar série");
        int escolha = ler.nextInt();

        if (escolha == 1) {
            cadastroSerie();
        } else if (escolha == 2) {
            listarSeries();
        } else {
            System.out.println("Funcionalidade escolhida não existe");
        }
        ler.close();
    }

    public void cadastroSerie() {
        System.out.println("Cadastro");
    }

    public void listarSeries() {
        System.out.println("Listar");
    }
}
