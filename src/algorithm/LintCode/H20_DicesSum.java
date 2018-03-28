package algorithm.LintCode;

import java.util.HashMap;
import java.util.Map;

public class H20_DicesSum {
    //    DecimalFormat df = new DecimalFormat("#.000000");
    double perValue = (double) 1 / 6;
    public Map<Integer, Double> dicesSum(int n) {
        Map<Integer, Double> perMap = new HashMap<>();
        if (n == 1) {
            for (int i = 0; i < 6; i++) {
                perMap.put(i + 1, perValue);
            }
        } else {
            Map<Integer, Double> perMapPer = dicesSum(n - 1);
            dicesSum(1).forEach((k1, v1) -> {
                perMapPer.forEach((k2, v2) -> {
                    if (!perMap.containsKey(k1 + k2)) {
                        perMap.put(k1 + k2, v1 * v2);
                    } else {
                        perMap.replace(k1 + k2, perMap.get(k1 + k2) + v1 * v2);
                    }
                });
            });
        }
        return perMap;
    }
}
