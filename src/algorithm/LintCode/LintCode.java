package algorithm.LintCode;

import org.junit.Before;
import org.junit.Test;

/**
 * @project: algorithm
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 14:24
 **/
public class LintCode {
    @Test
    public void m3() {
        M3_DigitCounts m3_digitCounts = new M3_DigitCounts();
        System.out.println(m3_digitCounts.digitCounts(50, 1));
    }

    @Test
    public void h20() {
        H20_DicesSum h20_dicesSum = new H20_DicesSum();
        System.out.println(h20_dicesSum.dicesSum(1));
    }

    //    @Before
    @Test
    public void h24() {
        H24_LFUCache h24_lfuCache = new H24_LFUCache(3);
        h24_lfuCache.set(2, 2);
        h24_lfuCache.set(1, 1);
        System.out.println(h24_lfuCache.toString());
        h24_lfuCache.set(3, 3);
        h24_lfuCache.set(4, 2);
        System.out.println(h24_lfuCache.toString());
        h24_lfuCache.set(5, 3);
        System.out.println(h24_lfuCache.toString());
        h24_lfuCache.set(6, 2);
        h24_lfuCache.set(7, 2);
        h24_lfuCache.set(8, 4);
        System.out.println(h24_lfuCache.toString());
        h24_lfuCache.set(8, 1);
        System.out.println(h24_lfuCache.toString());
    }

    @Test
    public void h24_2() {
        H24_LFUCacheTwo h24_lfuCache = new H24_LFUCacheTwo(3);
        h24_lfuCache.set(2, 2);
        h24_lfuCache.set(1, 1);
        h24_lfuCache.set(3, 3);
        h24_lfuCache.set(4, 2);
        h24_lfuCache.set(5, 3);
        h24_lfuCache.set(6, 2);
        h24_lfuCache.set(7, 2);
        h24_lfuCache.set(8, 4);
        h24_lfuCache.set(8, 1);
        System.out.println(h24_lfuCache.toString());
    }
}
