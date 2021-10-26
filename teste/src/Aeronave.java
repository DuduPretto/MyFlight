public class Aeronave implements Imprimivel, Contavel, Comparable<Aeronave>{
  private String codigo;
  private String descricao;
  private int capacidade;
  private static int totalAeronaves = 0;


public Aeronave (String codigo, String descricao, int capacidade){
  this.codigo = codigo;
  this.descricao = descricao;
  this.capacidade = capacidade;
  totalAeronaves++;
}

public String getCodigo(){return codigo;}
public String getDescricao(){return descricao;}
public int getCapacidade(){return capacidade;}
public int getTotalAeronaves(){return totalAeronaves;}

public int qtdObjetos(){
  return getTotalAeronaves();
}

public String toString() {

       return String.format("Codigo %s \t Descricao: %s \t Capacidade: %d", codigo, descricao, capacidade);
   }

public void imprimir(){
  System.out.println(toString());
}

@Override
public int compareTo(Aeronave a){
  return descricao.compareTo(a.descricao);}

}