import java.time.LocalDateTime;
import java.time.Duration;


public class VooDireto extends Voo{
    private Rota rota;

    public VooDireto(Rota rota, LocalDateTime datahora) {
    super(datahora); // chama o construtor de Voo
    this.rota = rota;
    }
    public Rota getRota(){return rota;}

    public Duration getDuracao(){

        Geo locOrigem = rota.getOrigem().getLoc();
        Geo locDestino = rota.getDestino().getLoc();
        long tempo = Math.round(((Geo.distancia(locOrigem, locDestino))/805)+0.5);

        return Duration.ofHours(tempo);
    }

    @Override
    public String toString() {
        return "Horario: "+super.getDataHora()+"\tDuracao: "+
        getDuracao()+"\tRota: "+rota+"\tStatus: "+ super.getStatus()+"\n";
    }
}