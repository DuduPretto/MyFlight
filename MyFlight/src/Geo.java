public class Geo {
        private double latitude;
        private double longitude;
     
        public Geo(double latitude, double longitude){
                this.latitude=latitude;
                this.longitude=longitude;
        }
     
        public double getLatitude(){
                return latitude;
        }
    
        public double getLongitude(){
                return longitude;
        }
    
        public static double distancia(Geo a, Geo b){
    
          double dist = 2*6371*Math.asin(Math.sqrt((Math.pow(Math.sin(Math.toRadians(a.getLatitude()) - Math.toRadians(b.getLatitude()))/2 ,2) +(Math.pow(Math.sin(Math.toRadians(a.getLongitude()) - Math.toRadians(b.getLongitude()))/2,2) *
                Math.cos(a.getLatitude()) * Math.cos(b.getLatitude())))));
    
          return dist;
        }
     }
     