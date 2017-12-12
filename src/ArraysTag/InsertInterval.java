package ArraysTag;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.xml.transform.Templates;

/*
 * Given a set of non-overlapping & sorted intervals, 
 * insert a new interval into the intervals (merge if necessary).
 * 即合并区间
 */
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class InsertInterval {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {  
        if(intervals==null||newInterval==null) {  
            return intervals;  
        }  
          
        if(intervals.size()==0) {  
            intervals.add(newInterval);  
            return intervals;  
        }  
          
        ListIterator<Interval> it = intervals.listIterator();  
        while(it.hasNext()) {  
            Interval tmpInterval = it.next();  
            if(newInterval.end<tmpInterval.start) {  
                it.previous();  
                it.add(newInterval);  
                return intervals;  
            } else {  
                if(tmpInterval.end<newInterval.start) {  
                    continue;  
                } else {  
                    newInterval.start = Math.min(tmpInterval.start, newInterval.start);  
                    newInterval.end   = Math.max(tmpInterval.end, newInterval.end);  
                    it.remove();  
                }  
            }  
        }  
        intervals.add(newInterval);  
        return intervals;  
    }  
}
