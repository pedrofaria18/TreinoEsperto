import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
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
        String[] tipos = {"duração", "nivel do treino" };
        String dados = "";

        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("d/M/y");
        String dataFormatada = formatar.format(data);

        System.out.println("Menu de cadastro ");
        for (int i = 0; i < 2; i++) {
            if ((i == 1)) {
                System.out.println("Insira o " + tipos[i] + ":");
            } else {
                System.out.println("Insira a " + tipos[i] + ":");
            }
            dados = dados.concat(ler.nextLine());

            if (i != 1) {
                dados = dados.concat(";");
            } else {
                dados = dados.concat("\n");
            }
        }

        try (FileWriter criador = new FileWriter("Series.txt", true);
             BufferedWriter buffer = new BufferedWriter(criador);
             PrintWriter escritor = new PrintWriter(buffer)) {
            escritor.append(cpf).append(";").append(dataFormatada).append(";").append(dados);
            System.out.println("Cadastro de série concluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar a Série");
        }
    }

    public void listarSeries() {
        System.out.println("Listar");
    }
}
