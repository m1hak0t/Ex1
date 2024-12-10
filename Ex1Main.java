import java.util.Arrays;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        String chars = "0123456789ABCDEFG";
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit" ,base="";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                //Check wheter the number is in the correct format
                if (Ex1.isNumber(num1)) {
                    //If yes -print num1 and ask for num2 otherwise - print an error
                    System.out.println("num1= " + num1 + " is number: true, value: " + Ex1.toten(num1));
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.next();
                    //Check one more time that user did not choose to quit
                    if (!num2.equals("quit")) {
                        //check whether the num2 is in valid format
                        if (Ex1.isNumber(num2)) {
                            //Print num2 , else print an error
                            System.out.println("num1= " + num2 + " is number: true, value: " + Ex1.toten(num2));
                            //Ask for the base
                            System.out.println("Enter a base for output: 2 <= base <= 16");
                            base = sc.next();
                            //Check if the base is valid, otherwise error
                            if (Integer.parseInt(base) > 1 && Integer.parseInt(base)<17) {
                                //Implement the funcitonality
                                //Calculating the sum
                                String sum = String.valueOf(Ex1.toten(num1) + Ex1.toten(num2));
                                String sumindesiredbase = Ex1.convert(sum,"10",base);
                                System.out.println(num1 +  " + " + num2 + " = " + sumindesiredbase.toUpperCase());
                                String multiply = String.valueOf(Ex1.toten(num1) * Ex1.toten(num2));
                                String multyplyindesiredbase = Ex1.convert(multiply,"10",base);
                                System.out.println(num1 +  " * " + num2 + " = " + multyplyindesiredbase.toUpperCase());
                                String [] result = {num1,num2,sumindesiredbase.toUpperCase()+"b"+chars.charAt(Integer.parseInt(base)),multyplyindesiredbase.toUpperCase()+"b"+chars.charAt(Integer.parseInt(base))};
                                //System.out.println("Max index" + Ex1.maxIndex(result));
                                System.out.println("Max number over " + Arrays.toString(result) + " ---> " + result[Ex1.maxIndex(result)]);
                            } else {
                                System.out.println("ERR: wrong base, should be [2,16], got " + base);
                            }
                        } else {
                            System.out.println("ERR: num1 is in the wrong format!  -->  " + num2);
                        }
                    } else {
                        break;
                    }
                } else {
                    System.out.println("ERR: num1 is in the wrong format!  -->  " + num1);
                }
            } else {
                break;
            }
        }
        System.out.println("quiting now...");
    }
}
