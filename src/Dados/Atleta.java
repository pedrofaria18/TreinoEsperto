package Dados;

public class Atleta {
  public String nome;
  public String cpf;
  public String dataNascimento;
  public String genero;
  public String peso;
  public String altura;

  public Atleta(String nome, String cpf, String dataNascimento, String genero, String peso, String altura) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.genero = genero;
    this.peso = peso;
    this.altura = altura;
  }

  @Override
  public String toString(){
    return cpf + " - " + nome + " - " + dataNascimento + " - " + genero + " - " + peso + " - " + altura;
  }

  @Override
  public boolean equals(Object obj){
    String aux = (String)obj;
    return this.cpf.equals(aux);
  }
}
