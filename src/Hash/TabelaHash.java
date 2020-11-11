package Hash;

import Lista.AtletaLista;
import Dados.Atleta;

public class TabelaHash {
    public static AtletaLista tabela[];
    private static final int TAMANHO = 10;

    public TabelaHash() {
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
        int posicao = cpfConvertido % TAMANHO;
        return posicao;
    }

    public void addTabela(Atleta atleta) {
        tabela[funcaoHash(atleta.cpf)].inserir(atleta);
    }

    public static AtletaLista buscaHash(String cpf) {
        return tabela[funcaoHash(cpf)];
    }

    public static void alturaAtletas() {

        for (int i = 0; i < TAMANHO; i++) {
            while (tabela[i].primeiro.proximo != null) {
                String altura = tabela[i].primeiro.proximo.atleta.altura;
                System.out.println(altura);
            }
        }
    }
}