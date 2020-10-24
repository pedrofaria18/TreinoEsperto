import java.util.Scanner;

public class MenuPrincipal {

    public void menuPrincipal() {
        Scanner ler = new Scanner(System.in);

        System.out.println("Escolha o número respectivo à funcionalidade desejada:");
        System.out.println("1 - Cadastrar série");
        System.out.println("2 - Listar série");
        int numero = ler.nextInt();

        if (numero == 1) {
            System.out.println("Cadastro");
        } else if (numero == 2) {
            System.out.println("Lista");
        } else {
            System.out.println("Funcionalidade escolhida não existe");
        }
    }
}
