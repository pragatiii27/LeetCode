class Solution {
    public int singleNumber(int[] nums) {
          int xorResult = 0;


           // XOR all elements: duplicates cancel out, single remains
           for (int num : nums) {
               xorResult ^= num; // XOR operation
           }
           return xorResult;
   
    }
}