import java.util.ArrayList;
public class GerenciadorCias {
   private ArrayList<CiaAerea> cias;

   public GerenciadorCias(){
           cias = new ArrayList<>();
   }
   public void inserir(CiaAerea ciaAerea){
           cias.add(ciaAerea);
   }
   public void inserir(String codigo, String nome){
           cias.add(new CiaAerea(codigo,nome));
   }
   public CiaAerea pesquisarCodigo(String codigo){
           for(CiaAerea ciaAerea : cias){
                        if(ciaAerea.getCodigo()==codigo){
                                return ciaAerea;
                        }
                }
                return null;
   }
    public CiaAerea pesquisarNome(String nome){
           for(CiaAerea ciaAerea : cias){
                        if(ciaAerea.getNome()==nome){
                                return ciaAerea;
                        }
                }
                return null;
   }  
   public String toString() {
    StringBuilder aux = new StringBuilder("\nLista de Companhias Aereas\n- - - - - - - - - - -\n");
    for (CiaAerea ciaAerea : cias) {
      aux.append(ciaAerea.toString() + "\n");

    }
    return aux.toString();
   }
}
