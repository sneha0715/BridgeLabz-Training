import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
class CreatorStats{
  public String CreatorsName;
  public double[] WeeklyLikes;
  public static List<CreatorStats>EngagementBoard=new ArrayList<>();
}
class Program{
  public void RegisterCreator(CreatorStats record){
    CreatorStats.EngagementBoard.add(record);
  }

  public static Map<String , Integer>GetTopPostCounts(List<CreatorStats>records, double likeThreshold){
    Map<String , Integer> result=new HashMap<>();
    for(CreatorStats creator: records){
      int count = 0;
      if (creator.WeeklyLikes != null) {
        for (double likes : creator.WeeklyLikes) {
          if (likes >= likeThreshold) {
            count++;
          }
        }
      }
      if (count > 0) {
        result.put(creator.CreatorsName, result.getOrDefault(creator.CreatorsName, 0) + count);
      }
    }
    return result;
  }

  public double CalculateAverageLikes(List<CreatorStats>records){
    double totalLikes=0;
    int totalWeeks=0;
    
    for(CreatorStats creator: records){
      if (creator.WeeklyLikes != null) {
        for(double likes:creator.WeeklyLikes){
          totalLikes+=likes;
          totalWeeks++;
        }
      }
    }
    if(totalWeeks==0){
      return 0.0;
    }
    return totalLikes/totalWeeks;
  }
}

public class StreamBuzz {
  public static void main(String[] args) {
    Program program = new Program();
    Scanner sc = new Scanner(System.in);
    int choice = 0;

    do {
      System.out.println("1. Register creator");
      System.out.println("2. View top performing creators");
      System.out.println("3. View average weekly likes");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");

      if (sc.hasNextInt()) {
        choice = sc.nextInt();
      } else {
        sc.next();
        choice = -1;
      }
      sc.nextLine();

      switch (choice) {
        case 1:
          System.out.println("Enter Creator's name");
          String name = sc.nextLine();
          double[] weeklyLikes = new double[4];
          System.out.println("Enter weekly likes for 4 weeks");
          for (int i = 0; i < 4; i++) {
            System.out.println("Week " + (i + 1) + ":");
            while (!sc.hasNextDouble()) {
              sc.next();
            }
            weeklyLikes[i] = sc.nextDouble();
          }
          sc.nextLine();

          CreatorStats creatorStats = new CreatorStats();
          creatorStats.CreatorsName = name;
          creatorStats.WeeklyLikes = weeklyLikes;
          program.RegisterCreator(creatorStats);
          System.out.println("Creator registered successfully");
          break;

        case 2:
          System.out.print("Enter Like Threshold: ");
          double threshold = 0.0;
          if (sc.hasNextDouble()) {
            threshold = sc.nextDouble();
          }
          sc.nextLine();

          Map<String, Integer> topCreators = Program.GetTopPostCounts(CreatorStats.EngagementBoard, threshold);
          if (topCreators.isEmpty()) {
            System.out.println("There's no top performing creator");
          } else {
            for (Map.Entry<String, Integer> entry : topCreators.entrySet()) {
              System.out.println(entry.getKey() + " - " + entry.getValue());
            }
          }
          break;

        case 3:
          double avg = program.CalculateAverageLikes(CreatorStats.EngagementBoard);
          System.out.println("Overall average weekly likes: " + avg);
          break;

        case 4:
          System.out.println("Logging off -- Keep creating the StreamBuzz!");
          break;

        default:
          System.out.println("Invalid choice");
      }
    } while (choice != 4);

    sc.close();
  }
}
