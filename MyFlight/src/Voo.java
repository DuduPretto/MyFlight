import java.time.LocalDateTime;
import java.time.Duration;


public abstract class Voo {
   public enum Status { CONFIRMADO, ATRASADO, CANCELADO };

   private LocalDateTime datahora;
   private Status status;
   private static int totalVoos = 0;
   
   public Voo(LocalDateTime datahora){
           this.datahora=datahora;
           this.status=Status.CONFIRMADO;
           totalVoos++;
   }

    public Voo(Duration duracao, Rota rota){
           this.datahora=LocalDateTime.of(2016, 8, 12, 12, 00);
           this.status=Status.CONFIRMADO;
   }

   public LocalDateTime getDataHora(){
           return datahora;
   }
   public abstract Duration getDuracao();

   public abstract Rota getRota();

   public Status getStatus(){
           return status;
   }


}

