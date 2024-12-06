import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.max;

public class Test {
    public static void main (String[] args) {
    }
    public static List<String> convert(int number, int base) {
        if (base > 0) {
            List<String> result = new ArrayList<>();
            int res = number;
            boolean ifrun = true;
            while (ifrun) {
                if (res < base) {
                    ifrun = false;
                }
                String value = String.valueOf(res % base);
                int intvalue = res % base;
                if (intvalue>9 && intvalue<16) {
                    if (intvalue == 10){
                        value = "A";
                    }
                    if (intvalue == 11){
                        value = "B";
                    }
                    if (intvalue == 12){
                        value = "C";
                    }
                    if (intvalue == 13){
                        value = "D";
                    }
                    if (intvalue == 14){
                        value = "E";
                    }
                    if (intvalue == 15){
                        value = "F";
                    }

                }
                result.add(0, value);
                res = res / base;
            }
            if (result.size() > 0) {
                return result;
            }
        }
        return null;
    }
}
