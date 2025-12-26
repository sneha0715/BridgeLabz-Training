public class FootballTeamHeights {
    
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        return sum;
    }
    
    public static double findMeanHeight(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }
    
    public static int findShortestHeight(int[] heights) {
        int shortest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < shortest) {
                shortest = heights[i];
            }
        }
        return shortest;
    }
    
    public static int findTallestHeight(int[] heights) {
        int tallest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > tallest) {
                tallest = heights[i];
            }
        }
        return tallest;
    }
    
    public static void main(String[] args) {
        int[] heights = new int[11];
        
        for (int i = 0; i < 11; i++) {
            heights[i] = 150 + (int) (Math.random() * 101);
        }
        
        System.out.println("========== Football Team Heights ==========");
        System.out.print("Heights (in cm): ");
        for (int i = 0; i < heights.length; i++) {
            System.out.print(heights[i] + " ");
        }
        System.out.println();
        
        double meanHeight = findMeanHeight(heights);
        int shortestHeight = findShortestHeight(heights);
        int tallestHeight = findTallestHeight(heights);
        
        System.out.println("\n========== Results ==========");
        System.out.println("Mean Height: " + meanHeight + " cm");
        System.out.println("Shortest Height: " + shortestHeight + " cm");
        System.out.println("Tallest Height: " + tallestHeight + " cm");
    }
}
