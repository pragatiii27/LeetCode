class Solution {
    public String smallestPalindrome(String s) {

        int[] freq = new int[26];

        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        // Build left half and middle
        for (int i = 0; i < 26; i++) {

            // Add half of the characters
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }

            // If frequency is odd, this is the middle character
            if (freq[i] % 2 == 1) {
                middle = String.valueOf((char) ('a' + i));
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + middle + right;
    }
}