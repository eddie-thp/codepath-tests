package week1.challenges;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * https://www.interviewbit.com/problems/merge-intervals/
 * <pre>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * 
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 * 
 * Example 2:
 * 
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * Make sure the returned intervals are also sorted.
 * </pre>
 *
 */
public class Challenge10 {
	public static void main(String args[]) {
		Challenge10 c = new Challenge10();

		ArrayList<Interval> a = new ArrayList<Interval>();
		a.add(new Interval(2,3));
		a.add(new Interval(6,7));
		a.add(new Interval(10,11));

		System.out.println("MERGE: " + c.insert(a, new Interval(4,5)));
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		Iterator<Interval> intervalsIterator = intervals.iterator();

		int index = 0;
		while (intervalsIterator.hasNext()) {
			Interval i = intervalsIterator.next();

			if (newInterval.start > i.end) {
				index++;
				continue;
			} else {
				if (newInterval.end < i.start) {
					break;
				}

				intervalsIterator.remove();

				if (newInterval.start > i.start) {
					// Merging
					newInterval.start = i.start;
				}

				if (newInterval.end <= i.end) {
					newInterval.end = i.end;
					break;
				}

			}

		}

		intervals.add(index, newInterval);

		return intervals;
	}
}

/**
 * Definition for an interval.
 */
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
	
	public String toString() {
		return String.format("(%d, %d)", start, end);
	}
}