
// 第一次只出现一次的字符
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() < 1 || str.length() > 10000) {
            return -1;
        }
        LinkedHashMap<Character, Integer> link = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (!link.containsKey(str.charAt(i))) {
                link.put(str.charAt(i), 1);
            } else {
                link.put(str.charAt(i), link.get(str.charAt(i)) + 1);
                
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (link.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
