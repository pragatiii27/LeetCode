import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        long[] freq = new long[max + 1];
        for (int x : nums) freq[x]++;

        long[] cnt = new long[max + 1];

        // Count numbers divisible by i
        for (int i = 1; i <= max; i++) {
            long c = 0;
            for (int j = i; j <= max; j += i) {
                c += freq[j];
            }
            cnt[i] = c * (c - 1) / 2;
        }

        // Count pairs with GCD exactly i
        long[] exact = new long[max + 1];
        for (int i = max; i >= 1; i--) {
            exact[i] = cnt[i];
            for (int j = i * 2; j <= max; j += i) {
                exact[i] -= exact[j];
            }
        }

        // Prefix count of gcd values
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            long k = queries[q] + 1; // 0-indexed query

            int l = 1, r = max;
            while (l < r) {
                int mid = l + (r - l) / 2;

                if (prefix[mid] >= k)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[q] = l;
        }

        return ans;
    }
}