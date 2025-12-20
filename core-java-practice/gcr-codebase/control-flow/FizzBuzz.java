/*
 * FizzBuzz Program using For Loop
 * Take a number as user input and check for a positive integer.
 * If positive integer, loop and print the number, but:
 * - For multiples of 3 print "Fizz" instead of the number
 * - For multiples of 5 print "Buzz"
 * - For multiples of both print "FizzBuzz"
 * - Otherwise print the number itself
 * Use for loop to display the output
 */

import java.util.Scanner;

public class FizzBuzz {
  public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter a number: ");
      int number=sc.nextInt();
      
      // Check for positive integer
      if(number > 0) {
        for(int i=1;i<=number;i++){
        if(i%3==0 && i%5==0){
          System.out.println("FizzBuzz");
        }else if(i%3==0){
          System.out.println("Fizz");
        }else if(i%5==0){
          System.out.println("Buzz");
        }else{
          System.out.println(i);
        }
      }
      } else {
          System.out.println("Please enter a positive integer!");
      }
      sc.close();
  }
}
