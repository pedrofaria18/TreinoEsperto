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
  
  // Método (genérico) para retornar os dados do atleta em String
  @Override
  public String toString(){
    String aux = "Cpf: "+ cpf +" - Nome: "+ nome +" - Data Nascimento: "+ dataNascimento +" - Gênero: "+ genero +" - Peso: "+ peso +" - Altura: "+ altura;
    return aux;
  }


  // Método (genérico) para localizar um atleta pelo cpf
  @Override
  public boolean equals(Object obj){
    String aux = (String)obj;
    return this.cpf.equals(aux);
  }
}
