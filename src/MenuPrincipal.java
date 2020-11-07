import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

public class MenuPrincipal {

    public void menuPrincipal(String cpf) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Escolha o número respectivo à funcionalidade desejada:");
        System.out.println("1 - Listar Séries");
        System.out.println("2 - Calculo ");
        int escolha = ler.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Listar");
                break;

            case 2:
                System.out.println("Cálculo");
                break;

            default:
                System.out.println("Funcionalidade escolhida não existe");
                break;
        }
        ler.close();
    }

//        Date data = new Date();
//        SimpleDateFormat formatar = new SimpleDateFormat("d/M/y");
//        String dataFormatada = formatar.format(data);

}
