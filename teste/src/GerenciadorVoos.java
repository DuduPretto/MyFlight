import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Duration;

public class GerenciadorVoos{

  private ArrayList<Voo> listaVoos;

  public GerenciadorVoos() {
    listaVoos = new ArrayList<>();
  }

  public void inserir(Voo voo) {
    listaVoos.add(voo);

  }

 

  public Voo pesquisar(LocalDateTime dataHora) {
    for (Voo voo : listaVoos) {
      if (voo.getDataHora() == dataHora) {
        return voo;
      }
  

    }
    return null;
  }

  public String toString() {
    StringBuilder aux = new StringBuilder("\nLista de voos\n- - - - - - - - - - -\n");
    for(Voo voo : listaVoos) {
      aux.append(voo.toString() + "\n");

    }
    return aux.toString();

  }
}
