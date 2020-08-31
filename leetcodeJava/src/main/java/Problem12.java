// 12. Integer to Roman

class Solution {
    public String intToRoman(int num) {
        if (num == 0) {
            return "";
        }
        
        Map<Integer, String> ht = new HashMap<Integer, String>();
        ht.put(1, "I");
        ht.put(5, "V");
        ht.put(10, "X");
        ht.put(50, "L");
        ht.put(100, "C");
        ht.put(500, "D");
        ht.put(1000, "M");
        ht.put(4, "IV");
        ht.put(9, "IX");
        ht.put(40, "XL");
        ht.put(90, "XC");
        ht.put(400, "CD");
        ht.put(900, "CM");
        
        StringBuilder res = new StringBuilder();
        int[] numberValues = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int i = 0;
        
        while (num > 0) {
            if (numberValues[i] <= num) {
                res.append(ht.get(numberValues[i]));
                num -= numberValues[i];
            } else {
                i++;
            }
        }
        return res.toString();
    }
}