class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<Interval> merged = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            if(merged.isEmpty()){
                merged.add(new Interval(intervals[i][0], intervals[i][1]));
            }else{
                boolean overlapped = false;
                Interval newInv = new Interval(intervals[i][0], intervals[i][1]);
                int idx = 0;
                while(!overlapped && idx < merged.size()){
                    Interval inv = merged.get(idx);
                    if(inv.overlap(newInv)){
                        inv.merge(newInv);
                        overlapped = true;
                    }
                    idx++;
                }
                if(!overlapped){
                    merged.add(newInv);
                }
            }
        }
        int[][] result = new int[merged.size()][2];
        for(int i = 0; i < merged.size(); i++){
            Interval inv = merged.get(i);
            result[i][0] = inv.start;
            result[i][1] = inv.end;
        }
        return result;
    }

    
}

class Interval{
    int start;
    int end;

    public Interval(int start, int end){
        this.start = start;        
        this.end = end;
    }

    public boolean overlap(Interval other){
        return (this.start <= other.end && this.end >= other.start);
    }

    public void merge(Interval other){
        this.start = Math.min(this.start, other.start);
        this.end = Math.max(this.end, other.end);
    }
}