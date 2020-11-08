package Dados;

public class Series {

  public String cpf;
  public String data;
  public String duracao;

  public Series(String cpf, String data, String duracao) {
    this.cpf = cpf;
    this.data = data;
    this.duracao = duracao;
  }

  @Override
  public String toString(){
      return cpf + " - " + data + " - " + duracao;
  }

  @Override
  public boolean equals(Object obj){
      String aux = (String)obj;
      return this.cpf.equals(aux);
  }
}
