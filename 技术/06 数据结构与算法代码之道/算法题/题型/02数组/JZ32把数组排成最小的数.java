

// 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323

 public String PrintMinNumber(int [] numbers) {
        int len = numbers.length;
        if (numbers == null || len == 0) {
            return "";
        }
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(str, new Comparator<String>(){
            //@Override
            public int compare(String str1, String str2) {
                String c1 = str1 + str2;
                String c2 = str2 + str1;
                return c1.compareTo(c2);
            }
        });
        for (int i = 0 ; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();

    }