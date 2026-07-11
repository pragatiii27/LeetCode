class Solution {
    public void sortColors(int[] nums) {
       
        int n=nums.length;
        int left= nums[0];
        int right= nums[n-1];

        while(left<n && right>0){
            if(nums[left]> nums[right]){
                int temp = nums[left];
                nums[left]= nums[right];
                nums[right]= nums[temp];

            }
            left++;
            right--;
        }
    }
}