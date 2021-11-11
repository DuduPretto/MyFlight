import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo{

    private ArrayList<Rota> escalas;
    
    public VooEscalas(LocalDateTime datahora){
      super(datahora);
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
      StringBuilder aux = new StringBuilder();
      aux.append("Horario: "+super.getDataHora()+"\tDuracao: "+getDuracao()+"\tStatus: "+ super.getStatus()+"\n");
      int i = 0;
      for (Rota e : escalas) {
          aux.append("Rota "+i+": "+e.toString() + "\n");
          i++;
        }
        return aux.toString();
      }

    @Override
    public Duration getDuracao() {
      long tempoTotal = 0;

      for (int i= 0; i < escalas.size(); i++){

        tempoTotal =+ Math.round(((Geo.distancia(escalas.get(i).getOrigem().getLoc(),escalas.get(i).getDestino().getLoc()))/805)+0.5);

      }
      
      return Duration.ofHours(tempoTotal);
    }

    @Override
    public Rota getRota() {
      return escalas.get(0);
    }
  }
    
  