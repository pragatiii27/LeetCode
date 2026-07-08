class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] digitSum = new int[n + 1];
        int[] nonZeroCnt = new int[n + 1];
        long[] concat = new long[n + 1];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            digitSum[i + 1] = digitSum[i] + d;
            nonZeroCnt[i + 1] = nonZeroCnt[i] + (d != 0 ? 1 : 0);

            if (d != 0) {
                concat[i + 1] = (concat[i] * 10 + d) % MOD;
            } else {
                concat[i + 1] = concat[i];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int sum = digitSum[r + 1] - digitSum[l];
            int nz = nonZeroCnt[r + 1] - nonZeroCnt[l];

            long x = (concat[r + 1]
                    - concat[l] * pow10[nz] % MOD
                    + MOD) % MOD;

            ans[i] = (int) (x * sum % MOD);
        }

        return ans;
    }
}