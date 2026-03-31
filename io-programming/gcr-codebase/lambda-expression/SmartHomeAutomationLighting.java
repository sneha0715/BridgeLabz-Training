public class SmartHomeAutomationLighting {
  interface LightBehavior {
    void activate();
  }

  public static void main(String[] args) {
    java.util.Map<String, LightBehavior> triggers = new java.util.HashMap<>();
    triggers.put("motion", () -> System.out.println("Motion detected: hallway warm fade"));
    triggers.put("time", () -> System.out.println("Evening time: living room soft glow"));
    triggers.put("voice", () -> System.out.println("Voice command: party mode rainbow sweep"));

    triggers.get("motion").activate();
    triggers.get("time").activate();
    triggers.get("voice").activate();
  }
}
