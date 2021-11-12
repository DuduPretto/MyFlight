import java.util.ArrayList;
import java.util.Collections;

// import java.util.Scanner;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.nio.charset.Charset;

public class GerenciadorAeroportos{
        private ArrayList<Aeroporto>aeroportos;

        private static GerenciadorAeroportos gerenAerop = null;

        public GerenciadorAeroportos(){
                aeroportos = new ArrayList<>();
        }
        public void inserir(Aeroporto aeroporto){
                aeroportos.add(aeroporto);
        }
        public void inserir(String codigo, String nome, Geo loc){
                aeroportos.add(new Aeroporto(codigo, nome, loc));
        }
        public Aeroporto pesquisarCodigo(String codigo){
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
    public static GerenciadorAeroportos getInstance() {
        if (gerenAerop == null) {
            gerenAerop = new GerenciadorAeroportos();
        }
        return gerenAerop;
    }
    
    public void cleanAll() { aeroportos = new ArrayList<>(); }
    
    public boolean add(Aeroporto f) {
        return aeroportos.add(f);
    }
    
    public boolean saveFile(String nomeArq) {
        Path path1 = Paths.get(nomeArq);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.forName("utf8")))) {
           // writer.println("nome;");
            for(Aeroporto f: aeroportos)
              //  writer.format("%s",
              //          f.getNome());
                writer.format("%s;%s;%d", f.getCodigo(),
                        f.getNome(), f.getLoc());
    
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
                Double latitude = Double.parseDouble(dados[1]);
                Double longitude = Double.parseDouble(dados[2]);
                String nome = dados[4];
                Aeroporto f = new Aeroporto(codigo, nome, new Geo(latitude, longitude));
                gerenAerop.add(f);
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
        for (Aeroporto f : aeroportos) {
            rel.append(f.toString());
            rel.append("\n");
        }
        return rel.toString();
    }
    
    public void writeBin(String filename) {
        Path caminho = Paths.get(filename);
        try (ObjectOutputStream arq = new ObjectOutputStream(Files.newOutputStream(caminho)))
        {
            arq.writeObject(aeroportos);
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
            aeroportos = (ArrayList<Aeroporto>) arq.readObject();
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

}