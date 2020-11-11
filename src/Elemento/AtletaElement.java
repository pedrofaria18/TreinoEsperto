package Elemento;

import Dados.Atleta;
import Lista.AtletaLista;

public class AtletaElement {
  public Atleta atleta;
  public AtletaElement proximo;

  public AtletaElement(Atleta atleta) {
    this.atleta = atleta;
    this.proximo = null;
  }

  @Override
  public boolean equals(Object obj) {
    String aux = (String) obj;
    return atleta.equals(aux);
  }
}