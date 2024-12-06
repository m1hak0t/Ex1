import org.junit.jupiter.api.Test;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        public static void main(String[] args) {
            String chars = "1b2";
            String first = chars.substring(0,chars.length()-2);
            System.out.println(chars);
            System.out.println(first);
            String last = chars.substring(chars.length()-1);
            System.out.println(last);
        }
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String chars = "0123456789abcdefg";
            for (int i = 2; i < chars.length(); i++) {
                //Initialize a base
                char base = chars.charAt(i);
                //Generate  100 valid values
                for (int z = 0; z < 101; z++) {
                    String allowed = chars.substring(0, i);
                    String first_part = randomstring(allowed, randomint(10));
                    String finaltrue = first_part + "b" + base;
                    boolean func = Ex1.isNumber(finaltrue);
                    System.out.println("Valid:" + finaltrue);
                    assertTrue(func);
                }
            }
            //Generate 100 invalid values
            for (int i = 0; i < 1000; i++) {
                String candidate = randomstring(chars, 10);
                try {
                    if (!Ex1.isNumber(candidate)) {
                        continue;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }
        }
        @Test
        void int2NumberTest() {
           // implement this test
        }
        @Test
        void maxIndexTest() {
            // implement this test
        }

        public static String randomstring(String string, int length) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(string.length());
                sb.append(string.charAt(index));
            }
            String result = sb.toString();
            return result;
        }

        public static int randomint (int a) {
            Random random = new Random();
            int randomnum = random.nextInt(1,a+1);
            return randomnum;
        }

        // Add additional test functions - test as much as you can.
    }
