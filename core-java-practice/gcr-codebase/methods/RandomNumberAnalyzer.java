public class RandomNumberAnalyzer {
    
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = 1000 + (int) (Math.random() * 9000);
        }
        return numbers;
    }
    
    public static double[] findAverageMinMax(int[] numbers) {
        double[] result = new double[3];
        
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }
        
        result[0] = (double) sum / numbers.length;
        result[1] = min;
        result[2] = max;
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);
        
        System.out.println("========== Generated 4-Digit Random Numbers ==========");
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i] + " ");
        }
        System.out.println();
        
        double[] results = findAverageMinMax(randomNumbers);
        
        System.out.println("\n========== Analysis ==========");
        System.out.println("Average: " + results[0]);
        System.out.println("Minimum: " + (int) results[1]);
        System.out.println("Maximum: " + (int) results[2]);
    }
}
