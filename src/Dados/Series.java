package Dados;

import java.time.LocalDate;
//import java.time.LocalTime;

public class Series {

  public String cpf;
  public LocalDate data;
  public String duracao;
  public String nivelTreino;

  public Series(String cpf, LocalDate data, String duracao, String nivelTreino) {
    this.cpf = cpf;
    this.data = data;
    this.duracao = duracao;
    this.nivelTreino = nivelTreino;
  }


  // Método (genérico) para retornar os dados da serie em String
  @Override
  public String toString(){
      String aux = "Cpf: "+ cpf +" - Data: "+ data +" - Duração: "+ duracao + " - Nivel de Treino: " + nivelTreino;
      return aux;
  }
  
  
  // Método (genérico) para localizar um atleta pelo cpf
  @Override
  public boolean equals(Object obj){
      String aux = (String)obj;
      return this.cpf.equals(aux);
  }
}
