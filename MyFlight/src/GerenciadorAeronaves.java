import java.util.ArrayList;
// import java.util.Scanner;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.nio.charset.Charset;
// import java.nio.charset.StandardCharsets;

public class GerenciadorAeronaves {
  private ArrayList<Aeronave> aeronaves;

  private static GerenciadorAeronaves gerenAeron = null;

  public GerenciadorAeronaves() {
    aeronaves = new ArrayList<>();
  }

  
  public static GerenciadorAeronaves getInstance() {
    if (gerenAeron == null) {
      gerenAeron = new GerenciadorAeronaves();
    }
    return gerenAeron;
}

public void cleanAll() { aeronaves = new ArrayList<>(); }

public boolean add(Aeronave f) {
    return aeronaves.add(f);
}

public boolean saveFile(String nomeArq) {
    Path path1 = Paths.get(nomeArq);
    try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.forName("utf8")))) {
       // writer.println("nome;");
        for(Aeronave f: aeronaves)
          //  writer.format("%s",
          //          f.getNome());
            writer.format("%s;%s;%d", f.getCodigo(),
                    f.getDescricao(), f.getCapacidade());

    }
    catch (IOException x) {
        System.err.format("Erro de E/S: %s%n", x);
    }
    return true;
}

public boolean readFile(String nomeArq) {
    Path path1 = Paths.get(nomeArq);
    // System.out.println(path1);
    // System.out.println(nomeArq);
    try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
        
        String line = null;
        line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] dados = line.split(";");
            //line <- "713;Donald;11000,0
            // line.split(";" ->"[ "713", "Donald", "11000,0"]
            // String desc = String.parseString(dados[0]);
            String codigo = dados[0];
            String descricao = dados[1];
            int capac = Integer.parseInt(dados[2].replace(",","."));
            Aeronave f = new Aeronave(codigo, descricao, capac);
            gerenAeron.add(f);
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
    for (Aeronave f : aeronaves) {
        rel.append(f.toString());
        rel.append("\n");
    }
    return rel.toString();
}

public void writeBin(String filename) {
    Path caminho = Paths.get(filename);
    try (ObjectOutputStream arq = new ObjectOutputStream(Files.newOutputStream(caminho)))
    {
        arq.writeObject(aeronaves);
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
        aeronaves = (ArrayList<Aeronave>) arq.readObject();
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

  public void inserir(Aeronave aeronave) {
    aeronaves.add(aeronave);

  }

  public void inserir(String codigo, String descricao, int capacidade) {
    aeronaves.add(new Aeronave(codigo, descricao, capacidade));
  }

  public Aeronave pesquisarCodigo(String codigo) {
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