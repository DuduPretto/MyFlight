import java.util.ArrayList;
// import java.util.Collections;

// import java.util.Scanner;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.nio.charset.Charset;

public class GerenciadorCias {
   private ArrayList<CiaAerea> cias;

   private static GerenciadorCias gerenCia = null;

   public GerenciadorCias(){
           cias = new ArrayList<>();
   }

   public static GerenciadorCias getInstance() {
        if (gerenCia == null) {
            gerenCia = new GerenciadorCias();
        }
        return gerenCia;
    }
    
    public void cleanAll() { cias = new ArrayList<>(); }
    
    public boolean add(CiaAerea f) {
        return cias.add(f);
    }
    
    public boolean saveFile(String nomeArq) {
        Path path1 = Paths.get(nomeArq);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.forName("utf8")))) {
           // writer.println("nome;");
            for(CiaAerea f: cias)
              //  writer.format("%s",
              //          f.getNome());
                writer.format("%s;%s", f.getCodigo(),
                        f.getNome());
    
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
                String nome = dados[1];
                CiaAerea f = new CiaAerea(codigo, nome);
                gerenCia.add(f);
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
        for (CiaAerea f : cias) {
            rel.append(f.toString());
            rel.append("\n");
        }
        return rel.toString();
    }
    
    public void writeBin(String filename) {
        Path caminho = Paths.get(filename);
        try (ObjectOutputStream arq = new ObjectOutputStream(Files.newOutputStream(caminho)))
        {
            arq.writeObject(cias);
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
                cias = (ArrayList<CiaAerea>) arq.readObject();
        }
        catch(ClassNotFoundException e) {
            System.out.println("Erro (SerialBin): ArrayList<CiaAerea> não encontrada!");
            System.exit(1);
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
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
