import java.time.LocalDateTime;
import java.time.Duration;


public class VooEscalas extends Voo{
    private Rota rotaFinal;

    public VooEscalas(Rota rota, Rota rotaFinal, LocalDateTime datahora, Duration duracao) {
    super(datahora, duracao, rota); // chama o construtor de Voo
    this.rotaFinal = rotaFinal;
    }
    public Rota getRotaFinal(){return rotaFinal;}

    @Override
    public String toString() {
       return super.toString() + " -> " + rotaFinal;
    }
}