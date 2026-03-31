class LegacyAPI{
  @Deprecated
  void oldFeature(){
    System.out.println("Old Feature is running...");
  }
  void newFeature(){
    System.out.println("New feature is running...");
  }
}
public class LegacyAPIfeature {
  public static void main(String[] args) {
    LegacyAPI legacyAPI=new LegacyAPI();
    legacyAPI.oldFeature();
    legacyAPI.newFeature();
  }
}
