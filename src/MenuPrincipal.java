
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

public class MenuPrincipal {

    public void menuPrincipal(String cpf) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Escolha o número respectivo à funcionalidade desejada:");
        System.out.println("1 - Cadastrar série");
        System.out.println("2 - Listar série");
        int escolha = ler.nextInt();

        switch (escolha) {
            case 1:
                break;

            case 2:
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
