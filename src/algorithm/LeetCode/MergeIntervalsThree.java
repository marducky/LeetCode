package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsThree {
    public class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<Interval>();
        if (intervals.size() == 0) return ans;

        Collections.sort(intervals, new MyComparator());

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 0; i < intervals.size(); i++) {
            Interval inter = intervals.get(i);
            if (inter.start > end) {
                ans.add(new Interval(start, end));
                start = inter.start;
                end = inter.end;
            } else {
                end = Math.max(end, inter.end);
            }
        }
        ans.add(new Interval(start, end));
        for (int i=0;i<ans.size();i++){
            System.out.println("["+ans.get(i).start+","+ans.get(i).end+"]");
        }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args){
        Interval[] GiveIntervals=new Interval[8];
        GiveIntervals[0]=new Interval(1,3);
        GiveIntervals[5]=new Interval(4,6);
        GiveIntervals[4]=new Interval(2,7);
        GiveIntervals[1]=new Interval(2,6);
        GiveIntervals[2]=new Interval(8,10);
        GiveIntervals[6]=new Interval(9,10);
        GiveIntervals[3]=new Interval(11,12);
        GiveIntervals[7]=new Interval(14,16);
//        int i=intervals[0].start;
        List<Interval> intervalList=new ArrayList<Interval>();
        intervalList.add(GiveIntervals[0]);
        intervalList.add(GiveIntervals[1]);
        intervalList.add(GiveIntervals[2]);
        intervalList.add(GiveIntervals[3]);
        intervalList.add(GiveIntervals[4]);
        intervalList.add(GiveIntervals[5]);
        intervalList.add(GiveIntervals[6]);
        intervalList.add(GiveIntervals[7]);

        MergeIntervalsThree mergeIntervalsThree=new MergeIntervalsThree();
        System.out.print(mergeIntervalsThree.merge(intervalList).toString());
    }
}
