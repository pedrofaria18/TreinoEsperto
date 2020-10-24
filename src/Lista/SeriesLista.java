package Lista;

import Dados.Series;
import Elemento.SeriesElement;

public class SeriesLista {
  public SeriesElement primeiro;
  public SeriesElement ultimo;


  // Cria uma lista vazia com elemento sentinela
  public SeriesLista() {
    primeiro = new SeriesElement(null);
    ultimo = primeiro;
  }


  // Insere um atleta no final da lista
  public void inserir(Series series) {
    SeriesElement novo = new SeriesElement(series);
    ultimo.proximo = novo;
    ultimo = novo;
  }
  
  
  // Verifica se a fila está vazia
  public boolean listaVazia(){
    return (ultimo==primeiro);
  }
}