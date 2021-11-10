import java.util.ArrayList;
import java.util.Collections;
public class GerenciadorRotas{
        private ArrayList<Rota>rotas;

        public GerenciadorRotas(){
                rotas = new ArrayList<>();
        }
        public void inserir(Rota rota){
           rotas.add(rota);
   }
//   public void inserir(CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave){
//           rotas.add(new Rota(CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave));}
   public Rota pesquisarOrigem(Aeroporto origem){
           for(Rota rota : rotas){
                        if(rota.getOrigem()==origem){
                                return rota;
                        }
                }
                return null;
   }
    public Rota pesquisarDestino(Aeroporto destino){
           for(Rota rota : rotas){
                        if(rota.getDestino()==destino){
                                return rota;
                        }
                }
                return null;
   }  
   public String toString() {
    StringBuilder aux = new StringBuilder("\nLista de Rotas\n- - - - - - - - - - -\n");
    for (Rota rota : rotas) {
      aux.append(rota.toString() + "\n");

    }
    return aux.toString();
   }

   public void ordenaNomeCia(){
        Collections.sort(rotas);
                  
    }
}
