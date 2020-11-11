package Cria;

import Dados.Atleta;
import Lista.AtletaLista;
import Hash.TabelaHash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CriaAtleta {
    public static AtletaLista criaAtleta() throws FileNotFoundException {
        Scanner lerArquivo = new Scanner(new File("Atleta.txt"));
        AtletaLista atletaLista = new AtletaLista();
        TabelaHash atletaHash = new TabelaHash();

        while (lerArquivo.hasNextLine()) {
            String linhaAtual = lerArquivo.nextLine();
            String[] dados = linhaAtual.split(";");
            Atleta atleta = new Atleta(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5]);
            atletaLista.inserir(atleta);
            atletaHash.addTabela(atleta);
        }
        lerArquivo.close();
        return atletaLista;
    }
}
