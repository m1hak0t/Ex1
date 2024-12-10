import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        public static void Ex1(String[] args) {
            String chars = "1b2";
            String first = chars.substring(0,chars.length()-2);
            System.out.println(chars);
            System.out.println(first);
            String last = chars.substring(chars.length()-1);
            System.out.println(last);
        }
        /*
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEx1(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEx1(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }
         */

        @Test
        void isBasisNumberTest() {
            System.out.println("100111b2");
            assertTrue(Ex1.isNumber("100111b2")); // Valid binary
            System.out.println("012b5");
            assertTrue(Ex1.isNumber("012b5")); // Valid with leading zero
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
        void maxIndexTest() {

        }

        //Tests for Convert funtion
        @Test
        void testBinaryToDecimal() {
            // Convert binary (1010) to decimal
            assertEquals("10", Ex1.convert("1010", "2", "10"));
        }

        @Test
        void testDecimalToBinary() {
            // Convert decimal (10) to binary
            assertEquals("1010", Ex1.convert("10", "10", "2"));
        }
    
        @Test
        void testDecimalToHexadecimal() {
            // Convert decimal (255) to hexadecimal
            assertEquals("ff", Ex1.convert("255", "10", "16")); // Returns 255 because the result as an integer cannot store hex representation
        }

        void testHexadecimalToDecimal() {
            // Convert hexadecimal (FF) to decimal
            assertEquals("255", Ex1.convert("ff", "16", "10"));
        }
    
        @Test
        void testOctalToDecimal() {
            // Convert octal (377) to decimal
            assertEquals("255", Ex1.convert("377", "8", "10"));
        }
    

        @Test
        void testInvalidNumberFormat() {
            // Input number contains invalid characters
            assertThrows(NumberFormatException.class, () -> Ex1.convert("1G", "16", "10"));
        }
    
        @Test
        void testInvalidFromBaseFormat() {
            // Invalid from base
            assertThrows(NumberFormatException.class, () -> Ex1.convert("1010", "1", "10"));
        }
    
        @Test
        void testInvalidToBaseFormat() {
            // Invalid to base
            assertThrows(NumberFormatException.class, () -> Ex1.convert("1010", "2", "37"));
        }
    
        @Test
        void testNegativeNumber() {
            // Convert a negative binary number to decimal
            assertEquals("-10", Ex1.convert("-1010", "2", "10"));
        }
        
        //Testf for the equal function

        @Test
        void testEqualStrings() {
            // Test when both strings are exactly the same
            assertTrue(Ex1.equals("123", "123"));
            assertTrue(Ex1.equals("hello", "hello"));
            assertTrue(Ex1.equals("", ""));
        }
    
        @Test
        void testDifferentStrings() {
            // Test when strings have different values
            assertFalse(Ex1.equals("123", "124"));
            assertFalse(Ex1.equals("hello", "Hello")); // Case-sensitive
            assertFalse(Ex1.equals("a", "b"));
        }
    
        @Test
        void testNullStrings() {
            // Test null inputs
            assertThrows(NullPointerException.class, () -> Ex1.equals(null, "123"));
            assertThrows(NullPointerException.class, () -> Ex1.equals("123", null));
            assertThrows(NullPointerException.class, () -> Ex1.equals(null, null));
        }
    
        @Test
        void testSpecialCharacters() {
            // Test strings with special characters
            assertTrue(Ex1.equals("!@#$%", "!@#$%"));
            assertFalse(Ex1.equals("hello!", "hello"));
        }
    
        @Test
        void testWhitespaceStrings() {
            // Test strings with whitespaces
            assertTrue(Ex1.equals(" ", " "));
            assertFalse(Ex1.equals("hello ", "hello"));
            assertFalse(Ex1.equals(" hello", "hello"));
        }

        @Test
        public void testUnwrapNumberWithoutBase() {
            String input = "123";
            List<String> result = Ex1.unwrap(input);
            assertEquals(1, result.size());
            assertEquals("123", result.get(0));
        }

        @Test
        public void testUnwrapNumberWithBase() {
            String input = "123bA";
            List<String> result = Ex1.unwrap(input);
            assertEquals(2, result.size());
            assertEquals("123", result.get(0));
            assertEquals("A", result.get(1));
        }


        @Test
        public void testUnwrapEmptyInput() {
            String input = "";
            NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
                Ex1.unwrap(input);
            });
            assertNotNull(exception);
        }

        @Test
        public void testUnwrapNullInput() {
            String input = null;
            NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
                Ex1.unwrap(input);
            });
            assertNotNull(exception);
        }

        //Maxindex tests


        @Test
        public void testMaxIndexWithDuplicates() {
            String[] arr = {"10bA", "30bA", "30bA", "1bB"};
            int result = Ex1.maxIndex(arr);
            assertEquals(1, result); // First occurrence of the largest value "30bA"
        }

        @Test
        public void testMaxIndexWithSingleBase17Element() {
            String[] arr = {"42bA"};
            int result = Ex1.maxIndex(arr);
            assertEquals(0, result); // Only one element, so index 0
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

        //Toten function checks

        @Test
        public void testTotenWithNumberWithoutBase() {
            String input = "123";
            int result = Ex1.toten(input);
            assertEquals(123, result); // Expecting 123 in base 10
        }

        @Test
        public void testTotenWithNumberAndBase() {
            String input = "123bG";
            int result = Ex1.toten(input);
            assertEquals(291, result); // 123 in base 16 is 291 in base 10
        }

        @Test
        public void testTotenWithBase2() {
            String input = "1101b2";
            int result = Ex1.toten(input);
            assertEquals(13, result); // 1101 in base 2 is 13 in base 10
        }

        @Test
        public void testTotenWithBase10() {
            String input = "345bA";
            int result = Ex1.toten(input);
            assertEquals(345, result); // 345 in base 10 is still 345
        }

        @Test
        public void testTotenWithNullInput() {
            String input = null;
            assertThrows(NumberFormatException.class, () -> Ex1.toten(input));
        }

        @Test
        public void testTotenWithInvalidFormat() {
            String input = "123bx";
            assertThrows(NumberFormatException.class, () -> Ex1.toten(input));
        }

        @Test
        public void testTotenWithEmptyString() {
            String input = "";
            assertThrows(NumberFormatException.class, () -> Ex1.toten(input));
        }
        
        
    }
