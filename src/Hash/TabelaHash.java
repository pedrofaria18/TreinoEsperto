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

    public static int funcaoHash(String cpf) {
        // calcular o valor hash do cpf
        cpf = cpf.substring(0, 7);
        int cpfConvertido = Integer.parseInt(cpf);
        int posicao = cpfConvertido % TAMANHO;
        return posicao;
    }

    public void addTabela(Atleta atleta) {
        Vetor[funcaoHash(atleta.cpf)].inserir(atleta);
    }

    public static AtletaLista buscaHash(String cpf) {
        return Vetor[funcaoHash(cpf)];
    }
}