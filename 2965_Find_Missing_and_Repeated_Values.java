class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;

        int[] freq = new int[n * n + 1];

        // Count frequency of each number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        int repeating = -1;
        int missing = -1;

        // Find repeating and missing numbers
        for (int i = 1; i <= n * n; i++) {
            if (freq[i] == 2) {
                repeating = i;
            } else if (freq[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeating, missing};
    }
}