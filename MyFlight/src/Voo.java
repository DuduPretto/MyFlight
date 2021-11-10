import java.time.LocalDateTime;
import java.time.Duration;


public class Voo {
   public enum Status { CONFIRMADO, ATRASADO, CANCELADO };

   private LocalDateTime datahora;
   private Duration duracao;
   private Rota rota;
   private Status status;
   private static int totalVoos = 0;
   
   public Voo(LocalDateTime datahora, Duration duracao, Rota rota){
           this.datahora=datahora;
           this.duracao=duracao;
           this.rota=rota;
           this.status=Status.CONFIRMADO;
           totalVoos++;
   }

    public Voo(Duration duracao, Rota rota){
           this.datahora=LocalDateTime.of(2016, 8, 12, 12, 00);
           this.duracao=duracao;
           this.rota=rota;
           this.status=Status.CONFIRMADO;
   }

   public LocalDateTime getDataHora(){
           return datahora;
   }
   public Duration getDuracao(){
           return duracao;
   }
   public Rota getRota(){
           return rota;
   }
   public Status getStatus(){
           return status;
   }
   public int getTotalVoos(){
          return totalVoos;
   }


   public String toString(){
           return "Horario: "+datahora+"\tDuracao: "+duracao+"\tRota: "+rota+"\tStatus: "+ status+"\n";
   }
   public void setDatahora(LocalDateTime novaDatahora){
           datahora=novaDatahora;
   }
   public void setDuracao(Duration novaDuracao){
           duracao=novaDuracao;
   }
   public void setRota(Rota novaRota){
           rota=novaRota;
   }
   public void setStatus(Status novoStatus){
           status=novoStatus;
   }


}

