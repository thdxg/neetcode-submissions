/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

 /*
 ----
  --
   --
    --
 
 */

class Solution {
    // greedy
    // max concurrent meetings
    // sort intervals by start time
    // maxConcurrent = 1
    // for each interval
        // check how many times it overlaps with seen meetings
        // update maxConcurrent
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (!minheap.isEmpty() && minheap.peek() <= curr.start) {
                minheap.poll();
            }
            minheap.offer(curr.end);
        }
        return minheap.size();
    }
}
