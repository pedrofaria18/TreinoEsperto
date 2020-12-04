package Arvore;

//import Arvore.Heap;
//import Cria.CriaSerie;
import Dados.Series;

public class ABB {
    public Series raiz;
    public ABB subArvoreEsq, subArvoreDir;

    public ABB() {
        this.raiz = null;
        this.subArvoreDir = this.subArvoreEsq = null;
    }

    public Series buscar(String cpf) {
        if (raiz.compareTo(cpf) == 0)
            return raiz;
        else {
            if (raiz.compareTo(cpf) > 0) {
                if (subArvoreEsq == null)
                    return null;
                else
                    return subArvoreEsq.buscar(cpf);
            } else {
                if (subArvoreDir == null)
                    return null;
                else
                    return subArvoreDir.buscar(cpf);
            }
        }
    }

    public void inserir(Series novo) {
        if (raiz == null) {
            raiz = novo;
        } else {
            if (novo.compareTo(raiz.toString()) < 0) {
                if (subArvoreEsq == null)
                    subArvoreEsq = new ABB();
                subArvoreEsq.inserir(novo);
            } else {
                if (subArvoreDir == null)
                    subArvoreDir = new ABB();
                subArvoreDir.inserir(novo);
            }
        }
    }

    public String emOrdem(String cpf, HeapSeries seriesHeap) {
        StringBuilder aux = new StringBuilder();

        if (subArvoreEsq != null) {
            // System.out.println("entrou esq -> cpf: " + subArvoreEsq.raiz.cpf);
            if (subArvoreEsq.raiz.cpf.equals(cpf)) {
                // System.out.println(subArvoreEsq.raiz.data + " " + subArvoreEsq.raiz.duracao);
                seriesHeap.insere(subArvoreEsq.raiz);
                aux.append(subArvoreEsq.emOrdem(cpf, seriesHeap));
                aux.append("\n");
            } else
                subArvoreEsq.emOrdem(cpf, seriesHeap);
        }

        if (subArvoreDir != null) {
            // System.out.println("entrou dir -> cpf: " + subArvoreDir.raiz.cpf);
            if (subArvoreDir.raiz.cpf.equals(cpf)) {
                // System.out.println(subArvoreDir.raiz.data + " " + subArvoreDir.raiz.duracao);
                seriesHeap.insere(subArvoreDir.raiz);
                aux.append(subArvoreDir.emOrdem(cpf, seriesHeap));
                aux.append("\n");
            } else
                subArvoreDir.emOrdem(cpf, seriesHeap);
        }

        return aux.toString();
    }

    // public String toString(String cpf) {
    // return this.emOrdem(cpf);
    // }
}
