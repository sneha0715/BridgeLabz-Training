public class Version {
  private String versionName;
  private int versionSize;

  Version(String versionName , int versionSize){
    this.versionName=versionName;
    this.versionSize=versionSize;
  }

  public String getVersionName(){
    return versionName;
  }

  public int getVersionSize(){
    return versionSize;
  }

  public String toString(){
    return versionName+versionSize;
  }

}
