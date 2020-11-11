package Arvore;

import Dados.Series;

public class ABB {
    public Series raiz;  //árvore de alunos
    public ABB subArvoreEsq, subArvoreDir;  //estrutura recursiva: uma subárvore é uma árvore; uma ABB tem duas subárvores

    public ABB(){
        this.raiz = null;
        this.subArvoreDir = this.subArvoreEsq = null;
    }

    public int grau(){
        if(subArvoreDir!=null){
            if(subArvoreEsq!=null)
                return 2;
            else
                return 1;
        }
        else{
            if(subArvoreEsq!=null)
                return -1;
            else
                return 0;
        }
    }

    public Series antecessor() {
        ABB aux = this.subArvoreEsq;
        while (aux.subArvoreDir != null)
            aux = aux.subArvoreDir;

        return aux.raiz;
    }

    public Series buscar(String cpf){
        if(raiz.compareTo(cpf)==0) return raiz;     //comparação 0: encontrei e, portanto, retorno
        else{
            if(raiz.compareTo(cpf)>0){   //a RAIZ é MAIOR: procurar à esquerda
                if(subArvoreEsq==null) return null;      //se não há subárvore esquerda, não existe o aluno
                else return subArvoreEsq.buscar(cpf);    //busca recursiva nos menores
            }
            else{                                       //a RAIZ é MENOR: procurar à direita
                if(subArvoreDir==null) return null;     //se não há subárvore esquerda, não existe o aluno
                else return subArvoreDir.buscar(cpf);   //busca recursiva nos maiores
            }
        }
    }

    public void inserir(Series novo){
        if(raiz==null) raiz = novo;
        else{
            if(novo.compareTo(raiz.toString())<0){
                if(subArvoreEsq==null)
                    subArvoreEsq = new ABB();
                subArvoreEsq.inserir(novo);
            }
            else{
                if(subArvoreDir==null)
                    subArvoreDir = new ABB();
                subArvoreDir.inserir(novo);
            }
        }
    }

    public String emOrdem(){
        StringBuilder aux = new StringBuilder();
        if(subArvoreEsq!=null) aux.append(subArvoreEsq.emOrdem());
        aux.append(raiz.toString());
        if(subArvoreDir!=null) aux.append(subArvoreDir.emOrdem());

        return aux.toString();
    }

    @Override
    public String toString(){
        return this.emOrdem();
    }
}
