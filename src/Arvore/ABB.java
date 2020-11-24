package Arvore;

import Dados.Series;

public class ABB {
    public Series raiz;
    public ABB subArvoreEsq, subArvoreDir;

    public ABB(){
        this.raiz = null;
        this.subArvoreDir = this.subArvoreEsq = null;
    }

    public Series buscar(String cpf){
        if(raiz.compareTo(cpf)==0) return raiz;
        else{
            if(raiz.compareTo(cpf)>0){
                if(subArvoreEsq==null) return null;
                else return subArvoreEsq.buscar(cpf);
            }
            else{
                if(subArvoreDir==null) return null;
                else return subArvoreDir.buscar(cpf);
            }
        }
    }

    public void inserir(Series novo){
        if(raiz==null) {
            raiz = novo;
        } else {
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
