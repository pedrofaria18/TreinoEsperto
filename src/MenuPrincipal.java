import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
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
                cadastroSerie(cpf);
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

    public void cadastroSerie(String cpf) {
        Scanner ler = new Scanner(System.in);
        Object[] tipos = { "cpf", "data atual", "duração", "nivel do treino" };
        String dados = "";

        System.out.println("Menu de cadastro ");
        for (int i = 0; i < 4; i++) {
            if ((i == 0) || (i == 3)) {
                System.out.println("Insira o " + tipos[i] + ":");
            } else {
                System.out.println("Insira a " + tipos[i] + ":");
            }
            dados = dados.concat(ler.nextLine());

            if (i != 3) {
                dados = dados.concat(";");
            } else {
                dados = dados.concat("\n");
            }
        }

        try (FileWriter criador = new FileWriter("Series.txt", true);
             BufferedWriter buffer = new BufferedWriter(criador);
             PrintWriter escritor = new PrintWriter(buffer)) {
            escritor.append(dados);
            System.out.println("Cadastro de série concluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar a Série");
        }
    }

    public void listarSeries() {
        System.out.println("Listar");
    }
}
