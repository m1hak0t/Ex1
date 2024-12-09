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
            System.out.println("100111b2");
            assertTrue(Ex1.isNumber("100111b2")); // Valid binary
            System.out.println("012b5");
            assertFalse(Ex1.isNumber("012b5")); // Valid with leading zero
            System.out.println("12345b6");
            assertTrue(Ex1.isNumber("12345b6")); // Valid base 6
            System.out.println("123bG");
            assertTrue(Ex1.isNumber("123bG")); // Valid base 16 (hex)
            System.out.println("EFbG");
            assertTrue(Ex1.isNumber("EFbG")); // Valid base 16 with letters

            // Invalid cases
            System.out.println("135bA");
            assertTrue(Ex1.isNumber("135bA"));  // Valid base 10
            System.out.println("b2");
            assertFalse(Ex1.isNumber("b2")); // No number before base
            System.out.println("0b1");
            assertFalse(Ex1.isNumber("0b1")); // Invalid base (base 1 not allowed)
            System.out.println("123b");
            assertFalse(Ex1.isNumber("123b")); // Missing base
            System.out.println("1234b11");
            assertFalse(Ex1.isNumber("1234b11")); // Base out of range
            System.out.println("3b3");
            assertFalse(Ex1.isNumber("3b3")); // Base smaller than digit
            System.out.println("-3b5");
            assertFalse(Ex1.isNumber("-3b5")); // Negative not allowed
            System.out.println("3 b4");
            assertFalse(Ex1.isNumber("3 b4")); // Space in number
            System.out.println("GbG");
            assertFalse(Ex1.isNumber("GbG")); // Invalid digit
            System.out.println("");
            assertFalse(Ex1.isNumber("")); // Empty string
            System.out.println("null");
            assertFalse(Ex1.isNumber(null)); // Null input
            }
            //A few invalid values


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
