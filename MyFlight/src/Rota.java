public class Rota implements Comparable<Rota>{
  private CiaAerea cia;
  private Aeroporto origem;
  private Aeroporto destino;
  private Aeronave aeronave;
  private static int totalRotas = 0;
 
  

public Rota (CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave){
  this.cia = cia;
  this.origem = origem;
  this.destino = destino;
  this.aeronave = aeronave;
  totalRotas++;
}

public CiaAerea getCia(){return cia;}
public Aeroporto getOrigem(){return origem;}
public Aeroporto getDestino(){return destino;}
public Aeronave getAeronave(){return aeronave;}
public int getTotalRotas(){return totalRotas;}

public void setCia(CiaAerea novaCia){cia = novaCia;}
public void setCia(Aeroporto novaOrigem){origem = novaOrigem;}
public void setDestino(Aeroporto novoDestino){destino = novoDestino;}
public void setAeronave(Aeronave novaAeronave){aeronave = novaAeronave;}


public String toString() {

       return String.format("%s \t Origem: [%s] \t Destino: [%s] \t %s\n", cia.toString(), origem, destino, aeronave.toString());
   }

  

@Override
public int compareTo(Rota a) {
  return (cia.getNome()).compareTo(a.cia.getNome());
}

   


}



