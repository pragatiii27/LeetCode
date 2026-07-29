class Solution {

    long LIMIT;

    public String smallestPalindrome(String s, int k) {
        LIMIT = k;

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int[] half = new int[26];
        int halfLen = 0;
        String mid = "";

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                mid = "" + (char) ('a' + i);
            }
            half[i] = freq[i] / 2;
            halfLen += half[i];
        }

        if (countWays(half, halfLen) < k)
            return "";

        StringBuilder first = new StringBuilder();

        while (halfLen > 0) {

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0)
                    continue;

                half[c]--;

                long ways = countWays(half, halfLen - 1);

                if (ways >= k) {
                    first.append((char) ('a' + c));
                    halfLen--;
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

            if (half[i] == 0)
                continue;

            ans *= comb(remain, half[i]);

            if (ans >= LIMIT)
                return LIMIT;

            remain -= half[i];
        }

        return ans;
    }

    private long comb(int n, int r) {

        if (r > n)
            return 0;

        r = Math.min(r, n - r);

        long res = 1;

        for (int i = 1; i <= r; i++) {

            long num = n - r + i;
            long den = i;

            long g = gcd(num, den);
            num /= g;
            den /= g;

            g = gcd(res, den);
            res /= g;
            den /= g;

            if (res > LIMIT / num)
                return LIMIT;

            res *= num;
            res /= den;

            if (res >= LIMIT)
                return LIMIT;
        }

        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}