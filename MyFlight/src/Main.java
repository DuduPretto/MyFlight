import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
class Main {
 public static void main(String[] args) {
        

Geo coordSalgadoFilho = new Geo(-29.9935, -51.1754);
Geo coordGuarulhos = new Geo(-23.413, -46.4445);
Geo coordHeathrow = new Geo(51.47060013, -0.461941004);

  Aeronave aviao1 = new Aeronave ("111", "Airbus A330", 200);
  Aeronave aviao2 = new Aeronave ("222", "Boeing 747-8", 150);

  Aeroporto salgadoFilho = new Aeroporto ("POA","Salgado Filho", coordSalgadoFilho);
  Aeroporto guarulhos = new Aeroporto ("GRU", "Guarulhos", coordGuarulhos);
  Aeroporto Heathrow = new Aeroporto ("LHR", "Heathrow", coordHeathrow);

  CiaAerea gol = new CiaAerea ("G3","Gol");
  CiaAerea latam = new CiaAerea ("JJ456", "LATAM");

  Rota rota1 = new Rota (gol, salgadoFilho, guarulhos, aviao1);
  Rota rota2 = new Rota (latam, guarulhos, salgadoFilho, aviao2);
  Rota rota3 = new Rota (latam, guarulhos, Heathrow, aviao2);


  LocalDateTime datahora1 = LocalDateTime.of(2021, 8, 20, 14, 30);
  LocalDateTime datahora2 = LocalDateTime.of(2021, 9, 23, 15, 24);

  Voo voo1 = new VooDireto (rota1, datahora1);
  Voo voo2 = new VooDireto (rota2, datahora2);
  Voo voo3 = new VooDireto (rota3, datahora2);


  GerenciadorAeroportos aeroportos = new GerenciadorAeroportos();
  aeroportos.inserir(salgadoFilho);
  aeroportos.inserir(guarulhos);

  GerenciadorAeronaves aeronaves = new GerenciadorAeronaves();
  aeronaves.inserir(aviao1);
  aeronaves.inserir(aviao1);

  GerenciadorCias cias = new GerenciadorCias();
  cias.inserir(gol);
  cias.inserir(latam);

  GerenciadorRotas rotas = new GerenciadorRotas();
  rotas.inserir(rota1);
  rotas.inserir(rota2);
  
  GerenciadorVoos voos = new GerenciadorVoos();
  voos.inserir(voo1);
  voos.inserir(voo2);

  System.out.println(aeroportos.toString());
  String pesquisa = "POA";
  Aeroporto teste = aeroportos.pesquisar(pesquisa);
  System.out.println(teste);

  System.out.println(aeronaves.toString());
  System.out.println(cias.toString());
  System.out.println(rotas.toString());
  System.out.println(voos.toString());

  System.out.println("\nDistancia entre GRU e POA: "+ Geo.distancia(coordGuarulhos, coordSalgadoFilho));
  

  rotas.ordenaNomeCia();
  aeroportos.ordenaNomeAeroporto();
  System.out.println(rotas.toString());

  System.out.println(aeroportos.toString());

  VooEscalas testeEscalas = new VooEscalas(datahora1);
  testeEscalas.addEscala(rota1);
  testeEscalas.addEscala(rota2);
  testeEscalas.addEscala(rota3);

  System.out.println(testeEscalas.toString());

  System.out.println("\n\n\n"+voo3.toString()); 


/*
  System.out.println("\f");
  System.out.println(aviao1);
  System.out.println(aviao2);
  System.out.println(salgadoFilho);
  System.out.println(guarulhos);
  System.out.println(gol);
  System.out.println(latam);
  System.out.println(rota1);
  System.out.println(rota2);
  System.out.println(voo1);
  System.out.println(voo2);
  System.out.println(voo3);
*/

}
}

