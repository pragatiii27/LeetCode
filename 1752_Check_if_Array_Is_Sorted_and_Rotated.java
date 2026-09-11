class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        // Try every possible rotation
        for (int k = 0; k < n; k++) {
            
            boolean sorted = true;

            // Check if this rotation is sorted
            for (int i = 0; i < n - 1; i++) {
                int current = nums[(i + k) % n];
                int next = nums[(i + 1 + k) % n];

                if (current > next) {
                    sorted = false;
                    break;
                }
            }

            // If any rotation is sorted
            if (sorted) {
                return true;
            }
        }

        return false;
    }
}