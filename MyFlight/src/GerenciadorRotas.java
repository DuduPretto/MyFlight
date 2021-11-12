import java.util.ArrayList;
import java.util.Collections;

// import java.util.Scanner;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.nio.charset.Charset;

public class GerenciadorRotas{
        private ArrayList<Rota>rotas;

        private static GerenciadorRotas gerenRota = null;

        public GerenciadorRotas(){
                rotas = new ArrayList<>();
        }


        public static GerenciadorRotas getInstance() {
                if (gerenRota == null) {
                    gerenRota = new GerenciadorRotas();
                }
                return gerenRota;
            }
            
            public void cleanAll() { rotas = new ArrayList<>(); }
            
            public boolean add(Rota f) {
                return rotas.add(f);
            }
            
            public boolean saveFile(String nomeArq) {
                Path path1 = Paths.get(nomeArq);
                try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.forName("utf8")))) {
                   // writer.println("nome;");
                    for(Rota f: rotas)
                      //  writer.format("%s",
                      //          f.getNome());
                        writer.format("%s;%s;%s;%s", f.getCia(),
                                f.getOrigem(), f.getDestino(), f.getAeronave());
            
                }
                catch (IOException x) {
                    System.err.format("Erro de E/S: %s%n", x);
                }
                return true;
            }
            
            public boolean readFile(String nomeArq, GerenciadorCias gerenCia, GerenciadorAeroportos gerenAerop, GerenciadorAeronaves gerenAeron) {
                Path path1 = Paths.get(nomeArq);
                // System.out.println(path1);
                // System.out.println(nomeArq);
                try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
                    
                    String line = null;
                    line = reader.readLine();
                    while ((line = reader.readLine()) != null) {
                        String[] dados = line.split(";");

                        CiaAerea cia = gerenCia.pesquisarCodigo(dados[0]);
                        Aeroporto aeroportoOrigem = gerenAerop.pesquisarCodigo(dados[1]);
                        Aeroporto aeroportoDestino = gerenAerop.pesquisarCodigo(dados[1]);
                        Aeronave aeronave = gerenAeron.pesquisarCodigo(dados[4]);
                        //line <- "713;Donald;11000,0
                        // line.split(";" ->"[ "713", "Donald", "11000,0"]
                        // String desc = String.parseString(dados[0]);
                        
                        Rota f = new Rota(cia, aeroportoOrigem, aeroportoDestino, aeronave);
                        gerenRota.add(f);
                    }
                }
                catch (IOException x){
                System.err.format("Erro de E/S: %s%n", x);
                } 
                return true;
                
                    // String fName = "caso1.txt";
                    // String currDir = Paths.get("").toAbsolutePath().toString();
                    // String nameComplete = currDir + " / " + fName;
                    // Path path = Paths.get(nameComplete);
                    // try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
                    //     while (sc.hasNext()){
                    //         String line = sc.nextLine();
            
                    //     }
                    // }catch (IOException x){
                    //     System.err.format("Erro de E/S: %s%n", x);
                    // } 
                    // line = "123;banana;ehnois"
                    // String[] teste = line.split(";");
                    // teste[0] = 123;
                    // teste[1] = banana;
            
                    }
            
            
            
            public String relatorio() {
                StringBuilder rel = new StringBuilder("");
                for (Rota f : rotas) {
                    rel.append(f.toString());
                    rel.append("\n");
                }
                return rel.toString();
            }
            
            public void writeBin(String filename) {
                Path caminho = Paths.get(filename);
                try (ObjectOutputStream arq = new ObjectOutputStream(Files.newOutputStream(caminho)))
                {
                    arq.writeObject(rotas);
                }
                catch(IOException e)
                {
                    System.out.println("erro (writeBin): "+ e.getMessage());
                    System.exit(1);
                }
            }
            
            public void readBin(String filename) {
                Path caminho = Paths.get(filename);
                try (ObjectInputStream arq = new ObjectInputStream(Files.newInputStream(caminho))) {
                    rotas = (ArrayList<Rota>) arq.readObject();
                }
                catch(ClassNotFoundException e) {
                    System.out.println("Erro (SerialBin): ArrayList<Aeronave> não encontrada!");
                    System.exit(1);
                }
                catch(IOException e) {
                    System.out.println(e.getMessage());
                    System.exit(1);
                }
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
