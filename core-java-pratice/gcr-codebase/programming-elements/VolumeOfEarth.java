public class VolumeOfEarth {
  public static void main(String [] args){
    double r=6378;
    double pi = 3.14159;

     double volumeKm = (4.0 / 3) * pi * r * r * r;

     double rMiles = r * 0.621371;
     double volumeMiles = (4.0 / 3) * pi * rMiles * rMiles * rMiles;

     System.out.print("The volume of the Earth in cubic kilometers is"+ volumeKm
      +"and cubic miles is "+ volumeMiles
     );
  }
  
}