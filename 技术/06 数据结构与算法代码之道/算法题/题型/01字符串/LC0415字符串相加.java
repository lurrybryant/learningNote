public String addStrings(String num1, String num2) {
 2    int sum = 0, i = num1.length() - 1, j = num2.length() - 1;
 3    StringBuilder str = new StringBuilder();
 4    while (i >= 0 || j >= 0 || sum > 0) {
 5        if (i >= 0) sum += (num1.charAt(i--) - '0');
 6        if (j >= 0) sum += (num2.charAt(j--) - '0');
 7        str.insert(0, sum % 10);
 8        sum /= 10;
 9    }
10    return str.toString();
11}