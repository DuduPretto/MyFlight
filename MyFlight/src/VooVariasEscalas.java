import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooVariasEscalas extends Voo{

    private ArrayList<Rota> escalas;
    
    public VooVariasEscalas(LocalDateTime datahora, Duration duracao, Rota rota){
      super(datahora, duracao, rota);
      escalas = new ArrayList<Rota>(); 
    }
    
    public void addEscala(Rota rota){
      escalas.add(rota);
    } 
    
    public void addEscala(CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave){
      escalas.add(new Rota(cia, origem, destino, aeronave));
    }
    
    public ArrayList<Rota> getEscalas(){return escalas;}
    
    @Override
    public String toString() {
      StringBuilder aux = new StringBuilder(super.toString());
      int i = 0;
      for (Rota e : escalas) {
          aux.append("Rota "+i+": "+e.toString() + "\n");
          i++;
        }
        return aux.toString();
      }
    
    
    }
    