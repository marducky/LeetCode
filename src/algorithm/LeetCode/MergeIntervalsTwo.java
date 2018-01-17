package algorithm.LeetCode;

import java.util.*;

public class MergeIntervalsTwo {
    public List<Interval> merge(List<Interval> intervals) {
        int inLen=intervals.size();
        List<Interval> intervalListTemp=new ArrayList<Interval>();
        //TODO: use other structure, because the map can't repeat.
        Map<Integer,Integer> integerIntegerMap=new TreeMap<Integer, Integer>();
        Map<Integer,Integer> integerIntegerMapTemp=new TreeMap<Integer, Integer>();
        for (int i=0;i<inLen;i++){
            integerIntegerMap.put(intervals.get(i).start,1);
            integerIntegerMap.put(intervals.get(i).end,-1);
        }
        int mapILen=integerIntegerMap.size();
        Set<Integer> integerSet=integerIntegerMap.keySet();
        Iterator<Integer> integerIterator=integerSet.iterator();
        int [] ints=new int[mapILen];
        int i=0;
        while (integerIterator.hasNext()){
//            System.out.println(integerIterator.next());
            ints[i]=Integer.valueOf(integerIterator.next());
            i++;

        }
        System.out.println(integerIntegerMap);
        System.out.println(Arrays.toString(ints));
        int sum=0;
        int kFlag=ints[0];
        for (int j=0;j<mapILen-1-1;j++){
            sum+=integerIntegerMap.get(ints[j]);
            if (sum==0){
                integerIntegerMapTemp.put(kFlag,ints[j]);
                kFlag=ints[j+1];
            }
        }
        integerIntegerMapTemp.put(kFlag,ints[mapILen-1]);
        System.out.println(integerIntegerMapTemp);
//        Set set=integerIntegerMap.entrySet();
//        Iterator iterator=set.iterator();
//        int [] ints=new int[inLen];
//        int i=0;
//        while (iterator.hasNext()){
//            Map.Entry me=(Map.Entry)iterator.next();
//            System.out.print(me.getKey());
//            ints[i]=me.getKey().toString().charAt(0);
//
//        }
//        System.out.print(Arrays.toString(ints));

        return null;
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

        MergeIntervalsTwo mergeIntervalsTwo=new MergeIntervalsTwo();
        System.out.print(mergeIntervalsTwo.merge(intervalList));
    }
}
