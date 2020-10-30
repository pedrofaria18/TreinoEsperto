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

        switch (escolha) {
            case 1:
                cadastroSerie();
                break;

            case 2:
                listarSeries();
                break;

            default:
                System.out.println("Funcionalidade escolhida não existe");
                break;
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
