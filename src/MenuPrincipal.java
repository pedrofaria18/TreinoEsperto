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
        String[] tipos = { "duração do treino", "nivel do treino" };
        String[] nivel = { "Iniciante", "Intermediário", "Avançado" };
        String[] duracao = { "00:30", "00:45", "01:00" };
        String dados = "";
        String dadoNovo = "";
        int escolha = 0;

        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("d/M/y");
        String dataFormatada = formatar.format(data);

        System.out.println("Menu de cadastro ");
        for (int i = 0; i < 2; i++) {
            if ((i == 1)) {
                System.out.println("Insira o " + tipos[i] + ":");
                System.out.println("1. Iniciante");
                System.out.println("2. Intermediário");
                System.out.println("3. Avançado");
                escolha = ler.nextInt();

                switch (escolha) {
                    case 1:
                        dadoNovo = nivel[0];
                        break;

                    case 2:
                        dadoNovo = nivel[1];
                        break;

                    case 3:
                        dadoNovo = nivel[2];
                        break;
                }
            } else {
                System.out.println("Insira a " + tipos[i] + ":");
                System.out.println("1. Baixa (00:30)");
                System.out.println("2. Média (00:45)");
                System.out.println("3. Alta (01:00)");
                escolha = ler.nextInt();

                switch (escolha) {
                    case 1:
                        dadoNovo = duracao[0];
                        break;

                    case 2:
                        dadoNovo = duracao[1];
                        break;

                    case 3:
                        dadoNovo = duracao[2];
                        break;
                }
            }
            dados = dados.concat(dadoNovo);

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
        ler.close();
    }

    public void listarSeries() {
        System.out.println("Listar");
    }
}
