class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = (long) n * n;

        long expectedSum = N * (N + 1) / 2;
        long expectedSqSum = N * (N + 1) * (2 * N + 1) / 6;

        long actualSum = 0;
        long actualSqSum = 0;

        for (int[] row : grid) {
            for (int num : row) {
                actualSum += num;
                actualSqSum += (long) num * num;
            }
        }

        long diff = actualSum - expectedSum; // a - b

        long sqDiff = actualSqSum - expectedSqSum; // a² - b²

        long sum = sqDiff / diff; // a + b

        int repeating = (int) ((diff + sum) / 2);
        int missing = (int) (repeating - diff);

        return new int[]{repeating, missing};
    }
}