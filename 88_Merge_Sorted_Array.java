class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
      int size = m + n;
           int index = size - 1;
           int i = m - 1;
           int j = n - 1;


           // Merge from the end of both arrays
           while (i >= 0 && j >= 0) {
               if (nums1[i] <= nums2[j]) {
                   nums1[index--] = nums2[j--];
               } else {
                   nums1[index--] = nums1[i--];
               }
           }


           // Copy remaining elements from nums2 (if any)
           while (j >= 0) {
               nums1[index--] = nums2[j--];
           }
       }
   }

