package Hash;

import Lista.AtletaLista;
import Dados.Atleta;

public class TabelaHash {
    public static AtletaLista Vetor[];
    private static final int TAMANHO = 10;

    public TabelaHash() {
        Vetor = new AtletaLista[TAMANHO];
        inicializaListas();
    }

    public static void inicializaListas() {
        for (int i = 0; i < TAMANHO; i++) {
            Vetor[i] = new AtletaLista();
        }
    }

    public static int funcaoHash(Atleta atleta) {
        // calcular o valor hash do cpf
        String cpf = atleta.cpf;
        cpf = cpf.substring(0, 7);
        int cpfConvertido = Integer.parseInt(cpf);
        int posicao = cpfConvertido / 1000;
        return posicao %= TAMANHO;
    }

    public void addTabela(Atleta atleta) {
        Vetor[funcaoHash(atleta)].inserir(atleta);
        System.out.println("Inseriu atleta " + atleta.cpf);
    }
}