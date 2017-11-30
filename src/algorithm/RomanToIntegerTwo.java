package algorithm;

public class RomanToIntegerTwo {
    private int[] val = new int[255];
    private void init() {
        val['I'] = 1; val['V'] = 5; val['X'] = 10; val['L'] = 50;
        val['C'] = 100; val['D'] = 500; val['M'] = 1000;
    }

    public int romanToInt(String s) {
        init();
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && val[s.charAt(i)] > val[s.charAt(i - 1)]) {
                ret += val[s.charAt(i)] - 2 * val[s.charAt(i - 1)];
            } else {
                ret += val[s.charAt(i)];
            }
        }
        return ret;
    }
}
