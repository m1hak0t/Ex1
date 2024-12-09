/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {

        public static void main(String[] args) {
            System.out.println(isNumber(""));
        }
        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String num) {
            int ans = -1;
            return ans;
        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        //The function that checks is the number is a legitimate number
        public static boolean isNumber(String a) {
            //Variables init
            boolean ans = true;
            String chars = "0123456789abcdefg";
            String nums = "0123456789";
            //Handling unusual scenarious
            //False if a == null
            if (a==null) {
                ans = false;
                return ans;
            }
            //False if a == ""
            if (a.equals("")) {
                ans = false;
                return ans;
            }
            //If the number without a base and in valid format - true
            if (!a.contains("b") && !a.substring(0,1).equals("0") && !a.equals(" ")) {
                for (int i = 0; i < a.length(); i += 1) {
                    if (!nums.contains(Character.toString(a.charAt(i)))){
                        ans = false;
                        return ans;
                    }
                }
            }
            //If the number is represented with the base - check if this is legal format
            if (a!= null && a.length() >= 3 && a.substring((a.length() - 2), (a.length() - 1)).equals("b") && !a.substring(0,1).equals("0")){
                a = a.toLowerCase();
                //System.out.println("Current input: " + a);
                //String[] parts = a.split("b");
                //String first = parts[0];
                //String second = parts[1];
                //*Get the number part of the number
                String number = a.substring(0, a.length() - 2);
                //System.out.println("Current number " + number);
                //*Get the base part of the number
                String base = a.substring(a.length() - 1);
                //* Initiate the allowed range for the base
                String baserange = chars.substring(2, chars.length());
                //System.out.println("Current base  " + base);
                //System.out.println("Allowed base range " + baserange);
                //If the base is a legal base
                if (baserange.contains(base)) {
                    //*Initialize allowed number range according to the base
                    String numrange = chars.substring(0, chars.indexOf(base));
                    //System.out.println("Current numbrange: " + numrange);
                    for (int i = 0; i < number.length() ; i++) {
                        //*To check if all the numbers on the left are in the specific range of numrange and if yes  -> true
                        if (!numrange.contains(Character.toString(number.charAt(i)))) {
                            ans = false;
                            break;
                        }
                    }
                } else {
                    ans = false;
                }
            } else {

                ans = false;
            }

            return ans;
        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            String ans = "";
            // add your code here

            ////////////////////
            return ans;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true;
            // add your code here

            ////////////////////
            return ans;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int ans = 0;
            // add your code here

            ////////////////////
            return ans;
        }
}


