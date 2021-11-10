public class Aeroporto implements Comparable<Aeroporto>{
        private String codigo;
        private String nome;
        private Geo loc;
        private static int totalAeroportos = 0;
     
        public Aeroporto(String codigo, String nome, Geo loc){
                this.codigo=codigo;
                this.nome=nome;
                this.loc=loc;
                totalAeroportos++;
        }
        public String getCodigo(){
                return codigo;
        }
        public String getNome(){
                return nome;
        }
        public Geo getLoc(){
                return loc;
        }
        public int getTotalAeroportos(){
              return totalAeroportos;
       }
        public String toString(){
                return String.format("Codigo: (%s) \t Nome: %s \t Latitude %f \t Longitude %f",codigo, nome, loc.getLatitude(), loc.getLongitude());
        }
    
        @Override
        public int compareTo(Aeroporto a){
        return nome.compareTo(a.nome);}
        }
     
     
     