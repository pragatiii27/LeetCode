class Solution {

    long LIMIT;

    public String smallestPalindrome(String s, int k) {
        LIMIT = k;

        int[] cnt = new int[26];
        for (char c : s.toCharArray())
            cnt[c - 'a']++;

        String mid = "";
        int[] half = new int[26];
        int m = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1)
                mid = String.valueOf((char) ('a' + i));

            half[i] = cnt[i] / 2;
            m += half[i];
        }

        if (countWays(half, m) < k)
            return "";

        StringBuilder first = new StringBuilder();

        while (m > 0) {

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0)
                    continue;

                half[c]--;

                long ways = countWays(half, m - 1);

                if (ways >= k) {
                    first.append((char) ('a' + c));
                    m--;
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        String second = new StringBuilder(first).reverse().toString();

        return first.toString() + mid + second;
    }

    private long countWays(int[] half, int total) {

        long ans = 1;
        int remain = total;

        for (int i = 0; i < 26; i++) {

            int f = half[i];

            for (int j = 1; j <= f; j++) {
                ans = ans * remain / j;

                if (ans > LIMIT)
                    return LIMIT;

                remain--;
            }
        }

        return ans;
    }
}