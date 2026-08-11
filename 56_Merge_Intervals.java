import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort by starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> ans = new ArrayList<>();

        for (int[] current : intervals) {

            // No overlap
            if (ans.isEmpty() || current[0] > ans.get(ans.size() - 1)[1]) {
                ans.add(current);
            }

            // Overlap
            else {
                ans.get(ans.size() - 1)[1] =
                    Math.max(ans.get(ans.size() - 1)[1], current[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}