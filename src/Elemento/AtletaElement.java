package Elemento;

import Dados.Atleta;

public class AtletaElement {
  public Atleta atleta; // elemento que guarda uma série
  public AtletaElement proximo; // elemento que aponta para o próximo elemento


  // Construtor para o elemento
  public AtletaElement(Atleta atleta) {
    this.atleta = atleta;
    this.proximo = null;
  }


  // Método para comparar uma pessoa pelo nome
  @Override
  public boolean equals(Object obj){
    String aux = (String)obj; //conversão genérica em String
    return atleta.equals(aux); // //direciona a comparação para a classe Atleta
  }
}