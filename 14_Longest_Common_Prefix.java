class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Take the first string as reference
        String first = strs[0];

        // Traverse every character of the first string
        for (int i = 0; i < first.length(); i++) {

            // Compare this character with every other string
            for (int j = 1; j < strs.length; j++) {

                // If the current string is shorter than i
                if (i == strs[j].length()) {
                    return first.substring(0, i);
                }

                // If characters don't match
                if (first.charAt(i) != strs[j].charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }

        // Entire first string is the common prefix
        return first;
    }
}