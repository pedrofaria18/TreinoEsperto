package Hash;

import Lista.AtletaLista;
import Dados.Atleta;
import Elemento.AtletaElement;

public class HashAtleta {
    public static AtletaLista tabela[];
    private static final int TAMANHO = 5000;

    public HashAtleta() {
        tabela = new AtletaLista[TAMANHO];
        inicializaListas();
    }

    public static void inicializaListas() {
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new AtletaLista();
        }
    }

    public static int funcaoHash(String cpf) {
        // calcular o valor hash do cpf
        cpf = cpf.substring(0, 7);
        int cpfConvertido = Integer.parseInt(cpf);
        int posicao = cpfConvertido % 4999;
        return posicao;
    }

    public void addTabela(Atleta atleta) {
        tabela[funcaoHash(atleta.cpf)].inserir(atleta);
    }

    public static AtletaLista buscaHash(String cpf) {
        return tabela[funcaoHash(cpf)];
    }

    public static void alturaAtletas(int max, int min) {
        AtletaElement aux = null;
        String altura = "";
        String cpf = "";

        int alturaInt = 0;

        for (int i = 0; i < TAMANHO; i++) {
            aux = tabela[i].primeiro.proximo;
            // System.out.println(i);
            while (aux != null) {
                altura = aux.atleta.altura;
                altura = altura.replace(",", "");
                altura = altura.replace(".", "");
                alturaInt = Integer.parseInt(altura);
                // System.out.println(altura + " " + i);
                if ((alturaInt <= max) && (alturaInt >= min)) {
                    cpf = cpf.concat(aux.atleta.nome + " " + aux.atleta.altura);
                    cpf = cpf.concat("\n");
                }
                aux = aux.proximo;
            }
        }
        System.out.println(cpf);
    }
}