package Lista;

//import Dados.Atleta;
import Dados.Series;
//import Elemento.AtletaElement;
import Elemento.SeriesElement;

public class SeriesLista {
  public SeriesElement primeiro;
  public SeriesElement ultimo;

  public SeriesLista() {
    primeiro = new SeriesElement(null);
    ultimo = primeiro;
  }

  public void inserir(Series series) {
    SeriesElement novo = new SeriesElement(series);
    ultimo.proximo = novo;
    ultimo = novo;
  }

}