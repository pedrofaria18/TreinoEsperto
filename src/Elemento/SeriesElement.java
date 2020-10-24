package Elemento;

import Dados.Series;

public class SeriesElement {
  public Series series; // elemento que guarda uma série
  public SeriesElement proximo; // elemento que aponta para o próximo elemento
  

  // Construtor para o elemento
  public SeriesElement(Series series) {
    this.series = series;
    this.proximo = null;
  }


  // Método para comparar uma pessoa pelo cpf
  @Override
  public boolean equals(Object obj){
    String aux = (String)obj; //conversão genérica em String
    return series.equals(aux); // //direciona a comparação para a classe Atleta
  }
}