import java.util.ArrayList;

public class GerenciadorAeronaves {
  private ArrayList<Aeronave> aeronaves;

  public GerenciadorAeronaves() {
    aeronaves = new ArrayList<>();
  }

  public void inserir(Aeronave aeronave) {
    aeronaves.add(aeronave);

  }

  public void inserir(String codigo, String descricao, int capacidade) {
    aeronaves.add(new Aeronave(codigo, descricao, capacidade));
  }

  public Aeronave pesquisar(String codigo) {
    for (Aeronave aeronave : aeronaves) {
      if (aeronave.getCodigo() == codigo) {
        return aeronave;
      }

    }
    return null;

  }

  public String toString() {
    StringBuilder aux = new StringBuilder("\nLista de aeronaves\n- - - - - - - - - - -\n");
    for (Aeronave aeronave : aeronaves) {
      aux.append(aeronave.toString() + "\n");

    }
    return aux.toString();

  }
}