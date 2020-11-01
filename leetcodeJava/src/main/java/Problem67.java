// 67. Add Binary

class Solution {
    public String addBinary(String a, String b) {
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        char[] res = new char[Math.max(num1.length, num2.length)];
        boolean carry = false;
        int i = num1.length - 1;
        int j = num2.length - 1;
        int k = res.length - 1;
        while ((i >= 0) && (j >= 0)) {
            int oneCount = 0;
            if (carry) {
                oneCount++;
            }
            if (num1[i] == '1') {
                oneCount++;
            }
            if (num2[j] == '1') {
                oneCount++;
            }
            if (oneCount % 2 == 0) {
                res[k--] = '0';
            } else {
                res[k--] = '1';
            }
            if (oneCount > 1) {
                carry = true;
            } else {
                carry = false;
            }
            i--;
            j--;
        }
        if (i >= 0) {
            while (i >= 0) {
                if (carry) {
                    if (num1[i] == '1') {
                        res[k--] = '0';
                        carry = true;
                    } else {
                        res[k--] = '1';
                        carry = false;
                    }
                } else {
                    res[k--] = num1[i];
                }
                i--;
            }
        } else if (j >= 0) {
            while (j >= 0) {
                if (carry) {
                    if (num2[j] == '1') {
                        res[k--] = '0';
                        carry = true;
                    } else {
                        res[k--] = '1';
                        carry = false;
                    }
                } else {
                    res[k--] = num2[j];
                }
                j--;
            }
        }
        if (carry) {
            char[] longerRes = new char[res.length + 1];
            longerRes[0] = '1';
            int x = 1;
            for (char c : res) {
                longerRes[x++] = c;
            }
            return new String(longerRes);
        }
        return new String(res);
    }
}