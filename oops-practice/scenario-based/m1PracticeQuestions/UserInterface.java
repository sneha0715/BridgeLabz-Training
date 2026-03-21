import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class VersionControlStorageSystem {
  Map<String, List<Version>> storage = new HashMap<>();

  public void upload(String fileName, String version, int fileSize) {
    Version v = new Version(version, fileSize);
    if (!storage.containsKey(fileName)) {
      storage.put(fileName, new ArrayList<>());
    }
    storage.get(fileName).add(v);
  }

  public void fetch(String fileName) {
    List<Version> list = storage.get(fileName);
    if (list != null) {
      list.stream().sorted(Comparator.comparingInt(Version::getVersionSize).thenComparing(Version::getVersionName))
          .forEach(x -> System.out.println(fileName + " "+ x.getVersionName()+" "+x.getVersionSize()));
    } else {
      System.out.println("Version not found");
    }

  }

  public void latest(String fileName) {
    List<Version> list = storage.get(fileName);
    if (list != null && !list.isEmpty()) {
      list.stream().skip(list.size() - 1)
          .findFirst()
          .ifPresent(x -> System.out.println(fileName + " " + x.getVersionName()+" "+x.getVersionSize()));
    } else {
      System.out.println("Version not found");
    }
  }

  public void totalStorage(String fileName) {
    List<Version> list = storage.get(fileName);
    if (list != null) {
      int sum=list.stream().mapToInt(Version::getVersionSize).sum();
      System.out.println(fileName+" "+sum);
    } else {
      System.out.println(0);
    }
  }
}

public class UserInterface {
  public static void main(String[] args) {
    VersionControlStorageSystem versionControlStorageSystem = new VersionControlStorageSystem();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < n; i++) {
      String input = sc.nextLine();
      String[] parts = input.split(" ");
      String operation = parts[0];
      String fileName = parts[1];
      if (operation.equals("UPLOAD")) {
        versionControlStorageSystem.upload(fileName, parts[2], Integer.parseInt(parts[3]));
      } else if (operation.equals("FETCH")) {
        versionControlStorageSystem.fetch(fileName);
      } else if (operation.equals("LATEST")) {
        versionControlStorageSystem.latest(fileName);
      } else {
        versionControlStorageSystem.totalStorage(fileName);
      }
    }
  }
}