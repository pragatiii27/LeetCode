import java.util.*;

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[][] arr = new int[n][2];

        // {value, original index}
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] component = new int[n];
        int id = 0;

        component[arr[0][1]] = id;

        for (int i = 1; i < n; i++) {

            if (arr[i][0] - arr[i - 1][0] > maxDiff) {
                id++;
            }

            component[arr[i][1]] = id;
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            ans[i] = component[u] == component[v];
        }

        return ans;
    }
}