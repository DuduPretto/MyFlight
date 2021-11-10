import java.util.ArrayList;
import java.util.Collections;
public class GerenciadorAeroportos{
        private ArrayList<Aeroporto>aeroportos;

        public GerenciadorAeroportos(){
                aeroportos = new ArrayList<>();
        }
        public void inserir(Aeroporto aeroporto){
                aeroportos.add(aeroporto);
        }
        public void inserir(String codigo, String nome, Geo loc){
                aeroportos.add(new Aeroporto(codigo, nome, loc));
        }
        public Aeroporto pesquisar(String codigo){
                for(Aeroporto aeroporto : aeroportos){
                        if(aeroporto.getCodigo()==codigo){
                                return aeroporto;
                        }
                }
                return null;
        }
        public String toString(){
        StringBuilder aux = new StringBuilder("\nLista de Aeroportos\n- - - - - - - - - - -\n");
        for (Aeroporto aeroporto : aeroportos) {
            aux.append( aeroporto.toString() + "\n");

        }
        return aux.toString();
    }

    public void ordenaNomeAeroporto(){
        Collections.sort(aeroportos);
                  
    }


}