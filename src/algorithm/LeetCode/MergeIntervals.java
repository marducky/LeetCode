/**
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
package algorithm.LeetCode;

import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        int inLen=intervals.size();
        List<Interval> intervalListTemp=new ArrayList<Interval>();
        Map<Integer,Integer> integerIntegerMap=new TreeMap<Integer, Integer>();
        Map<Integer,Integer> integerIntegerMapTemp=new TreeMap<Integer, Integer>();
        for (int i=0;i<inLen;i++){
            integerIntegerMap.put(intervals.get(i).start,1);
            integerIntegerMap.put(intervals.get(i).end,-1);
        }
        Integer [] ints=new Integer[inLen];
        System.out.print(integerIntegerMap.keySet().toArray(ints)[0].getClass().getName());
//        int resStart=Integer.valueOf(integerIntegerMap.keySet().toString().charAt(0));
//        int resStart=Integer.valueOf(integerIntegerMap.keySet().toArray()[0]);
//        int resStart=Integer.valueOf(ints[0]);
        int resStart=0;
        //TODO: change the format.
//        int resEnd=Integer.valueOf(integerIntegerMap.keySet().toString().charAt(0));
//        int sum=integerIntegerMap.get(Integer.valueOf(integerIntegerMap.keySet().toString().charAt(0)));
        int sumTemp=0;
        int i=0;
        for (int giveStart:integerIntegerMap.keySet()){
            sumTemp+=integerIntegerMap.get(giveStart);
            i++;
            if (sumTemp==0&&i<integerIntegerMap.size()){
                integerIntegerMapTemp.put(resStart,giveStart);
                resStart=ints[i];
//                resStart=Integer.valueOf(integerIntegerMap.keySet().toString().charAt(i));
            }
        }
//        integerIntegerMapTemp.put(resStart,Integer.valueOf(integerIntegerMap.keySet().toString().charAt(i-1)));
        integerIntegerMapTemp.put(resStart,ints[inLen-1]);
//        for (int i=0;i<integerIntegerMap.size();i++){
//
//
//        }

        System.out.print(integerIntegerMap);
        System.out.print(integerIntegerMapTemp);
        return null;
    }
    public static void main(String[] args){
        Interval[] GiveIntervals=new Interval[4];
        GiveIntervals[0]=new Interval(1,3);
        GiveIntervals[1]=new Interval(2,6);
        GiveIntervals[2]=new Interval(8,10);
        GiveIntervals[3]=new Interval(11,12);
//        int i=intervals[0].start;
        List<Interval> intervalList=new ArrayList<Interval>();
        intervalList.add(GiveIntervals[0]);
        intervalList.add(GiveIntervals[1]);
        intervalList.add(GiveIntervals[2]);
        intervalList.add(GiveIntervals[3]);
        MergeIntervals mergeIntervals=new MergeIntervals();
        System.out.print(mergeIntervals.merge(intervalList));
    }
}
